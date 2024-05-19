package com.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ConnectionFactory.ConnectionFactory;
import com.Dao.userDao;
import com.Entity.Employee;
@WebServlet("/viewEmp")
public class Launch4 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection con =ConnectionFactory.getCon();
		userDao uDao = new userDao();
		
		ArrayList<Employee> data = uDao.viewEmps(con);
		
		HttpSession s = req.getSession();
		s.setAttribute("emps", data);
		resp.sendRedirect("view.jsp");
	}

}
