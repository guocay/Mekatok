package com.github.guokaia.mekatok.microservice;

import com.github.guokaia.mekatok.common.Global;
import com.github.guokaia.mekatok.common.foreign.Exceptions;
import com.github.guokaia.mekatok.common.foreign.GeneralForeign;
import com.github.guokaia.mekatok.context.json.JsonFormatHolder;
import com.github.guokaia.mekatok.microservice.exception.ProviderException;
import feign.Logger;
import feign.Request;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * 关于 feign 的 默认配置 <br/>
 * 一定不要为 feign 配置默认的 Encoder 和 Decoder, 让它复用{@link org.springframework.http.converter.HttpMessageConverter}<br/>
 * 参考 {@link org.springframework.cloud.openfeign.FeignClientsConfiguration}
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/2
 */
public class OpenFeignDefaultConfiguration {

    /**
     * 异常信息
     */
    private static final String EXCEPTION_MESSAGE = "Feign服务间调用异常";

    /**
     * 设置 feign 的日志级别
     * @return 日志级别
     */
    @Bean
    public Logger.Level openFeignLoggerLevel(){
        return Logger.Level.BASIC;
    }

    /**
     * 配置请求的超时配置
     * @return 请求配置项
     */
    @Bean
    public Request.Options openFeignRequestOption(){
        /*
            第一,二个参数: 连接超时 3秒
            第三,四个参数: 读取超时 6秒
            第五个参数: 是否适用于重定向
         */
        return new Request.Options(3L, SECONDS, 6L, SECONDS, true);
    }

    /**
     * 配置 feign 的客户端重试机制
     * @return 重试
     */
    @Bean
    public Retryer openFeignRetryer(){
        /*
            第一个参数表示立即重试
            第二个参数表示最大重试间隔 1秒
            第三个参数表示重试次数
         */
        return new Retryer.Default(0, SECONDS.toMillis(1), 1);
    }

    /**
     * 配置默认的异常转换器
     * @return 异常转换器
     */
    @Bean
    public ErrorDecoder openFeignErrorDecoder(){
        return (methodKey, response) ->
                 Exceptions.run(()-> {
                    byte[] body = feign.Util.toByteArray(response.body().asInputStream());
                    String messageBody = new String(body, Global.DEFAULT_CHARSET);
                    GeneralForeign<?> foreign = JsonFormatHolder.get().readValue(messageBody, GeneralForeign.class);
                    return new ProviderException(String.format("%s: %s", EXCEPTION_MESSAGE, foreign.getMessage()));
                });
    }
}
