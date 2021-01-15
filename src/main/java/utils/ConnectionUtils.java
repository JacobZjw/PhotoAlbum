package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author JwZheng
 */
public class ConnectionUtils {
    private static String user;
    private static String url;
    private static String password;

    static {
        InputStream is = ConnectionUtils.class.getClassLoader().getResourceAsStream("/../JDBC.properties");
        Properties info = new Properties();
        try {
            info.load(is);
            user = info.getProperty("user");
            url = info.getProperty("url");
            password = info.getProperty("password");
            String driverClass = info.getProperty("driverClass");
            Class.forName(driverClass);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void closeResource(Connection conn, PreparedStatement ps) {
        try {
            if (conn != null)
                conn.close();
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeResource(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (conn != null)
                conn.close();
            if (ps != null)
                ps.close();
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
