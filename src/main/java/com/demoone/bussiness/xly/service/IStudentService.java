package com.demoone.bussiness.xly.service;

import com.demoone.bussiness.xly.entity.Student;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 华强
 * @since 2019-12-06
 */
public interface IStudentService extends IService<Student> {
    /**
     *  停止学员周期
     */
    boolean tingZhouQi(int id);
    /**
     *  减学员天数
     */
    boolean jianTianShu(int id);
    /**
     *  今日总在营人数
     */
    String zongZaiYing();
    /**
     *  今日出营人数
     */
    String jinChuYing();
    /**
     *  今日入营人数
     */
    String jinRuYing();

    boolean addStudent(Student student);
}
