package org.jsp.userproduct.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.userproduct.dao.UserDao;
import org.jsp.userproduct.dto.User;
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		long phone=Long.parseLong(req.getParameter("ph"));
		String password=req.getParameter("ps");
		String email=req.getParameter("em");
		String gender=req.getParameter("gender");
		String name=req.getParameter("nm");
		int age=Integer.parseInt(req.getParameter("age"));
		User u=new User();
		u.setAge(age);
		u.setEmail(email);
		u.setName(name);
		u.setPassword(password);
		u.setGender(gender);
		u.setPhone(phone);
		UserDao dao=new UserDao();
		u=dao.saveUser(u);
		PrintWriter writer=resp.getWriter();
		writer.write("<html><body><h2>Register with id:" +u.getId() + "</h2></body></html>");
	}
}