package cn.itcast.annotation;

import java.lang.annotation.*;

/**
 * 元注解(描述注解的注解).   就像元数据一个意思。
 *  @Retention    @Target
 */
@Documented //Javadoc生成文档用的
//@Target({ElementType.FIELD})   默认作用于类的所有信息上
@Retention(RetentionPolicy.RUNTIME) //这个注解在执行Java代码的时候生效    默认是class级别 
public @interface MyAnnotation3 {

	//特殊属性value. 使用该注解的时候给value赋值时可以不加key，也可以加上。(在没有其它属性的前提)
	String value();
	
	String name();


}
