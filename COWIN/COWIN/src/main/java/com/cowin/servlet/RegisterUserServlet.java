package com.cowin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cowin.dao.UserDAO;
import com.cowin.dto.User;

@WebServlet("/RegisterUserServlet")  
public class RegisterUserServlet extends HttpServlet {  
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
          
        String userName = request.getParameter("userName");  
        String phoneNumber = request.getParameter("phoneNumber");  
        String age = request.getParameter("age");  
        String aadhar = request.getParameter("aadhar");
        String loginUserName = request.getParameter("loginUserName");  
        String password = request.getParameter("password"); 
        
        User user = new User(); 
        user.setName(userName);
        user.setUserName(loginUserName);
        user.setAadharNumber(aadhar);
        user.setAge(age);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
          
        int status = UserDAO.save(user);  
        if(status > 0){  
            out.print("<p> User Registered successfully! </p>");  
            request.getRequestDispatcher("VAccineRegistration.jsp").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
        out.close();  
    }  
}  
