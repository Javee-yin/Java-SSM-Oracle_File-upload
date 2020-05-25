package cn.edu.ncu.service.impl;

import cn.edu.ncu.dao.IImgDao;
import cn.edu.ncu.pojo.Img;
import cn.edu.ncu.service.IImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Javee
 * @Date 2020/5/18 17:29
 * @Description
 */
@Service
public class ImgServiceImpl implements IImgService {

    @Autowired
    private IImgDao imgDao;

    @Override
    public void save(Img img) {
        imgDao.save(img);
    }
}
