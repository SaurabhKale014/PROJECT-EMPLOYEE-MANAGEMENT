package com.Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ConnectionFactory.ConnectionFactory;
import com.Dao.userDao;
@WebServlet("/updateEmp")
public class Launch2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Id =req.getParameter("ID");
		String name = req.getParameter("NAME");
		String SALARY = req.getParameter("SALARY");
		
		int salary = Integer.parseInt(SALARY);
		int id = Integer.parseInt(Id);
		
		Connection con =ConnectionFactory.getCon();
		userDao uDao = new userDao();
		String res = uDao.updateEmp(id, name, salary, con);
		if(res.equals("updated"))
		{
			resp.sendRedirect("index.html");
		}
		else
		{
			resp.sendRedirect("update.html");
		}
		
		
	}

}
