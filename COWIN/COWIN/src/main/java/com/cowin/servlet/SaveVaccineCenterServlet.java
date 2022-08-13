package com.cowin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cowin.dao.VaccineCenterDAO;
import com.cowin.dto.VaccineCenter;

@WebServlet("/SaveVaccineCenterServlet")  
public class SaveVaccineCenterServlet extends HttpServlet {  
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
          
        String centerName = request.getParameter("centerName");  
        String state = request.getParameter("state");  
        String district = request.getParameter("district");  
          
        VaccineCenter vc = new VaccineCenter(); 
        vc.setCenterName(centerName);
        vc.setState(state);
        vc.setDistrict(district);
          
        int status = VaccineCenterDAO.save(vc);  
        if(status > 0){  
            out.print("<p> Vaccine Center Saved successfully! </p>");  
            request.getRequestDispatcher("UserRegistration.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
        out.close();  
    }  
}  
