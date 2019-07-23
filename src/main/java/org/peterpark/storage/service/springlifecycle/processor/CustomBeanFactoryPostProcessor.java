package org.peterpark.storage.service.springlifecycle.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * Description: 自定义BeanFactoryPostProcessor,添加注入属性
 *
 * @author: peter
 * @date: 2019/1/21.
 */
@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public CustomBeanFactoryPostProcessor() {
        super();
        System.out.println("[CustomBeanFactoryPostProcessor工厂后处理器]BeanFactoryPostProcessor实现类构造器！！");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("[CustomBeanFactoryPostProcessor工厂后处理器]BeanFactoryPostProcessor.postProcessBeanFactory()获取bean定义后添加属性mobile=110");
        BeanDefinition bd = configurableListableBeanFactory.getBeanDefinition("springHook");
        bd.getPropertyValues().addPropertyValue("mobile", "110");
    }
}
