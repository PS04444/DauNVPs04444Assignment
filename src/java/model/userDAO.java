/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Users;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;


public class userDAO {
     public static List<Users> layDanhSachUser(String ten){
        List<Users> list = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql="from Users";
        if(ten.length()>0){
            sql += " where username like '%"+ten+"%'";
        }
        Query query = session.createQuery(sql);
        list = query.list();
        return list;
    }    
     public static Users layThongTinUser(String maSV){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Users user = (Users)session.get(Users.class, maSV);
        session.close();
        return user;
    }
    public static boolean themUser(Users user){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();
        if(userDAO.layThongTinUser(user.getUsername())!=null)
            return false;
        try{
            session.getTransaction().begin();
            session.save(user);
            session.flush();
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
}
