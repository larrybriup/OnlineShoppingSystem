package com.eagle.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eagle.bean.User;
import com.eagle.service.IUserService;
import com.eagle.service.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	private IUserService service = new UserServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		String page = "";
		String msg = "";
		try {
			User user = service.login(username, password);
			// 登录成功,把user对象放到session里面
			req.getSession().setAttribute("user", user);
			page = "/estore/showBooks.jsp";
			msg = "登录成功!欢迎" + username;

		} catch (Exception e) {
			e.printStackTrace();
			page = "/estore/login.jsp";
			msg = "登录失败!" + e.getMessage();
		}
		req.setAttribute("msg", msg);
		req.getRequestDispatcher(page).forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
