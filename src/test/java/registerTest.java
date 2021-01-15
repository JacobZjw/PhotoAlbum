import beans.User;
import dao.UserDao;

/**
 * @author JwZheng
 */
public class registerTest {
    public static void main(String[] args) {
        User user = new User("jacob", "1234", "jw.life@qq.com");
        System.out.println(UserDao.register(user));

        User user1 = new User("nick", "1234", "jw.life@qq.com");
        System.out.println(UserDao.register(user1));

        User user2 = new User("jacob", "1234", "jacob@qq.com");
        System.out.println(UserDao.register(user2));

        User user3 = new User("nick", "1234", "nick@qq.com");
        System.out.println(UserDao.register(user3));

        User user4 = new User("nick", "1234", "nick@qq.com");
        System.out.println(UserDao.register(user4));
    }


}
