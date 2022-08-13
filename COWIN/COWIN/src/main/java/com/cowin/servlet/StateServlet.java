package com.cowin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cowin.dao.StateDAO;
import com.cowin.dto.State;

@WebServlet("/StateServlet")  
public class StateServlet extends HttpServlet {  
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
          
        List<State> status = new ArrayList<State>();
		try {
			status = StateDAO.stateList();
			if(!status.isEmpty()){  
	        	for(State state : status){  
	        		out.print("<option value="+state.getStateId()+">"+state.getStateName()+"</option>");  
	        	}  
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }  
}