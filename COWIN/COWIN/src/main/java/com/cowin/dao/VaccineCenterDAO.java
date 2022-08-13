package com.cowin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cowin.dto.State;
import com.cowin.dto.VaccineCenter;

public class VaccineCenterDAO {
	
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cowindb?user=root&password=admin");  
        }catch(Exception e){
        	e.printStackTrace();
        }  
        return con;  
    }  
	
    public static int save(VaccineCenter vc){  
        int status=0;  
        try{  
            Connection con = VaccineCenterDAO.getConnection();  
            PreparedStatement ps = con.prepareStatement("insert into vaccine_center(center_name, state, district) values (?,?,?)");  
            ps.setString(1, vc.getCenterName());  
            ps.setString(2, vc.getState());  
            ps.setString(3, vc.getDistrict());  
            status = ps.executeUpdate();  
            con.close();  
        }catch(Exception ex){
        	ex.printStackTrace();
        }  
        return status;  
    }  

    public static List<VaccineCenter> vaccineCenterList() throws SQLException {
        List<VaccineCenter> vaccineCenterList = new ArrayList<>();
        try{  
            Connection con = StateDAO.getConnection();  
            Statement st = con.createStatement(); 
            ResultSet result = st.executeQuery("SELECT * FROM vaccine_center ORDER BY center_name");
            while (result.next()) {
                int id = result.getInt("center_id");
                String name = result.getString("center_name");
                VaccineCenter vc = new VaccineCenter();
                vc.setCenterId(id);
                vc.setCenterName(name);
                vaccineCenterList.add(vc);
            } 
            con.close();  
        }catch(Exception ex){
        	ex.printStackTrace();
        }  
        return vaccineCenterList;  
    }
}  
