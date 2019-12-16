package com.demoone.bussiness.xly.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.demoone.bussiness.xly.entity.Coach;
import com.demoone.bussiness.xly.entity.Room;
import com.demoone.bussiness.xly.entity.Student;
import com.demoone.bussiness.xly.mapper.StudentDao;
import com.demoone.bussiness.xly.service.IStudentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.demoone.bussiness.xly.vo.Base;
import com.demoone.support.exception.SellException;
import com.demoone.support.sys.ErrCode;
import com.demoone.utils.string.StringUtils;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    /**.
     * 停止学员周期
     * @param id 学员的编号
     * @return
     */
    @Override
    public boolean tingZhouQi(int id) {
        return baseMapper.tingZhouQi(id);
    }
    /**.
     *  减学员天数
     * @param id 学员的编号
     * @return
     */
    @Override
    public boolean jianTianShu(int id) {
        return baseMapper.jianTianShu(id);
    }
    /**.
     *  今日总在营人数
     * @param
     * @return 今日总在营人数
     */
    public String zongZaiYing() {
        return baseMapper.zongZaiYing();
    }

    /**.
     * 今日出营人数
     * @return  今日出营人数
     */
    @Override
    public String jinChuYing() {
        return baseMapper.jinChuYing();
    }
    /**.
     *  今日入营人数
     * @return  今日入营人数
     */
    @Override
    public String jinRuYing() {
        return baseMapper.jinRuYing();
    }

    @Override
    public boolean addStudent(Student student) {
        if (StringUtils.isNotBlank(student.getIdNo())){
            Wrapper<Student> ew = new EntityWrapper();
            ew.eq("id_no",student.getSid());
            List<Student> list = selectList(ew);
            if (list!=null && list.size()>0){
                throw new SellException(ErrCode.FAIL,"该学员信息已存在！");
            }
        }else{
            throw  new SellException(ErrCode.FAIL,"身份证号不能为空！");
        }

        student.setCreateTime(new Date());
        student.setSid("S"+StringUtils.getRandomNumber(6));
        for(int i=0;i<-1;i++){
            Wrapper<Student> ew = new EntityWrapper();
            ew.eq("sid",student.getSid());
            List<Student> list = selectList(ew);
            if (list==null || list.size()<1){
                break;
            }
        }
        int sex = Integer.parseInt(student.getIdNo().substring(16,17));
        if (sex%2>0){
            student.setGender(1);
        }else {
            student.setGender(2);
        }
        return insert(student);
    }
    /**.
     *  获取基地下拉框数据
     * @return  基地下拉框数据
     */
    @Override
    public List<Base> baseDropDown() {
        return  baseMapper.baseDropDown();
    }
    /**.
     *  获取教练下拉框数据
     * @return  教练下拉框数据
     */
    @Override
    public List<Coach> coachDropDown() {
        return baseMapper.coachDropDown();
    }
    /**.
     *  获取房间下拉框数据
     * @return  房间下拉框数据
     */
    @Override
    public List<Room> roomDropDown() {
        return  baseMapper.roomDropDown();
    }
}
