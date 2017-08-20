/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Records;
import entity.Staffs;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.HibernateUtil;

/**
 *
 * @author Administrator
 */
@Transactional
@Controller
//@RequestMapping("/record/")
public class StaffRecordController {

    @Autowired
    SessionFactory factory;

    @RequestMapping(value = "gnthanhtich", method = RequestMethod.GET)
    public String insert(ModelMap model) {
        model.addAttribute("record", new Records());
        return "gnthanhtich";
    }

    @RequestMapping(value = "gnthanhtich", method = RequestMethod.POST)
    public String insert(ModelMap model, @ModelAttribute("record") Records record) {
        //Session session = factory.openSession();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            record.setDate(new Date());
            session.save(record);
            t.commit();
            model.addAttribute("message", "Thêm mới thành công !");
        } catch (Exception e) {
            t.rollback();
            model.addAttribute("message", "Thêm mới thất bại !");
        } finally {
            session.close();
        }
        return "gnthanhtich";
    }

    @ModelAttribute("staffs")
    public List<Staffs> getStaffs() {
        //Session session = factory.getCurrentSession();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = "from Staffs";
        Query query = session.createQuery(sql);
        List<Staffs> list = query.list();
        return list;
    }

}
