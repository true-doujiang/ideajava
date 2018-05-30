package cn.itcast.annotation2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {

	String driverClass() default "com.mysql.jdbc.Driver";

	String jdbcUrl() default "jdbc:mysql://localhost:3306/day14";

	String user() default "root";

	String password() default "ok";

}
