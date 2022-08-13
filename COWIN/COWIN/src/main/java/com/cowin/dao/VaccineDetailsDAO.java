package com.cowin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cowin.dto.VaccineCenter;
import com.cowin.dto.VaccineDetails;

public class VaccineDetailsDAO {
	
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
	
    public static int save(VaccineDetails vd){  
        int status=0;  
        try{  
            Connection con = VaccineDetailsDAO.getConnection();  
            PreparedStatement ps = con.prepareStatement("insert into vaccine_details(user_id, vaccine_dose, vaccine_date, vaccine_status, create_date, create_by, state, district) values (?,?,?,?,?,?,?,?)");  
            ps.setInt(1, vd.getUserId());  
            ps.setString(2, vd.getVaccineDose());  
            long millis = System.currentTimeMillis();
            ps.setDate(3, new java.sql.Date(millis));  
            ps.setString(4, vd.getVaccineStatus());  
            ps.setDate(5, new java.sql.Date(millis));  
            ps.setString(6, vd.getCreatedBy());  
            ps.setString(7, vd.getState());  
            ps.setString(8, vd.getDistrict());  
            status = ps.executeUpdate(); 
            con.close();  
        }catch(Exception ex){
        	ex.printStackTrace();
        }  
        return status;  
    }  

    public static List<VaccineDetails> vaccineDetailsList() throws SQLException {
        List<VaccineDetails> vaccineDetailsList = new ArrayList<>();
        try{  
            Connection con = StateDAO.getConnection();  
            Statement st = con.createStatement(); 
            ResultSet result = st.executeQuery("SELECT * FROM vaccine_details ORDER BY center_name");
            while (result.next()) {
                int id = result.getInt("center_id");
                String name = result.getString("center_name");
                VaccineDetails vd = new VaccineDetails();
                //vc.setCenterId(id);
                //vc.setCenterName(name);
                vaccineDetailsList.add(vd);
            } 
            con.close();  
        }catch(Exception ex){
        	ex.printStackTrace();
        }  
        return vaccineDetailsList;  
    }
}  
