package com.eagle.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eagle.bean.User;
import com.eagle.service.IUserService;
import com.eagle.service.UserServiceImpl;

public class RegisterServlet extends HttpServlet {
	private IUserService serv=new UserServiceImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		int age=Integer.parseInt(req.getParameter("age"));
		User u= new User(username,password,age);
		String page="";
		String msg="";
		try {
			serv.register(u);
			page="/estore/login.jsp";
			msg="注册成功!please 登录!";
			req.setAttribute("username", username);
			
		} catch (Exception e) {
			e.printStackTrace();
			page="/estore/register.jsp";
			msg="注册失败!因为:"+e.getMessage()+"请重新注册!";
		}
		req.setAttribute("msg", msg);
		req.getRequestDispatcher(page).forward(req, resp);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
