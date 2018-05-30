package dianda.jdbc;

import dianda.annotation2.JDBCAnnotation;


import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * author: youhh
 * date: 2018/5/30 下午7:26
 * description:
 */
public class JDBCUtils {

    private static String driverClass;
    private static String jdbcUrl;
    private static String username;
    private static String password;

    //注解处处理器
    static {
        try {
            Method method = JDBCUtils.class.getMethod("getConnection", null);
            JDBCAnnotation annotation = method.getAnnotation(JDBCAnnotation.class);
            driverClass = annotation.driverClass();
            jdbcUrl = annotation.jdbcUrl();
            username = annotation.username();
            password = annotation.password();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @JDBCAnnotation
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return conn;
    }


    public static void main(String[] args) {
        try {
            Connection conn = JDBCUtils.getConnection();
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
