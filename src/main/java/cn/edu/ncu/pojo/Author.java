package cn.edu.ncu.pojo;

/**
 * @Author Javee
 * @Date 2020/5/24 15:01
 * @Description
 */
public class Author {
    private Integer authorId;

    private String name;

    private String password;

    private Integer valid;

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}
