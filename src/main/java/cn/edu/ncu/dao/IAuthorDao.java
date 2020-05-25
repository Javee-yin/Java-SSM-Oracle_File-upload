package cn.edu.ncu.dao;

import cn.edu.ncu.pojo.Author;

/**
 * @Author Javee
 * @Date 2020/5/24 15:04
 * @Description
 */
public interface IAuthorDao {
    void add(Author author);

    Author findByName(String name);
}
