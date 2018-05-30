package cn.itcast.annotation2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//不加这个就去死吧    java.lang.RuntimeException: java.lang.NullPointerException
@Retention(RetentionPolicy.RUNTIME)//运行时生效的注解，
public @interface DbInfo {

	String driver();

	String url();

	String username();

	String password();

}
