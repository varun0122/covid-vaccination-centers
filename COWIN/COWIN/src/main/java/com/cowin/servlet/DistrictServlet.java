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

import com.cowin.dao.DistrictDAO;
import com.cowin.dto.District;

@WebServlet("/DistrictServlet")  
public class DistrictServlet extends HttpServlet {  
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
          
        List<District> status = new ArrayList<District>();
		try {
			status = DistrictDAO.districtList(request.getParameter("stateID"));
			if(!status.isEmpty()){  
	        	for(District district : status){  
	        		out.print("<option value="+district.getDistrictId()+">"+district.getDistrictname()+"</option>");  
	        	}  
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }  
}