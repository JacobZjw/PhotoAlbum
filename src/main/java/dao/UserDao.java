package dao;

import beans.LoginEnum;
import beans.RegisterEnum;
import beans.User;
import utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author JwZheng
 */
public class UserDao extends BaseDao {

    static final String loginSql = "SELECT * FROM user WHERE (name = ? OR email = ?) AND password = ?";
    static final String registerSql = "INSERT INTO user(name,password,email) VALUES(?,?,?)";
    static final String findNameOrEmailSql = "SELECT * FROM user WHERE name = ? or email = ?;";
    static final String findNameSql = "SELECT * FROM user WHERE name = ?";
    static final String findEmailSql = "SELECT * FROM user WHERE email = ?";

    static final String getUserByIdSql = "SELECT * FROM user WHERE id = ?";

    public static LoginEnum login(User user) {
        String name = user.getName();
        String email = user.getEmail();
        String pwd = user.getPassword();
        if (name == null) {
            name = "";
        }
        if (email == null) {
            email = "";
        }
        Long id = getUserId(loginSql, name, email, pwd);
        if (id != null) {
            user.setId(id);
            return LoginEnum.LOGIN_SUCCESS;
        } else if (getAObject(User.class, findNameOrEmailSql, name, email) != null) {
            return LoginEnum.WRONG_PASSWORD;
        }
        return LoginEnum.WRONG_NAME;
    }

    public static User getAUser(Long userId) {
        return BaseDao.getAObject(User.class, getUserByIdSql, userId);
    }

    public static Long getUserId(String sql, Object... args) {
        User user = getAObject(User.class, sql, args);
        if (user != null) {
            return user.getId();
        }
        return null;
    }


    public static RegisterEnum register(User newUser) {
        if (findInUser(findEmailSql, newUser.getEmail())) {
            return RegisterEnum.REPETITIVE_EMAIL;
        } else if (findInUser(findNameSql, newUser.getName())) {
            return RegisterEnum.REPETITIVE_NAME;
        }
        if (update(registerSql, newUser.getName(), newUser.getPassword(), newUser.getEmail())) {
            return RegisterEnum.REGISTER_SUCCESS;
        } else {
            return RegisterEnum.REGISTER_FAIL;
        }
    }


    public static boolean findInUser(String sql, String value) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = ConnectionUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, value);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtils.closeResource(conn, ps, rs);
        }
        return false;
    }


}
