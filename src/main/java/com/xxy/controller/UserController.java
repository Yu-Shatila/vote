package com.xxy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxy.pojo.user;
import com.xxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * @author xxy
 * @date 2020-08-28 - 16:49
 */
@Controller
public class UserController {
    @Autowired
    private UserService service;


    @ResponseBody
    @PostMapping("/findBy")
    public  void getSelect(user u, HttpServletResponse response, HttpSession session) throws IOException {
        PrintWriter out = response.getWriter();
        user one = service.getOne(new QueryWrapper<user>().eq("uname", u.getUname()).eq("upwd", u.getUpwd()));
        if (one!=null) {
            List<String> users = (List<String>) session.getServletContext().getAttribute("users");
            //在线
            if (users.contains(one.getUname())) {
                out.print(2);
            } else {
                session.setAttribute("user", one);
                users.add(one.getUname());
                System.out.println(one);
                out.print(0);
            }
        }else{
            out.print(1);
        }
        out.flush();
        out.close();
    }
    @PostMapping("/userSave")
    public  String getInsert(user u){
        if(service.save(u)){
            return "login";
        }
       return "regist";

    }


    @GetMapping("/login")
    public String login() { return "login"; }
    @GetMapping("/regist")
    public String regList(){
        return "regist";
    }
}
