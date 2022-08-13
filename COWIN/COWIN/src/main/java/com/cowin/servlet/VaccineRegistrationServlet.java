package com.cowin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cowin.dao.VaccineCenterDAO;
import com.cowin.dao.VaccineDetailsDAO;
import com.cowin.dto.VaccineCenter;
import com.cowin.dto.VaccineDetails;

@WebServlet("/VaccineRegistrationServlet")  
public class VaccineRegistrationServlet extends HttpServlet {  
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
          
        String vaccineDose = request.getParameter("vaccineDose");  
        String state = request.getParameter("state");  
        String district = request.getParameter("district"); 
        String vaccineCenter = request.getParameter("vaccineCenter"); 
          
        VaccineDetails vd = new VaccineDetails(); 
        vd.setVaccineDose(vaccineDose);
        vd.setVaccineCenter(vaccineCenter);
        vd.setState(state);
        vd.setDistrict(district);
        vd.setVaccineStatus("Registered");
        vd.setCreatedBy("admin");
          
        int status = VaccineDetailsDAO.save(vd);  
        if(status > 0){  
            out.print("<p> Vaccine Center Saved successfully! </p>");  
            request.getRequestDispatcher("UserRegistration.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
        out.close();  
    }  
}  
