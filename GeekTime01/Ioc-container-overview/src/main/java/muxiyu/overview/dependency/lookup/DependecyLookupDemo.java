package muxiyu.overview.dependency.lookup;

import muxiyu.overview.dependency.Domain.SuperUser;
import muxiyu.overview.dependency.Domain.User;
import muxiyu.overview.dependency.annotation.Super;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;
public class DependecyLookupDemo {
    public static void main(String[] args) {
    //配置xml文件
    //启动Spring 应用上下文
        //第一种实现方式 BeanFactory
        BeanFactory beanFactory= new ClassPathXmlApplicationContext("LookUp.xml");
        User user= (User) beanFactory.getBean("user");
        //第二种实现方式
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("LookUp.xml");
        SuperUser user2= (SuperUser) applicationContext.getBean("superuser");
        System.out.println(user);
        //总结 把对象交个ioc 容器管理但是你要注意对象不要写错
        lookupInLazy(beanFactory);
        // 通过注解查找对象
        lookupByAnnotationType(beanFactory);
        lookupByType(beanFactory);
    }
    /**
     * 延迟查找  ,通过使用org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean
     * 里面的ObjectFactoryCreatingFactoryBean 实现延迟查找
     * @param beanFactory
     */
    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找：" + user);
    }

    /**
     * 通过类型试试查找
     * @param beanFactory
     */
    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("实时查找：" + user);
    }
    /**
     * 通过注解查找
     * @param beanFactory
     */
    private static void lookupByAnnotationType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            //导入注解
            Map<String, User> users = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找标注 @Super 所有的 User 集合对象：" + users);
        }
    }
}
