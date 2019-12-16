package com.demoone.bussiness.xly.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.demoone.bussiness.xly.entity.Room;
import com.demoone.bussiness.xly.mapper.RoomDao;
import com.demoone.bussiness.xly.service.IRoomService;
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
public class RoomServiceImpl extends ServiceImpl<RoomDao, Room> implements IRoomService {

        @Override
        public boolean addRoom(Room room) {
                if (StringUtils.isNotBlank(room.getNo())){
                        Wrapper<Room> ew = new EntityWrapper();
                        ew.eq("no",room.getNo());
                        List<Room> list = selectList(ew);
                        if (list!=null && list.size()>0){
                                throw new SellException(ErrCode.FAIL,"该房间信息已存在！");
                        }
                }
                room.setCreateTime(new Date());
                return insert(room);
        }
}
