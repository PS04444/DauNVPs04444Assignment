/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ModelIndex {

    public ModelIndex() {
    }

    static final String URL = "jdbc:sqlserver://daunvps0444.database.windows.net:1433;database=DauNVPS04444;user=daunvps0444@daunvps0444;password=Dau123456!";

    public static List<Object[]> showTop10(String ten) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=ASM_JAVA5";
            Connection con = DriverManager.getConnection(url, "daunvps0444@daunvps0444", "Dau123456!");
            String sql = "select top 10 r.StaffId,s.Name,s.Photo,s.Email,s.Phone, SUM(case when r.type=1 then 1 else 0 end) -"
                    + "        SUM(case when r.type=0 then 1 else 0 end) as KQ"
                    + "        FROM Records r inner join Staffs s"
                    + "		on s.Id = r.StaffId"
                    + "        GROUP BY r.staffid,s.Name,s.Photo,s.Email,s.Phone"
                    + "		Order by KQ DESC";

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<Object[]> list = new ArrayList<Object[]>();
            while (rs.next()) {
                Object ob = new Object();
                
                //list.add(ob);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
