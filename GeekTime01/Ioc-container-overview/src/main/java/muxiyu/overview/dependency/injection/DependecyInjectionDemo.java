package muxiyu.overview.dependency.injection;

import muxiyu.overview.dependency.Domain.SuperUser;
import muxiyu.overview.dependency.Domain.User;
import muxiyu.overview.dependency.annotation.Super;
import muxiyu.overview.dependency.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;
// 依赖注入 Di
public class DependecyInjectionDemo {
    public static void main(String[] args) {
        //配置xml文件
        //启动Spring 应用上下文
        //第一种实现方式 BeanFactory
        BeanFactory beanFactory= new ClassPathXmlApplicationContext("Injection.xml");
        // 依赖来源一：自定义 Bean
        // UserRepository userRepository=beanFactory.getBean("userRepository",UserRepository.class);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Injection.xml");
        UserRepository userRepository = applicationContext.getBean("userRepository", UserRepository.class);
        //通过反射获取对象看看这个对象bean来自于哪里?
        System.out.println(userRepository.getUsers());
        // 依赖来源二：依赖注入（內建依赖）
        System.out.println(userRepository.getBeanFactory());
        ObjectFactory userFactory = userRepository.getObjectFactory();
        //当前bean和我们注入的bean是不是同一个
        System.out.println(userFactory.getObject() == applicationContext);
        // 依赖来源三：容器內建 Bean
        Environment environment = applicationContext.getBean(Environment.class);
        System.out.println("获取 Environment 类型的 Bean：" + environment);
    }
}
