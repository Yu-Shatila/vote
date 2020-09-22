package com.xxy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxy.pojo.opse;
import com.xxy.pojo.record;
import com.xxy.pojo.ticket;
import com.xxy.pojo.user;
import com.xxy.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * @author xxy
 * @date 2020-08-28 - 21:03
 */
@Controller
public class RecordController {

    @Autowired
    private RecordService service;


    @GetMapping("/findPage")
    public String allPage(@RequestParam(defaultValue = "1") Integer pageIndex,@RequestParam(defaultValue = "") String title,Model model) {
        Page<record> page = new Page<>(pageIndex,3);
        IPage<Map<String, Object>> mp ;
        if(title!="") {
            mp = service.listRecord(page,new QueryWrapper<record>().like("tname",title));
        }else{
            mp = service.listRecord(page,new QueryWrapper<>());
        }
        System.out.println(mp);
        model.addAttribute("mp",mp);
        return "votelist";

    }

    @GetMapping("/getPage")
    public String getPage(Model model) {
        Page<record> page = new Page<>(1,3);
        IPage<Map<String,Object>> mp = service.listRecord(page,new QueryWrapper<>());
        model.addAttribute("mp",mp);
        return "votelist";
    }

    @GetMapping("/findVote")
    public String getVote(Integer tid,Model model,HttpSession session) {
        user u = (user) session.getAttribute("user");
        Map<String,Object> mp = service.findTicket(new QueryWrapper<ticket>().eq("t.tid",tid));
        List<opse> list  =service.findOname(tid);
        List<record> li =  service.list(new QueryWrapper<record>().eq("t.tid",tid).eq("r.uid",u.getUid()));
        System.out.println(li);
        if(li.size()>0){
            mp.put("li",1);
        }else{
            mp.put("li",0);
        }
        mp.put("list",list);
        model.addAttribute("mp",mp);
        return "vote";
    }
    @Transactional
    @PostMapping("/voteSave")
    public void voteSave(record ro, Integer[] oid, ServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        try {
            for (int i = 0; i < oid.length; i++) {
                ro.setOid(oid[i]);
                System.out.println(ro);
                service.save(ro);
            }
            out.print(0);
        }catch (Exception e){
            out.print(1);
        }
        out.flush();
        out.close();
    }


    @GetMapping("/findView")
    public String getView(Integer tid,Model model) {
        Map<String,Object> mp = service.findTicket(new QueryWrapper<ticket>().eq("t.tid",tid));
        List<Map<String, Object>> list = service.findRecord(new QueryWrapper<record>().eq("o.tid",tid));
        model.addAttribute("mp",mp);
        model.addAttribute("list",list);
        return "voteview";
    }

    @GetMapping("/Destroy")
    public String getDestroy(HttpSession session) {
        session.invalidate();
        return "login";
    }




}
