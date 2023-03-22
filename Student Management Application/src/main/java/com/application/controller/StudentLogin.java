package com.application.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.DatabaseConnection.DBConnection;

@WebServlet("/StudentLogin")
public class StudentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer rollno = Integer.parseInt(request.getParameter("rollno"));

		try {

			String query = "select rollno from student where rollno = ?";
			Connection connection = DBConnection.connect();

			HttpSession session = request.getSession();

			PreparedStatement pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, rollno);

			ResultSet resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
			
				 session.setAttribute("StudentLoggedIn", "success");
				 RequestDispatcher rd = request.getRequestDispatcher("./admin-access.jsp");
				 rd.forward(request, response);
				
				
				

			} else {
				System.out.println("COntroll in else prt");
				session.setAttribute("studentLogin", "Invalid email/password");
				RequestDispatcher rd = request.getRequestDispatcher("./studentlogin.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
