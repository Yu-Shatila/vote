package com.xxy.controller;

import com.xxy.pojo.opse;
import com.xxy.pojo.ticket;
import com.xxy.service.IOpseService;
import com.xxy.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xxy
 * @date 2020-09-03 - 17:53
 */
@Controller
public class TicketController {


    @Autowired
    private ITicketService service;


    @Autowired
    private IOpseService oservice;


    @GetMapping("/getAdd")
    public String getAdd(){
        return "add";
    }



    @PostMapping("/ticketSave")
    public String tSave(ticket t,String[] oname){
        if(service.save(t)){
            int tid = t.getTid();
            List<opse> li = new ArrayList<opse>();
            for (String s : oname) {
                opse op = new opse();
                op.setOname(s);
                op.setTid(tid);
                li.add(op);
            }
            if(oservice.saveBatch(li)){
                return "redirect:getPage";
            }

        }
        return "add";
    }




}
