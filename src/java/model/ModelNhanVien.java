/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.NhanVien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ModelNhanVien {

    public ModelNhanVien() {
    }

    static final String URL = "jdbc:sqlserver://daunvps0444.database.windows.net:1433;database=DauNVPS04444;user=daunvps0444@daunvps0444;password=Dau123456!";
    public static List<NhanVien> showNhanVien(String ten) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(URL);
            String sql = "select * from Staffs";
            if (ten.length() > 0) {
                sql += " where Id like '%" + ten + "%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<NhanVien> list = new ArrayList<NhanVien>();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                boolean gender = rs.getBoolean("gender");
                Date birthday = rs.getDate("birthday");
                String photo = rs.getString("photo");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                Double salary = rs.getDouble("salary");
                String notes = rs.getString("notes");
                String departid = rs.getString("departid");
                NhanVien nv = new NhanVien(id, name, gender, birthday, photo, email, phone, salary, notes, departid);
                list.add(nv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void insert(NhanVien nv) {
        try {
            java.sql.Date sqlDate = java.sql.Date.valueOf(nv.getBirthday().toString());
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(URL);
            String sql = "insert into Staffs values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getId());
            ps.setString(2, nv.getName());
            ps.setBoolean(3, nv.getGender());
            ps.setDate(4, sqlDate);
            ps.setString(5, nv.getPhoto());
            ps.setString(6, nv.getEmail());
            ps.setString(7, nv.getPhone());
            ps.setDouble(8, nv.getSalary());
            ps.setString(9, nv.getNotes());
            ps.setString(10, nv.getDepartid());
            ps.execute();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void delete(String id) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(URL);
            String sql = "delete from Staffs where id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, id);
            stm.execute();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(NhanVien nv) {
        try {
            java.sql.Date sqlDate = java.sql.Date.valueOf(nv.getBirthday().toString());
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(URL);
            String sql = "update Staffs set name=?, gender=?, birthday=?,photo=?,"
                    + "email=?, phone=?,salary=?,notes=?,departid=? where id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, nv.getName());
            stm.setBoolean(2, nv.getGender());
            stm.setDate(3, sqlDate);
            stm.setString(4, nv.getPhoto());
            stm.setString(5, nv.getEmail());
            stm.setString(6, nv.getPhone());
            stm.setDouble(7, nv.getSalary());
            stm.setString(8, nv.getNotes());
            stm.setString(9, nv.getDepartid());
            stm.setString(10, nv.getId());
            stm.execute();
            stm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkLogin(String user, String pass) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://daunvps0444.database.windows.net:1433;database=DauNVPS04444";
            Connection con = DriverManager.getConnection(url, "daunvps0444@daunvps0444", "Dau123456!");
            String sql = "select * from Users where Username=? and Password=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, user);
            stm.setString(2, pass);
            ResultSet rs = stm.executeQuery();
            boolean exist = false;
            exist = rs.next();
            rs.close();
            stm.close();
            con.close();
            if (exist) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
