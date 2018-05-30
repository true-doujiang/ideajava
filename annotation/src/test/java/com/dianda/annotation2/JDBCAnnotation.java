package com.dianda.annotation2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * author: youhh
 * date: 2018/5/30 下午7:19
 * description:
 */
@Retention(value = RetentionPolicy.RUNTIME)
public @interface JDBCAnnotation {

    String driverClass() default "com.mysql.jdbc.Driver";

    String jdbcUrl() default "jdbc:mysql://localhost:3306/dianda";

    String username() default "root";

    String password() default "ok";

}
