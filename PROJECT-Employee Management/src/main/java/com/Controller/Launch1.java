package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ConnectionFactory.ConnectionFactory;
import com.Dao.userDao;
@WebServlet("/insertEmp")
public class Launch1 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Id = req.getParameter("ID");
		String name = req.getParameter("NAME");
		String Salary = req.getParameter("SALARY");
		
//		System.out.println(Id);
//		System.out.println(name);
//		System.out.println(Salary);
		
		int id = Integer.parseInt(Id);
		int salary = Integer.parseInt(Salary);
		
		Connection con = ConnectionFactory.getCon();
		userDao uDao= new userDao();
		

		String res = uDao.insertEmp(id, name, salary, con);
		if(res.equals("inserted"))
		{
			resp.sendRedirect("index.html");;
		}
		else
		{
			resp.sendRedirect("insert.html");
		}
		
	}

}
