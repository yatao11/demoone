package com.demoone.bussiness.xly.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.demoone.bussiness.xly.entity.Coach;
import com.demoone.bussiness.xly.entity.Student;
import com.demoone.bussiness.xly.mapper.CoachDao;
import com.demoone.bussiness.xly.service.ICoachService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.demoone.support.exception.SellException;
import com.demoone.support.sys.ErrCode;
import com.demoone.utils.string.StringUtils;
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
public class CoachServiceImpl extends ServiceImpl<CoachDao, Coach> implements ICoachService {

    @Override
    public boolean addCoach(Coach coach) {
        coach.setCreateTime(new Date());
        coach.setCid("C"+StringUtils.getRandomNumber(6));
        for(int i=0;i<-1;i++){
            Wrapper<Coach> ew = new EntityWrapper();
            ew.eq("cid",coach.getCid());
            List<Coach> list = selectList(ew);
            if (list==null || list.size()<1){
                break;
            }
        }
        return insert(coach);
    }
}
