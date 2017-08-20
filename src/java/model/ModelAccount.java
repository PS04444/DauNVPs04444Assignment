/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.TaiKhoan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ModelAccount {

    public ModelAccount() {
    }
    
    static final String URL = "jdbc:sqlserver://daunvps0444.database.windows.net:1433;database=DauNVPS04444;user=daunvps0444@daunvps0444;password=Dau123456!";
    
    public static List<TaiKhoan> showTaiKhoan(String ten){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(URL);
            String sql = "select * from Users";
            if(ten.length() > 0){
                sql += " where username like '%"+ten+"%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<TaiKhoan> list = new ArrayList<TaiKhoan>();
            while(rs.next()){
                String user = rs.getString(1);
                String pass = rs.getString(2);
                String fullname = rs.getString(3);
                TaiKhoan tk = new TaiKhoan(user, pass, fullname);
                list.add(tk);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static void delete(String user){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(URL);
            String sql = "delete from Users where Username=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, user);
            stm.execute();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void insert(TaiKhoan tk){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(URL);
            String sql = "insert into Users values(?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, tk.getUsername());
            stm.setString(2, tk.getPassword());
            stm.setString(3, tk.getFullname());
            stm.execute();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void update(TaiKhoan tk){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(URL);
            String sql = "update Users set [password]=?, fullname=? where username=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, tk.getPassword());
            stm.setString(2, tk.getFullname());
            stm.setString(3, tk.getUsername());
            stm.execute();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
