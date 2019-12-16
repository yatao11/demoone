package com.demoone.bussiness.xly.service;

import com.demoone.bussiness.xly.entity.Coach;
import com.demoone.bussiness.xly.entity.Room;
import com.demoone.bussiness.xly.entity.Student;
import com.baomidou.mybatisplus.service.IService;
import com.demoone.bussiness.xly.vo.Base;

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
    /**
     *  添加学员信息
     */
    boolean addStudent(Student student);
    /**
     *  获取基地下拉框
     */
    List<Base> baseDropDown();
    /**
     *  获取教练下拉框
     */
    List<Coach> coachDropDown();
    /**
     *  获取房间下拉框
     */
    List<Room> roomDropDown();
}
