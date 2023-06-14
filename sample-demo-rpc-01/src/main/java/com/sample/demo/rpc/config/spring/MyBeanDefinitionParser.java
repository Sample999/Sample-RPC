package com.sample.demo.rpc.config.spring;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @description:
 * @author: sample
 * @date: 2023/6/14
 */
public class MyBeanDefinitionParser implements BeanDefinitionParser {

    private final Class<?> beanClass;

    MyBeanDefinitionParser(Class<?> beanClass) {
        this.beanClass = beanClass;
    }


    /**
     * 解析XML定义Bean
     *
     * @param element
     * @param parserContext
     * @return
     */
    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        // 创建一个RootBeanDefinition对象，并设置其类名和是否延迟初始化的属性
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(beanClass);
        beanDefinition.setLazyInit(true);
        String beanName = element.getAttribute("id");
        // 注册BeanDefinition到BeanFactory中
        parserContext.getRegistry().registerBeanDefinition(beanName, beanDefinition);

        for (Method method : beanClass.getMethods()) {
            if(!isProperty(method, beanClass)) continue;
            String name = method.getName();
            String methodName = name.substring(3,4).toLowerCase() + name.substring(4);
            String value = element.getAttribute(methodName);
            beanDefinition.getPropertyValues().addPropertyValue(methodName, value);
        }

        return beanDefinition;
    }

    /**
     * 判断给定的方法是否是Java Bean的属性方法
     * 方法名必须以"set"开头，且方法的参数只有一个；同时，还需要存在一个对应的"get"或"is"方法，且返回值类型必须与属性类型一致。
     * 如果满足这些条件，则返回true，否则返回false。
     *
     * @param method
     * @param beanClass
     * @return
     * @author: sample
     * @date: 2023/6/14
     */
    private boolean isProperty(Method method, Class beanClass) {

        String methodName = method.getName();
        boolean flag = methodName.length() > 3 && methodName.startsWith("set") && Modifier.isPublic(method.getModifiers()) && method.getParameterTypes().length == 1;
        Method getter = null;
        if (!flag) return false;

        Class<?> type = method.getParameterTypes()[0];
        try {
            getter = beanClass.getMethod("get" + methodName.substring(3));
        } catch (NoSuchMethodException ignore) {

        }

        if (null == getter) {
            try {
                getter = beanClass.getMethod("is" + methodName.substring(3));
            } catch (NoSuchMethodException ignore) {

            }
        }

        flag = getter != null && Modifier.isPublic(getter.getModifiers()) && type.equals(getter.getReturnType());

        return flag;

    }
}
