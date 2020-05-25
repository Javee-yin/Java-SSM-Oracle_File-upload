package cn.edu.ncu.service.impl;

import cn.edu.ncu.dao.IAuthorDao;
import cn.edu.ncu.pojo.Author;
import cn.edu.ncu.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Javee
 * @Date 2020/5/24 18:48
 * @Description
 */
@Service
public class AuthorServiceImpl implements IAuthorService {
    @Autowired
    private IAuthorDao authorDao;

    @Override
    public void add(Author author) {
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println(author.getName() + "-------------" + author.getPassword());
        authorDao.add(author);
    }

    @Override
    public Author findByName(String name) {
        Author authorSelect = authorDao.findByName(name);
        return authorSelect;
    }
}
