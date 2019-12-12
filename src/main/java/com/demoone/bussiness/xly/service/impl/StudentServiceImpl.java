package com.demoone.bussiness.xly.service.impl;

import com.demoone.bussiness.xly.entity.Student;
import com.demoone.bussiness.xly.mapper.StudentDao;
import com.demoone.bussiness.xly.service.IStudentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
    public List zongZaiYing() {
        return baseMapper.zongZaiYing();
    }

    /**.
     * 今日出营人数
     * @param leavetime 今日时间
     * @return  今日出营人数
     */
    @Override
    public List jinChuYing(String leavetime) {
        return baseMapper.jinChuYing(leavetime);
    }
    /**.
     *  今日入营人数
     * @param jointime 今日时间
     * @return  今日入营人数
     */
    @Override
    public List jinRuYing(String jointime) {
        return baseMapper.jinRuYing(jointime);
    }
}
