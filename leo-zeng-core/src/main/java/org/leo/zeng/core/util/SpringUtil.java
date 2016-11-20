package org.leo.zeng.core.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

public class SpringUtil implements ApplicationContextAware, EmbeddedValueResolverAware {

    private static ApplicationContext applicationContext;
    private static StringValueResolver resolver;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtil.applicationContext = applicationContext;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        SpringUtil.resolver = resolver;
    }

    /**
     * 获取Spring上下文对象
     * @return Spring上下文对象
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 获取Spring管理的对象
     * @param clazz 对象类型
     * @return 结果对象
     */
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    /**
     * 获取Spring管理的对象
     * @param name 对象名
     * @return 结果对象
     */
    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    /**
     * 获取Spring管理的对象
     * @param name 对象名
     * @param clazz 对象类型
     * @return 结果对象
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return applicationContext.getBean(name, clazz);
    }

    /**
     * 获取Spring管理的对象
     * @param name 对象名
     * @param args 参数
     * @return 结果对象
     */
    public static Object getBean(String name, Object... args) {
        return applicationContext.getBean(name, args);
    }

    /**
     * 获取Spring管理的对象
     * @param clazz 对象类型
     * @param args 参数
     * @return 结果对象
     */
    public static <T> T getBean(Class<T> clazz, Object... args) {
        return applicationContext.getBean(clazz, args);
    }

    /**
     * 获取Properties配置文件的内容
     * @param name 键名
     * @return 键值
     */
    public static String getPropertiesValue(String name) {
        return resolver.resolveStringValue(name);
    }

}
