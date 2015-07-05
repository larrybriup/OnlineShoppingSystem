package com.eagle.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eagle.bean.User;
import com.eagle.dao.IUserDao;
import com.eagle.dao.IUserDaoImpl;
import com.eagle.service.IUserService;
import com.eagle.service.UserServiceImpl;

public class checkServlet extends HttpServlet {
	private IUserDao iud= new IUserDaoImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String username=req.getParameter("username");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		String msg="";
		try {
			User user = iud.findUserByName(username);
			if(user==null){
				msg="^_^此用户名可用";
			}else{
				msg="~.~用户名已经被占用,请重新输入";
			}
			out.print(msg);
		} catch (Exception e) {
			e.printStackTrace();
			msg+=e.getMessage();
			out.print(msg);
		}
		
		out.flush();
		out.close();
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
