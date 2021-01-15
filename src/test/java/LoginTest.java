import beans.User;
import dao.UserDao;

/**
 * @author JwZheng
 */
public class LoginTest {
    public static void main(String[] args) {
        User user = new User("jacob", "1234", "jw.life@qq.com");
        user.setId(1L);
        System.out.println(UserDao.login(user));


        User user1 = new User();
        user1.setName("jacob");
        user1.setPassword("1234");
        user1.setId(1L);
        System.out.println(UserDao.login(user1));


        User user2 = new User();
        user2.setEmail("jw.life@qq.com");
        user2.setPassword("1234");
        System.out.println(UserDao.login(user2));

        User user3 = new User("jacob", "123", "jw.life@qq.com");
        System.out.println(UserDao.login(user3));


        User user4 = new User();
        user4.setName("nick");
        user4.setPassword("1234");
        System.out.println(UserDao.login(user4));

        User user5 = new User();
        user5.setEmail("nick");
        user5.setPassword("1234");
        System.out.println(UserDao.login(user5));

    }
}
