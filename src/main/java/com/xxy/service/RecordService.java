package com.xxy.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxy.pojo.opse;
import com.xxy.pojo.record;
import com.xxy.pojo.ticket;

import java.util.List;
import java.util.Map;

/**
 * @author xxy
 * @date 2020-08-28 - 21:04
 */
public interface RecordService extends IService<record> {
    IPage<Map<String,Object>> listRecord(IPage<record> page,Wrapper<record> queryWrapper);


    Map<String,Object> findTicket(Wrapper<ticket> queryWrapper);

    List<opse> findOname(Integer tid);

    List<Map<String,Object>> findRecord(Wrapper<record> queryWrapper);



}
