/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.PhongBan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class ModelPhongBan {

    public ModelPhongBan() {
    }
    
    
    static final String URL = "jdbc:sqlserver://daunvps0444.database.windows.net:1433;database=DauNVPS04444;user=daunvps0444@daunvps0444;password=Dau123456";
    
    public static List<PhongBan> showPhongBan(String ten){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://daunvps0444.database.windows.net:1433;database=DauNVPS04444";
            Connection con = DriverManager.getConnection(url, "daunvps0444@daunvps0444", "Dau123456!");
            String sql = "select * from Departs";
            if(ten.length() > 0){
                sql += " where Id like '%"+ten+"%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<PhongBan> list = new ArrayList<PhongBan>();
            while(rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                PhongBan pb = new PhongBan(id,name);
                list.add(pb);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static void insert(PhongBan pb){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(URL);
            String sql = "insert into Departs values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pb.getMapb());
            ps.setString(2, pb.getTenpb());
            ps.execute();
            ps.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static void delete(String mapb){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(URL);
            String sql = "delete from Departs where id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, mapb);
            stm.execute();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void update(PhongBan pb){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(URL);
            String sql = "update Departs set name=? where id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, pb.getTenpb());
            stm.setString(2, pb.getMapb());
            stm.execute();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
