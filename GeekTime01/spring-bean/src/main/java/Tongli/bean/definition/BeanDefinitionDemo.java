package Tongli.bean.definition;

import muxiyu.overview.dependency.Domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 *
 * BeanDefinitionDemo 构建
 */
public class BeanDefinitionDemo {
    public static void main(String[] args) {
        //User user=null;
        BeanDefinitionBuilder beanDefinitionBuilder=BeanDefinitionBuilder.genericBeanDefinition(User.class);
        //通过属性设置操作
        beanDefinitionBuilder.addPropertyValue("name","佟莉");
        beanDefinitionBuilder.addPropertyValue("id",1);
        //获取BeanDefintion实例
       BeanDefinition beanDefinition= beanDefinitionBuilder.getBeanDefinition();
       //BeanDefinition 不是Bean的终极状态,可以自定义修改

        //可以通过AbstractBeanDefinition 和他们的派生类
        GenericBeanDefinition genericBeanDefinition=new GenericBeanDefinition();
        //设置Bean的类型,基本上Bean的类要是一个具体类
        genericBeanDefinition.setBeanClass(User.class);
        // 通过 MutablePropertyValues 批量操作属性
        MutablePropertyValues propertyValues = new MutablePropertyValues();
//        propertyValues.addPropertyValue("id", 1);
//        propertyValues.addPropertyValue("name", "小马哥");
        propertyValues
                .add("id", 1)
                .add("name", "小马哥");
        // 通过 set MutablePropertyValues 批量操作属性
        genericBeanDefinition.setPropertyValues(propertyValues);
    }
}
