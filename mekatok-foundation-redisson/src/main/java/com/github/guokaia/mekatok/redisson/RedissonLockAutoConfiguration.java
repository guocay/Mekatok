package com.github.guokaia.mekatok.redisson;

import com.github.guokaia.mekatok.redisson.lock.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.redisson.api.RLock;
import org.redisson.api.RSemaphore;
import org.redisson.api.RedissonClient;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * 基于AOP实现通过注解进行锁操作
 * @author GuoKai
 * @date 2022/2/21
 */
@Aspect
@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter(RedissonAutoConfiguration.class)
public class RedissonLockAutoConfiguration {

    /**
     * redisson 客户端
     */
    private final RedissonClient client;

    public RedissonLockAutoConfiguration(RedissonClient client) {
        this.client = client;
    }

    @Around("@annotation(lock)")
    public Object lock(ProceedingJoinPoint point, Lock lock) throws Throwable {
        String lockName = lock.value();
        RLock rLock = lock.isFair() ? client.getFairLock(lockName) : client.getLock(lockName);
        try {
            rLock.lock(lock.autoUnlockSeconds(), TimeUnit.SECONDS);
            return point.proceed();
        }finally{
            rLock.unlock();
        }
    }

    @Around("@annotation(lock)")
    public Object readLock(ProceedingJoinPoint point, ReadLock lock) throws Throwable {
        RLock rLock = client.getReadWriteLock(lock.value()).readLock();
        try {
            rLock.lock(lock.autoUnlockSeconds(), TimeUnit.SECONDS);
            return point.proceed();
        }finally{
            rLock.unlock();
        }
    }

    @Around("@annotation(lock)")
    public Object writeLock(ProceedingJoinPoint point, WriteLock lock) throws Throwable {
        RLock rLock = client.getReadWriteLock(lock.value()).writeLock();
        try {
            rLock.lock(lock.autoUnlockSeconds(), TimeUnit.SECONDS);
            return point.proceed();
        }finally{
            rLock.unlock();
        }
    }

    @Around("@annotation(lock)")
    public Object countDownLock(ProceedingJoinPoint point, CountDownLock lock) throws Throwable {
        client.getCountDownLatch(lock.value()).await();
        return point.proceed();
    }

    @Around("@annotation(semaphore)")
    public Object semaphore(ProceedingJoinPoint point, Semaphore semaphore) throws Throwable {
        int permits = semaphore.permits();
        RSemaphore rSemaphore = client.getSemaphore(semaphore.value());
        try {
            rSemaphore.acquire(permits);
            return point.proceed();
        }finally{
            rSemaphore.addPermits(permits);
        }
    }
}
