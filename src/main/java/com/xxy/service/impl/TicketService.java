package com.xxy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxy.dao.TicketDao;
import com.xxy.pojo.ticket;
import com.xxy.service.ITicketService;
import org.springframework.stereotype.Service;

/**
 * @author xxy
 * @date 2020-09-03 - 17:48
 */
@Service
public class TicketService extends ServiceImpl<TicketDao, ticket> implements ITicketService {

}
