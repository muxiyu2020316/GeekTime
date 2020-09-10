package com.com.muxiyu.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.stream.Stream;

public class BeanInfoDemo {
    public static void main(String[] args) throws IntrospectionException {
        //获取配置的源信息
        BeanInfo beanInfo= Introspector.getBeanInfo(Person.class,Object.class);
        Stream.of(beanInfo.getPropertyDescriptors())
        .forEach(propertyDescriptor -> {
            System.out.println(propertyDescriptor);
        });
        //spring 实现类型转换,通过信息拦截,然后把相应的类型转换.
    }
}
