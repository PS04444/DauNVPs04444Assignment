/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Staffs;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ModelNhanVien;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import util.HibernateUtil;


@Controller
public class ControllerDangNhap {
    
    @RequestMapping(value = "dangnhap", method = RequestMethod.POST)
    public String dangnhap2(ModelMap model,
            @RequestParam("username") String user,
            @RequestParam("password") String pass,
            @RequestParam(value = "remember", defaultValue = "false") Boolean rm,
            HttpServletRequest request, HttpServletResponse response) {

        HttpSession sesson = request.getSession(true);
        ModelNhanVien modelNhanVien = new ModelNhanVien();
        boolean exist = modelNhanVien.checkLogin(user, pass);

        String url = "error";
        if (exist) {
            url = "index";
            sesson.setAttribute("USER", user);
        }

        Cookie ckiId = new Cookie("uid", user);
        Cookie ckiPw = new Cookie("pwd", pass);
        int expiry = 365 * 24 * 60 * 60;
        ckiId.setMaxAge(rm ? expiry : 0);
        ckiPw.setMaxAge(rm ? expiry : 0);
        response.addCookie(ckiId);
        response.addCookie(ckiPw);

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql="from Staffs";
        Query query = session.createQuery(sql);
        List<Staffs> list = query.list();
        model.addAttribute("staffs", list);
        //return "index";
        
        return url;
    }
}
