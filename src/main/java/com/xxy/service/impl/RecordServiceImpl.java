package com.xxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.xxy.dao.RecordDao;
import com.xxy.pojo.opse;
import com.xxy.pojo.record;
import com.xxy.pojo.ticket;
import com.xxy.service.RecordService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author xxy
 * @date 2020-08-28 - 21:06
 */
@Service
public class RecordServiceImpl extends ServiceImpl<RecordDao, record> implements RecordService {

    @Autowired
    private RecordDao rd;

    @Override
    public IPage<Map<String,Object>> listRecord(IPage<record> page,Wrapper<record> queryWrapper) {

        return rd.selectList(page,queryWrapper);
    }

    @Override
    public Map<String, Object> findTicket(Wrapper<ticket> queryWrapper) {
        return rd.selectTicket(queryWrapper);
    }

    @Override
    public List<opse> findOname(Integer tid) {
        return rd.selectOname(tid);
    }

    @Override
    public List<Map<String, Object>> findRecord(Wrapper<record> queryWrapper) {
        return rd.selectRecord(queryWrapper);
    }
}
