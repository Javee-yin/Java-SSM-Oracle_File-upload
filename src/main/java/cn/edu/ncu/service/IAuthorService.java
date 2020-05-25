package cn.edu.ncu.service;

import cn.edu.ncu.pojo.Author;

/**
 * @Author Javee
 * @Date 2020/5/24 18:47
 * @Description
 */
public interface IAuthorService {
    void add(Author author);

    Author findByName(String name);
}
