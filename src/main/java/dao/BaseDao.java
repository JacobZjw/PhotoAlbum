package dao;

import utils.ConnectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JwZheng
 */
public class BaseDao {


    public static <T> List<T> getForList(Class<T> clazz, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<T> list = new ArrayList<>();
        try {
            conn = ConnectionUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                T t = clazz.getDeclaredConstructor().newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i + 1);
                    String columnName = metaData.getColumnName(i + 1);

                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                list.add(t);
            }

        } catch (SQLException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InstantiationException | InvocationTargetException throwable) {
            throwable.printStackTrace();
        } finally {
            ConnectionUtils.closeResource(conn, ps, rs);
        }
        return list;
    }


    public static <T> T getAObject(Class<T> clazz, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            T t = clazz.getDeclaredConstructor().newInstance();
            conn = ConnectionUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int count = metaData.getColumnCount();
            if (rs.next()) {
                for (int i = 0; i < count; i++) {
                    Object objValue = rs.getObject(i + 1);
                    String objName = metaData.getColumnName(i + 1);

                    Field field = clazz.getDeclaredField(objName);
                    field.setAccessible(true);
                    field.set(t, objValue);
                }
                return t;
            }
        } catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchFieldException throwable) {
            throwable.printStackTrace();
        } finally {
            ConnectionUtils.closeResource(conn, ps, rs);
        }
        return null;
    }

    public static boolean update(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConnectionUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtils.closeResource(conn, ps);
        }
        return false;
    }


}
