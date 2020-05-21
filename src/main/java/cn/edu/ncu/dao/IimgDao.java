package cn.edu.ncu.dao;

import cn.edu.ncu.pojo.Img;
import org.springframework.stereotype.Service;

/**
 * @Author Javee
 * @Date 2020/5/18 17:27
 * @Description
 */
@Service
public interface IimgDao {
    void save(Img img);
}
