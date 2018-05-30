package cn.itcast.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.METHOD,ElementType.FIELD}) //这个注解作用的范围
@Retention(RetentionPolicy.RUNTIME)  //这个注解在执行Java代码的时候生效
//@Inherited 
public @interface MyAnnotation1 {
	
	//相当于注解的属性,支持8种基本数据类型。语法有点奇怪加()
	String name() default "zxx";  //default配置默认值。
	String password() default "123";
	int age() default 12;
	
	//还支持枚举
	Gender gender() default Gender.男;
	
	//还可以是其他注解
	MyAnnotation2 my2() default @MyAnnotation2(name="llll");
	
	Class clazz() default String.class;
	
	//还可以是以上注解的一维数组
	String[] ss() default {"aa","bbb"};
	int[] i() default {1,2};
	
}
