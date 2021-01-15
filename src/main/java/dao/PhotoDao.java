package dao;

import beans.Photo;
import beans.User;

import java.util.List;

/**
 * @author JwZheng
 */
public class PhotoDao extends BaseDao {
    static final String insertPhotoSql = "INSERT INTO photo(name,url,masterId)VALUES(?,?,?);";
    static final String updatePhotoSql = "UPDATE photo SET name = ?, url = ? WHERE id = ? ;";

    static final String queryPhotoSql = "SELECT * FROM photo WHERE masterId = ? ;";
    static final String queryPhotoByIdSql = "SELECT * FROM photo WHERE id = ?";
    static final String getPhotoWallSql = "SELECT * FROM photo;";

    static final String collectPhotoSql = "INSERT IGNORE INTO photocolletions(photoId,userId)VALUES(?,?);";
    static final String undoCollectSql = "DELETE FROM photocolletions WHERE photoId = ? AND userId = ?;";
    static final String queryFavPhotosSql = "SELECT * FROM photo WHERE id IN(SELECT photoId FROM photocolletions WHERE userId = ?);";

    static final String deletePhotoSql = "DELETE FROM photo WHERE id = ? ;";

    public static boolean insertPhoto(Photo photo) {
        return update(insertPhotoSql, photo.getName(), photo.getUrl(), photo.getMasterId());
    }

    public static Photo getPhotoById(Long id) {
        return BaseDao.getAObject(Photo.class, queryPhotoByIdSql, id);
    }

    public static boolean collectAPhoto(Long photoId, Long userId) {
        return update(collectPhotoSql, photoId, userId);
    }

    public static boolean cancelCollectionAPhoto(Long photoId, Long userId) {
        return update(undoCollectSql, photoId, userId);
    }


    public static boolean updatePhoto(Photo photo) {
        return update(updatePhotoSql, photo.getName(), photo.getUrl(), photo.getId());
    }

    public static boolean deletePhoto(Photo photo) {
        return update(deletePhotoSql, photo.getId());
    }

    public static List<Photo> queryPhoto(User user) {
        return getForList(Photo.class, queryPhotoSql, user.getId());
    }

    public static List<Photo> queryFavPhoto(Long userId) {
        return getForList(Photo.class, queryFavPhotosSql, userId);
    }

    public static List<Photo> getPhotoWallList() {
        return getForList(Photo.class, getPhotoWallSql);
    }
}
