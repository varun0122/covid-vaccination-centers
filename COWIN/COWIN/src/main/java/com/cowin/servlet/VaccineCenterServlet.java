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

import com.cowin.dao.VaccineCenterDAO;
import com.cowin.dto.VaccineCenter;

@WebServlet("/VaccineCenterServlet")  
public class VaccineCenterServlet extends HttpServlet {  
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
          
        List<VaccineCenter> status = new ArrayList<VaccineCenter>();
		try {
			status = VaccineCenterDAO.vaccineCenterList();
			if(!status.isEmpty()){  
	        	for(VaccineCenter vc : status){  
	        		out.print("<option value="+vc.getCenterName()+">"+vc.getCenterName()+"</option>");  
	        	}  
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }  
}