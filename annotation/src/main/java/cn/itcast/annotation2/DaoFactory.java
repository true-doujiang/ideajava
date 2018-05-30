package cn.itcast.annotation2;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * 针对set方法上上的@Inject
 */
public class DaoFactory {

	public static BookDao createBookDao(){
		BookDao dao = new BookDao();
		//向dao注入一个池
		//解析出dao所有属性
		try{
			//内省只能获取属性不能获取字段							//抛弃从父类那里继承的属性
			BeanInfo info = Introspector.getBeanInfo(dao.getClass(),Object.class);
			PropertyDescriptor pds[] = info.getPropertyDescriptors();
			for(int i=0;pds!=null && i<pds.length;i++){
				//得到bean的每一个属性描述器
				PropertyDescriptor pd = pds[i];
				
				Method setMethod = pd.getWriteMethod();  //得到属性相应的set方法
				
				//看set方法上有没有inject 注解
				Inject inject = setMethod.getAnnotation(Inject.class);
				if(inject==null){
					continue;
				}
				
				//方法有注解，则用注解配置的信息，创建一个连接池    有可能是c3p0也可能是dbcp 不确定
				Class propertyType = pd.getPropertyType();
				Object datasource = propertyType.newInstance();
				
				DataSource ds = (DataSource)createDataSourceByInject(inject,datasource);
				
				setMethod.invoke(dao, ds);
			}
		}catch (Exception e) {
			throw new RuntimeException();
		}
		return dao;
	}

	//用注解的信息，为池配置属性
	private static Object createDataSourceByInject(Inject inject,Object ds) {
		//获取到注解所有属性相应的方法     driverClass url 还有  equals hashcode
		Method methods[] = inject.getClass().getMethods();
		for(Method m : methods){
			String methodName = m.getName();  //equals  url()  password()
			PropertyDescriptor pd = null;
			try {
				//Inject的属性和连接池上的属性相同才能给连接池赋值
				//如果没有就会抛异常
				pd = new PropertyDescriptor(methodName,ds.getClass());  //geturl
				Object value  = m.invoke(inject, null);  //得到注解属性的值
				pd.getWriteMethod().invoke(ds, value);
				
			} catch (Exception e) {
				continue; //高级 
			}
		}
		return ds;
	}
	
	//http://www.cnblogs.com/avenwu/archive/2012/02/28/2372586.html
	public static void main(String[] args) throws SQLException {
		BookDao bookDao = DaoFactory.createBookDao();
		System.out.println(bookDao.getDs().getConnection());
	}
	
}
