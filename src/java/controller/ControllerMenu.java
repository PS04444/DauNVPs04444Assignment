/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.NhanVien;
import bean.PhongBan;
import bean.TaiKhoan;
import entity.Records;
import entity.Staffs;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ModelAccount;
import model.ModelNhanVien;
import model.ModelPhongBan;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import util.HibernateUtil;


@Controller
public class ControllerMenu {

    @RequestMapping("index")
    public String index(ModelMap model) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = "from Staffs";
        Query query = session.createQuery(sql);
        List<Staffs> list = query.list();
        model.addAttribute("staffs", list);
        return "index";
    }

//    @RequestMapping("index")
//    public String index(ModelMap model) {
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        String sql = "from Records r where r.type = 1";
//        Query query = session.createQuery(sql);
//        List<Records> list = query.list();
//        model.addAttribute("records", list);
//        return "index";
//    }
    
    
    @RequestMapping("qltaikhoan")
    public String qltaikhoan(ModelMap model) {
        ModelAccount nv = new ModelAccount();
        List<TaiKhoan> list = new ArrayList<TaiKhoan>();
        list = nv.showTaiKhoan("");
        model.addAttribute("listUsers", list);

        TaiKhoan tk = new TaiKhoan();
        tk = list.get(0);
        model.addAttribute("user", tk);
        return "qltaikhoan";
    }

    @RequestMapping("qlphongban")
    public String qlphongban(ModelMap model) {
        ModelPhongBan mpb = new ModelPhongBan();
        List<PhongBan> list = new ArrayList<PhongBan>();
        list = mpb.showPhongBan("");
        model.addAttribute("listPhongBan", list);

        PhongBan pb = new PhongBan();
        pb = list.get(0);
        model.addAttribute("phongban", pb);
        return "qlphongban";
    }

//    @RequestMapping("gnthanhtich")
//    public String gnthanhtich() {
//        return "gnthanhtich";
//    }
//    @RequestMapping("ththanhtich")
//    public String ththanhtich() {
//        return "ththanhtich";
//    }
    @RequestMapping("kyluat")
    public String kyluat(ModelMap model) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = "from Records r where r.type = 0";
        Query query = session.createQuery(sql);
        List<Records> list = query.list();
        model.addAttribute("records", list);
        return "kyluat";
    }

    @RequestMapping("dangnhap")
    public String dangnhap(HttpServletRequest request) {
        HttpSession sesson = request.getSession(true);
        sesson.removeAttribute("USER");
        return "dangnhap";
    }
    
    @RequestMapping("index.htm?language=en")
    public String en(){
        return "index";
    }
    
    @RequestMapping("index.htm?language=vi")
    public String vi(){
        return "index";
    }
}
