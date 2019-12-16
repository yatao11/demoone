package com.demoone.bussiness.xly.mapper;

import com.demoone.bussiness.xly.entity.Coach;
import com.demoone.bussiness.xly.entity.Room;
import com.demoone.bussiness.xly.entity.Student;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.demoone.bussiness.xly.vo.Base;
import com.demoone.common.entity.CommonArea;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 华强
 * @since 2019-12-06
 */

public interface StudentDao extends BaseMapper<Student> {

    /*
     * 停止学员周期
     */
    @Update("update student set state='1' where id=#{id}")
    boolean  tingZhouQi(int  id);

    /*
     * 减学员天数
     */
    @Update("update student set surplus_day=surplus_day-1 where id=#{id}  ")
    boolean jianTianShu(int  id);

    /*
     * 今日总在营人数
     */
    @Select("select count(*) from student where state='0'")
    String zongZaiYing();

    /*
     * 今日出营人数
     */
    @Select("select count(1) from student where state='1' and leave_time=now() ")
    String jinChuYing();

    /*
     * 今日入营人数
     */
    @Select("select count(1) from student where  join_time=now() ")
    String jinRuYing();


    /*
      * 获取基地下拉框数据
      */
    @Select("select b.bid,b.name from base b")
    List<Base> baseDropDown();

    /*
      * 获取教练下拉框数据
      */
    @Select("select c.cid,c.name from coach c")
    List<Coach> coachDropDown();

    /*
  * 获取教练下拉框数据
  */
    @Select("select r.no from room  r")
    List<Room> roomDropDown();
}
