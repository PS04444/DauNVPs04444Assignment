/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Staffs;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import util.HibernateUtil;

/**
 *
 * @author Administrator
 */
@Transactional
@Controller
//@RequestMapping("/staff/")
public class StaffController {

    @Autowired
    SessionFactory factory;

//    @RequestMapping("index")
//    public String index(ModelMap model) {
////        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
////        session.beginTransaction();
////        String sql="from Staffs";
////        Query query = session.createQuery(sql);
////        List<Staffs> list = query.list();
////        model.addAttribute("staffs", list);
//
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        String hql = "select top 10 r.staffs.id,s.Name,s.Photo,s.Email,s.Phone, SUM(case when r.type=1 then 1 else 0 end) - "
//                + "        SUM(case when r.type=0 then 1 else 0 end) as KQ"
//                + "        FROM Records r inner join Staffs s"
//                + "		on s.Id = r.StaffId"
//                + "        GROUP BY r.staffid,s.Name,s.Photo,s.Email,s.Phone"
//                + "		Order by KQ DESC";
//        Query query = session.createQuery(hql);
//        List<Object[]> list = query.list();
//        model.addAttribute("arrays", list);
//        return "index";
//    }

    @RequestMapping("ththanhtich")
    public String report(ModelMap model) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "SELECT r.staffs.id, "
                + " SUM(case when r.type=1 then 1 else 0 end), "
                + " SUM(case when r.type=0 then 1 else 0 end)"
                + " FROM Records r "
                + " GROUP BY r.staffs.id";
        Query query = session.createQuery(hql);
        List<Object[]> list = query.list();
        model.addAttribute("arrays", list);
        return "ththanhtich";
    }

}
