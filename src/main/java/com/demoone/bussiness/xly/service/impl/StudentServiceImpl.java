package com.demoone.bussiness.xly.service.impl;

import com.demoone.bussiness.xly.entity.Student;
import com.demoone.bussiness.xly.mapper.StudentDao;
import com.demoone.bussiness.xly.service.IStudentService;
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
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements IStudentService {

}
