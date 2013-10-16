package com.johnsully83.utility;

import groovy.lang.GroovyObject;

import org.springframework.aop.framework.autoproxy.AutoProxyUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.CannotLoadBeanClassException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.ClassUtils;

public class GroovyObjectTargetClassPreservingBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		for (String beanDefName : beanFactory.getBeanDefinitionNames()) {
			BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefName);

			if (beanDefinition.isAbstract()) {
				continue;
			}
			String className = beanDefinition.getBeanClassName();

			if (className == null) {
				continue;
			}
			
			Class<?> beanClass;
			
			try {
				beanClass = ClassUtils.forName(className, beanFactory.getBeanClassLoader());
			} catch (ClassNotFoundException e) {
				throw new CannotLoadBeanClassException(beanDefinition.getResourceDescription(), beanDefName, beanDefinition.getBeanClassName(), e);
			} catch (LinkageError e) {
				throw new CannotLoadBeanClassException(beanDefinition.getResourceDescription(), beanDefName, beanDefinition.getBeanClassName(), e);
			}

			Class<?>[] interfaces = beanClass.getInterfaces();
			
			if (interfaces.length == 1 && interfaces[0] == GroovyObject.class) {
				beanDefinition.setAttribute(AutoProxyUtils.PRESERVE_TARGET_CLASS_ATTRIBUTE, true);
			}
		}
	}
	
}