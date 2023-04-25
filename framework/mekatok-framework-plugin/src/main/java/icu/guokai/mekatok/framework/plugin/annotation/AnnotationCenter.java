package icu.guokai.mekatok.framework.plugin.annotation;

import icu.guokai.mekatok.framework.core.constant.Global;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.reflections.Reflections;
import org.reflections.scanners.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;

/**
 * 用于获取注解的工具类
 * @author GuoKai
 * @date 2021/8/16
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AnnotationCenter extends cn.hutool.core.annotation.AnnotationUtil {
    /**
     * 注解扫描器
     */
    private static final Reflections REFLECTIONS = new Reflections(
            Global.BASIC_PACKAGE_NAME,
            Arrays.asList(
                    // 允许getAllTypes获取所有Object的子类,不设置为false则getAllTypes 会报错,默认为true
                    new SubTypesScanner(false),
                    // 设置方法参数名称扫描器,否则调用getConstructorParamNames 会报错
                    new MethodParameterNamesScanner(),
                    // 设置方法注解扫描器,否则getConstructorsAnnotatedWith,getMethodsAnnotatedWith 会报错
                    new MethodAnnotationsScanner(),
                    // 设置member扫描器, 否则getMethodUsage会报错,不推荐使用
                    // 有可能会报错 java.lang.ClassCastException
                    new MemberUsageScanner(),
                    // 设置类注解扫描器,否则 getTypesAnnotatedWith会报错
                    new TypeAnnotationsScanner()
            )
    );

    /**
     * 根据注解获取使用了这个注解的函数
     * @param anno 注解
     * @return 函数集合
     */
    public static Set<Method> getMethodByAnnotation(Class<? extends Annotation> anno){
        return REFLECTIONS.getMethodsAnnotatedWith(anno);
    }

    /**
     * 根据注解获取使用了这个注解的函数
     * @param anno 注解
     * @return 类集合
     */
    public static Set<Class<?>> getTypeByAnnotation(Class<? extends Annotation> anno){
        return REFLECTIONS.getTypesAnnotatedWith(anno);
    }
}
