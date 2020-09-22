package com.xxy.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.xxy.pojo.opse;
import com.xxy.pojo.record;
import com.xxy.pojo.ticket;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author xxy
 * @date 2020-08-28 - 21:08
 */
public interface RecordDao extends BaseMapper<record> {

    @Select("SELECT t.tid tid,tname,COUNT(DISTINCT o.oid) oid,COUNT(uid) uid FROM record r  right JOIN opse o ON o.oid=r.oid RIGHT JOIN ticket t ON t.tid=o.tid  ${ew.customSqlSegment}  GROUP BY tname,tid ")
    IPage<Map<String,Object>> selectList(IPage<record> page,@Param(Constants.WRAPPER) Wrapper<record> queryWrapper);

    @Select("SELECT t.tid tid,tname,tyid,COUNT(DISTINCT o.oid) oid,COUNT(uid) uid FROM record r right JOIN opse o ON o.oid=r.oid RIGHT JOIN ticket t ON t.tid=o.tid  ${ew.customSqlSegment} GROUP BY tname,tid,tyid ")
    Map<String,Object> selectTicket(@Param(Constants.WRAPPER) Wrapper<ticket> queryWrapper);


    @Select("select * from opse where tid = ${tid} ")
    List<opse> selectOname(Integer tid);

    @Select("SELECT o.oid oid,COUNT(r.uid) uid,oname FROM record r RIGHT JOIN opse o ON r.oid=o.oid ${ew.customSqlSegment} GROUP BY oid,oname")
    List<Map<String,Object>> selectRecord(@Param(Constants.WRAPPER) Wrapper<record> queryWrapper);


}
