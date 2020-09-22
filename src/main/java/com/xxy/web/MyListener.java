package com.xxy.web;

import com.xxy.pojo.user;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
@WebListener
public class MyListener implements ServletContextListener, HttpSessionListener {
    private ServletContext  application;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.application = sce.getServletContext();
        System.out.println("创建application");
        this.application.setAttribute("users", new ArrayList<String>());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("application销毁");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        session.setMaxInactiveInterval(120);
        System.out.println("session创建："+session.getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        System.out.println("session销毁："+session.getId());

        user username = (user)session.getAttribute("user");
        List<String> users = (List<String>)application.getAttribute("users");
        if(users.contains(username.getUname())) {
            users.remove(username.getUname());
        }
    }
}
