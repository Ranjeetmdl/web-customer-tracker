package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServlet
 */
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//set up the connection variables
		String userName="springstudent";
		String password="springstudent";
		String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?"
				+ "useSSL=false&serverTimezone=UTC";
		String driver="com.mysql.cj.jdbc.Driver";
		
		//get connection to the database
		Connection theConnection=null;
		try {
			PrintWriter out=response.getWriter();
			//load the driver
			Class.forName(driver);
			
			//connect to the db
			theConnection=DriverManager.getConnection(jdbcUrl, userName, password);
			out.println("Successfully connect to database!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}finally{
			try {
				theConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
