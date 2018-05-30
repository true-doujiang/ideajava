package cn.itcast.annotation2;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class TestFactory {
	
	public static void main(String[] args) throws SQLException {
		
		BookDao dao = DaoFactory.createBookDao();
		DataSource ds = dao.getDs();
		Connection conn= ds.getConnection();
		System.out.println(conn);
	}
	
}
