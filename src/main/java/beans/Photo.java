package beans;

import java.io.Serializable;

/**
 * @author JwZheng
 */
public class Photo implements Serializable {
    private Long id;
    private String name;
    private String url;
    private Long masterId;

    public Photo() {
    }

    public Photo(Long id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public Long getMasterId() {
        return masterId;
    }

    public void setMasterId(Long masterId) {
        this.masterId = masterId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
