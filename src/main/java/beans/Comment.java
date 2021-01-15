package beans;

import java.io.Serializable;

/**
 * @author JwZheng
 */
public class Comment implements Serializable {
    public Long id;
    private Long photoId;
    private String userName;
    private String content;

    public Comment() {
    }

    public Comment(Long photoId, String userName, String content) {
        this.photoId = photoId;
        this.userName = userName;
        this.content = content;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
