package com.hqq.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * JDBCUtils
 * Created by heqianqian on 2017/6/17.
 */
public class JDBCUtils {

    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        properties.load(resourceAsStream);
        String url = properties.getProperty("jdbcUrl");
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("password");
        Class.forName(properties.getProperty("driverClass"));
        return DriverManager.getConnection(url, user, pwd);
    }

    public static void releaseConnection(Connection connection,
                                  PreparedStatement preparedStatement,
                                  ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
