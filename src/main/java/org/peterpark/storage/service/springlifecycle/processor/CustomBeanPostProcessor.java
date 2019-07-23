package org.peterpark.storage.service.springlifecycle.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author: peter
 * @date: 2019/1/21.
 */
public class CustomBeanPostProcessor implements BeanPostProcessor {

    public CustomBeanPostProcessor() {
        super();
        System.out.println("[进入BeanPostProcessor构造]BeanPostProcessor构造实现类构造器！！");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[接口BeanPostProcessor.postProcessBeforeInitialization]");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[接口BeanPostProcessor.postProcessAfterInitialization]");
        return bean;
    }
}
