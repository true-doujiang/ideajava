package dianda.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;

/**
 * author: youhh
 * date: 2018/5/30 下午2:18
 * description:
 */
@Target(value = {ElementType.FIELD, ElementType.METHOD})
@Retention(value = RetentionPolicy.SOURCE)
public @interface HelloAnnotation {

    String name() default "hello name";
    int password() default 1234;

    Gender gender() default Gender.MAN;

    WorldAnnotation worldAnnotatioin() default @WorldAnnotation(world = "world hello");

    Class clazz() default String.class;


    String[] names() default {"aa", "bb"};
    int[] pwsswords() default {123, 456};
    Class[] clazzs() default {String.class, Date.class};


}
