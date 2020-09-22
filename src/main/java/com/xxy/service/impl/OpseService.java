package com.xxy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxy.dao.OpseDao;
import com.xxy.pojo.opse;
import com.xxy.service.IOpseService;
import org.springframework.stereotype.Service;

/**
 * @author xxy
 * @date 2020-09-03 - 18:13
 */
@Service
public class OpseService extends ServiceImpl<OpseDao, opse> implements IOpseService {
}
