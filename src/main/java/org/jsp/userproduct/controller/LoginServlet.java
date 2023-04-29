package org.jsp.userproduct.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsp.userproduct.dao.UserDao;
import org.jsp.userproduct.dto.User;
@WebServlet("/login")
public class LoginServlet  extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException
	{
		long phone=Long.parseLong(req.getParameter("ph"));
		String password=req.getParameter("ps");
		UserDao dao=new UserDao();
		User u=dao.verifyUser(phone,password);
		RequestDispatcher dispatcher=null;
		PrintWriter writer=resp.getWriter();
		if(u!=null)
		{
			HttpSession session=req.getSession();
			session.setAttribute("user", u);
			dispatcher=req.getRequestDispatcher("home.jsp");
			dispatcher.forward(req, resp);
			
		}
		else
		{
			writer.write("<html><body><h2>Invalid phone number or password</h2></body></html>");
			dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}
			
		
		
		
		
	}

}
