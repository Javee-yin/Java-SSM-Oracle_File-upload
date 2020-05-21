package cn.edu.ncu.pojo;

/**
 * @Author Javee
 * @Date 2020/5/18 16:08
 * @Description
 */
public class Img {
    private Integer imgId;

    private String imgPath;

    private String author;

    private Integer valid;

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}
