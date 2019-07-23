package org.peterpark.storage.service.springlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Description: 探索Spring生命周期支持的Hook钩子，探究postConstruct/preDestroy/BeanFactoryPostProcessor/BeanPostProcessor
 * InitializeBean/DisposableBean/自定义init-method
 *
 * @author: peter
 * @date: 2019/1/21.
 */
@Component
public class SpringHook implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String name;

    private String mobile;

    static {
        System.out.println("[静态代码块]调用静态块");
    }

    public SpringHook() {
        System.out.println("[构造器]调用构造器，实例化");
    }

    {
        System.out.println("[构造代码块]调用构造块");
    }

    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    public SpringHook initMethod() {
        return new SpringHook();
    }

    @PostConstruct
    public void notice() {
        System.out.println("[后构造器]post construct method started!");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("[前销毁器]pre destroy method started!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("[属性注入] name=" + name);
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        System.out.println("[属性注入] mobile=" + mobile);
        this.mobile = mobile;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("[接口DisposableBean.destroy() ]");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("[接口InitializingBean.afterPropertiesSet() ]");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("[接口BeanNameAware.setBeanName() ]");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("[接口BeanFactoryAware.setBeanFactory()]");
    }

    public void customInit() {
        System.out.println("[自定义初始init-method]调用<bean>的init-method属性指定的初始化方法");
    }

    public void customDestroy() {
        System.out.println("[自定义销毁destroy-method]调用<bean>的destroy-method属性指定的销毁方法");
    }
}
