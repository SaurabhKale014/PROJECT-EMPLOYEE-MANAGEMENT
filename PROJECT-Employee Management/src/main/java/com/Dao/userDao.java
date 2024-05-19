package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.Entity.Employee;

public class userDao {
	
	public static String insertEmp(int id,String name,int sal ,Connection con)
	{
		String res="";
		try {
			String sql ="insert into empManage values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, sal);
			
			int row = ps.executeUpdate();
			if(row==1)
			{
				res="inserted";
			}
			else
			{
				res="not inserted";
			}

			
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			return res;
		}
		
	}
	

	
	
	public static String updateEmp(int id,String name, int salary,Connection con)
	{
		String res="";
		try {
			String sql = "update empManage set empNAME=? , empSALARY=? where empID=?";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(3, id);
			ps.setString(1, name);
			ps.setInt(2, salary);
			
			int row=ps.executeUpdate();
			if(row==1)
			{
				res="updated";
			}
			else
			{
				res="failed";
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			return res;
		}
	}
	
	public static String deleteEmp(int id , Connection con)
	{
		String res="";
		try {
			String sql = "delete from empManage where empID=?";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, id);
			int row=ps.executeUpdate();
			if(row==1)
			{
				res="deleted";
			}
			else
			{
				res="failed";
			}
			
		} catch (Exception e) {
			
		}
		finally {
			
			return res;
		}
	}
	
	public ArrayList<Employee> viewEmps(Connection con)
	{
		ArrayList<Employee> emp =new ArrayList<Employee>();
		
		try {
			String sql = "select * from empManage";
			Statement st=con.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getInt(3));
				
				emp.add(e);
			}
		} catch (Exception e) {
			
		}
		finally {
			return emp;
		}
	}

}
