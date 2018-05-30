package cn.itcast.annotation;

import java.lang.annotation.Inherited;

@Inherited   //某个类使用了这个注解后，某个类的子类对应的地方也继承了这个注解
public @interface MyAnnotation2 {
	
	String name();
}
