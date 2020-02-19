package dao;

import sun.net.ConnectionResetException;

import java.sql.*;

/**
 * 数据库操作类
 */
public class BaseDao {
    /**
     * 连接数据库的4个字符串
     * 连接地址
     * MySql 数据库的Java驱动
     * 用户名
     * 密码
     */
    static final String Url = "jdbc:mysql://localhost:3306/petshop?useUnicode=True&characterEncoding=UTF-8";
    static final String Driver = "com.mysql.jdbc.Driver";
    static final String userName = "root";
    static final String passWord = "123456";

    //数据库连接对象
    static final Connection conn = null;
    //prep
    static PreparedStatement pstmt = null;
    //结果集对象
    static ResultSet rs = null;

    /**
     * 连接数据库的方法
     *
     * @return 数据库连接对象
     */
    public static Connection getConn() {
        Connection conn = null;
        if (conn == null) {
            //加载驱动
            try {
                Class.forName(Driver);
                conn = DriverManager.getConnection(Url, userName, passWord);
                //System.out.println("数据库连接成功");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return conn;
    }

    /**
     * 释放资源的方法
     *
     * @param rs    结果集对象
     * @param conn  数据库连接对象
     * @param pstmt 执行SQL的对象
     */
    public static void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
