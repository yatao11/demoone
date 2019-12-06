package com.demoone.bussiness.xly.service.impl;

import com.demoone.bussiness.xly.entity.Photo;
import com.demoone.bussiness.xly.mapper.PhotoDao;
import com.demoone.bussiness.xly.service.IPhotoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 华强
 * @since 2019-12-06
 */
@Service
public class PhotoServiceImpl extends ServiceImpl<PhotoDao, Photo> implements IPhotoService {

}
