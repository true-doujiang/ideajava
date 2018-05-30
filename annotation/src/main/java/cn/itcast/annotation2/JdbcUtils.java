package cn.itcast.annotation2;

import java.lang.reflect.Method;
import java.sql.Connection;

public class JdbcUtils {
	
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	static{
		try{
			//解析注解，获取注解配置的信息
			Method method = JdbcUtils.class.getMethod("getConnection", null);//反射类的方法
			DbInfo info = method.getAnnotation(DbInfo.class); //反射方法上的注解    参数：要反射注解的class
			driver = info.driver(); //获取注解的属性
			url = info.url();
			username = info.username();
			password = info.password();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@DbInfo(driver="com.mysql.jdbc.Driver",url="jdbc:mysql://localhost:3306/bookstore",username="root",password="ok")
	public static Connection getConnection(){
		System.out.println(driver);
		System.out.println(url);	
		return null;
	}
	
	
	public static void main(String[] args) {
		JdbcUtils.getConnection();
	}
	
}
