package org.jsp.userproduct.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsp.userproduct.dao.UserDao;
import org.jsp.userproduct.dto.User;
@WebServlet("/delete")
public class DeleteuserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
	{
	HttpSession session=req.getSession();
	User u=(User) session.getAttribute("user");
	if(u !=null)
	{
		int id=u.getId();
		UserDao dao=new UserDao();
		dao.deleteUser(id);
		session.invalidate();
		req.setAttribute("msg","your account is deleted");
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
		dispatcher.forward(req, resp);
	}
	else
	{
		resp.sendRedirect("login.jsp");
		
	}
	
	}

}
