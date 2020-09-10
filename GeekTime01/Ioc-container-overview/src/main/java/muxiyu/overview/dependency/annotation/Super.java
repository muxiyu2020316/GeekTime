package muxiyu.overview.dependency.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Target  云信使注解打在的位置
 * Retentio 运行时策略,是以什么方式运行的.这里用在类加载.反射时使用
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Super {

}
