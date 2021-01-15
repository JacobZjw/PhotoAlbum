package dao;

import beans.Comment;

import java.util.List;

/**
 * @author JwZheng
 */
public class CommentDao extends BaseDao {

    public static boolean addComment(Comment comment) {
        String sql = "INSERT INTO comments(photoId,content,userName)VALUES(?,?,?);";
        return BaseDao.update(sql, comment.getPhotoId(), comment.getContent(), comment.getUserName());
    }

    public static List<Comment> getComments(Long photoId) {
        String sql = "SELECT * FROM comments WHERE photoId = ?;";
        return BaseDao.getForList(Comment.class, sql, photoId);
    }
}
