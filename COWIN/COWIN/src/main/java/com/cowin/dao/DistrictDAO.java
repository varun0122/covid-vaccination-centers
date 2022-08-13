package com.cowin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cowin.dto.District;

public class DistrictDAO {
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
	
	public static List<District> districtList(String stateID) throws SQLException {
        List<District> listDistrict = new ArrayList<>();
        try{  
            Connection con = DistrictDAO.getConnection();  
            Statement st = con.createStatement(); 
            ResultSet result = st.executeQuery("SELECT * FROM district where state_id = '"+stateID+"' ORDER BY district_name");
            while (result.next()) {
                int id = result.getInt("district_id");
                String name = result.getString("district_name");
                District district = new District();
                district.setDistrictId(id);
                district.setDistrictname(name);
                listDistrict.add(district);
            } 
            con.close();  
        }catch(Exception ex){
        	ex.printStackTrace();
        }  
        return listDistrict;  
    } 
}
