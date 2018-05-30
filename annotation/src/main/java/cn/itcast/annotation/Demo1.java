package cn.itcast.annotation;

import java.util.ArrayList;
import java.util.List;
/**
 * 注解是给别的程序看的
 * 
 * 注解用于替换配置文件的。
 * 有利也有弊。
 * 缺点：相当于修改Java源代码了，需要重新编译。
 */
@SuppressWarnings("unchecked")
public class Demo1 {

	@Override  //重写注解，告诉编译器帮我检查是不是重写父类的方法   如果父类没有这个方法报错
	public boolean equals(@SuppressWarnings("unchecked")  Object obj) {
		return super.equals(obj);
	}
	
	//压制注解,不要报异常
	@SuppressWarnings("unchecked")   //Demo1.java---->Demo1.class
	public void a(){
		List list = new ArrayList();
		System.out.println(list);
	}
	
	@Deprecated   //废弃注解
	public void bbbb(){
		
	}
	
	@MyAnnotation1(gender=Gender.男, my2=@MyAnnotation2(name="abc"), i={1,2,3})   //继承性
	public void cccc(){
		
	}
	
	@MyAnnotation3(value="aaaa",name="123")
	public void dddd(){
		
	}

	String[] aa = {"aa"} ;
}

/**
 * D类继承了父类的所有方法   父类中若某个方法的注解有@Inherited 则继承的方法上也有该注解   否则注解是不会被继承的
 */
class D extends Demo1{
	
	public void cccc(){
		
	}
}

/*
  <MyAnnotation1>
  	<name>flx</flx>
  	<paasword>123</password>
  	<child>                  这就是注解里有注解属性的原因	
  		<name>fsq<name>
  		<age>9<age>
  	</child>
  </MyAnnotation1>
 
 */ 
