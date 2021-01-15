import beans.Photo;
import beans.User;
import dao.PhotoDao;

import java.util.List;

/**
 * @author JwZheng
 */
public class PhotoTest {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1L);
        List<Photo> list = PhotoDao.queryPhoto(user);
        System.out.println(list);
    }
}
