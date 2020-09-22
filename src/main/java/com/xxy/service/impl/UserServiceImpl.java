package com.xxy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxy.dao.Userdao;
import com.xxy.pojo.user;
import com.xxy.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class UserServiceImpl extends ServiceImpl<Userdao,user> implements UserService {


}
