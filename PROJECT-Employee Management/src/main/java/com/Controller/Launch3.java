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
@WebServlet("/deleteEmp")
public class Launch3 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ID = req.getParameter("ID");
		int id = Integer.parseInt(ID);
		
		Connection con = ConnectionFactory.getCon();
		userDao uDao = new userDao();
		
		String res = uDao.deleteEmp(id, con);
		if(res.equals("deleted"))
		{
			resp.sendRedirect("index.html");
		}
		else
		{
			resp.sendRedirect("delete.html");
		}
	}

}
