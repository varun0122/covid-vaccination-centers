package com.cowin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cowin.dto.State;

public class StateDAO {

	
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
	
	public static List<State> stateList() throws SQLException {
        List<State> listState = new ArrayList<>();
        try{  
            Connection con = StateDAO.getConnection();  
            Statement st = con.createStatement(); 
            ResultSet result = st.executeQuery("SELECT * FROM state ORDER BY state_name");
            while (result.next()) {
                int id = result.getInt("state_id");
                String name = result.getString("state_name");
                State state = new State();
                state.setStateId(id);
                state.setStateName(name);
                listState.add(state);
            } 
            con.close();  
        }catch(Exception ex){
        	ex.printStackTrace();
        }  
        return listState;  
    }  

}
