package com.github.kfcfans.powerjob.worker.common.utils;

import org.springframework.context.ApplicationContext;

import java.util.Objects;

/**
 * Spring ApplicationContext 工具类
 *
 * @author tjq
 * @since 2020/3/16
 */
public class SpringUtils {

    private static boolean supportSpringBean = false;

    private static ApplicationContext context;

    public static void inject(ApplicationContext ctx) {
        context = ctx;
        supportSpringBean = true;
    }

    public static boolean supportSpringBean() {
        return supportSpringBean;
    }

    public static <T> T getBean(Class<T> clz) {
        return context.getBean(clz);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String className) throws Exception {

        // 1. ClassLoader 存在，则直接使用 clz 加载
        ClassLoader classLoader = context.getClassLoader();
        if (classLoader != null) {
            return (T) context.getBean(classLoader.loadClass(className));
        }
        // 2. ClassLoader 不存在(系统类加载器不可见)，尝试用类名称小写加载
        String[] split = className.split("\\.");
        String beanName = split[split.length - 1];
        // 小写转大写
        char[] cs = beanName.toCharArray();
        cs[0] += 32;
        return (T) context.getBean(String.valueOf(cs));
    }

}
