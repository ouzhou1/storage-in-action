package org.peterpark.storage.service.springlifecycle.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

/**
 * Description:
 *
 * @author: peter
 * @date: 2019/1/21.
 */
@Component
public class CustomInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    public CustomInstantiationAwareBeanPostProcessor() {
        super();
        System.out.println("[InstantiationAwareBeanPostProcessorAdapter实现类构造器]");
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("[实例化Bean之前调用]InstantiationAwareBeanPostProcessor调用postProcessBeforeInstantiation方法beanName=" + beanName);
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[实例化Bean之后调用]InstantiationAwareBeanPostProcessor调用postProcessAfterInitialization方法beanName=" + beanName);
        return bean;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName)
            throws BeansException {
        System.out.println("[postProcessPropertyValues方法]InstantiationAwareBeanPostProcessor调用postProcessPropertyValues方法 pvs=" + pvs + ",beanName=" + beanName);
        return pvs;
    }
}
