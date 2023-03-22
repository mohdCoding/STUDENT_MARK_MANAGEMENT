package com.application.controller;

import java.io.IOException;
import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.application.dao.StudentDao;
import com.application.dto.Student;
import com.application.dto.StudentMarks;
import com.application.factory.ServiceFactory;
import com.application.service.ServiceImpl;
import com.mysql.cj.Session;

@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response) {
		String requestURI = request.getRequestURI();

		if (requestURI.endsWith("admin-page")) {

			String email = request.getParameter("email");
			String password = request.getParameter("password");

			ServiceImpl serviceImpl = new ServiceImpl();

			Boolean flag = serviceImpl.check(email, password);

			if (flag) {

				try {
					HttpSession session = request.getSession();
					session.setAttribute("admin-login", "success");
					response.sendRedirect("../admin-access.jsp");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {

				try {
					HttpSession session = request.getSession();
					session.setAttribute("login-failure", "Invalid Email Or Password");
					response.sendRedirect("../login.jsp");
				} catch (IOException e) {

					e.printStackTrace();
				}

			}

		}

		if (requestURI.endsWith("getstudent")) {

			Integer rollno = Integer.parseInt(request.getParameter("rollno"));
			String sem = request.getParameter("sem");

			ServiceImpl service = new ServiceImpl();
			Student student = service.get(rollno);
			System.out.println(student);
			HttpSession session = request.getSession();

			session.setAttribute("student", student);

			ArrayList<StudentMarks> studentMarks = service.fetch(rollno, sem);
			System.out.println(studentMarks + " :: ");

			if (studentMarks.isEmpty()) {

				session.setAttribute("addSucess", "empty");
				try {
					response.sendRedirect("../admin-access.jsp");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				session.setAttribute("studentMarks", studentMarks);
				try {
					response.sendRedirect("../StudentDetail.jsp");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		if (requestURI.endsWith("edit")) {

			Integer rollno = Integer.parseInt(request.getParameter("editrollno"));
			String sem = request.getParameter("editsem");

			ServiceImpl service = new ServiceImpl();
			Student student = service.get(rollno);

			HttpSession session = request.getSession();
			if (student != null) {
				session.setAttribute("student", student);

				ArrayList<StudentMarks> studentMarks = service.fetch(rollno, sem);

				session.setAttribute("studentMarks", studentMarks);

				RequestDispatcher rd = request.getRequestDispatcher("../update.jsp");
				try {
					rd.forward(request, response);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					session.setAttribute("read-fail", "failure");

					response.sendRedirect("../editpage.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		if (requestURI.endsWith("update")) {

			String semester = request.getParameter("semester");

			String[] subjectCodes = request.getParameterValues("usubject_code");
			String[] subjectNames = request.getParameterValues("usubject_name");
			String[] internals = request.getParameterValues("uinternal");
			String[] externals = request.getParameterValues("uexternal");
			String[] totals = request.getParameterValues("utotal");
			String[] grades = request.getParameterValues("ugrade");
			String[] results = request.getParameterValues("uresult");

			ArrayList<StudentMarks> studentDetails = new ArrayList<>();

			StudentMarks studentMarks = null;

			for (int i = 0; i < subjectCodes.length; i++) {
				studentMarks = new StudentMarks();
				studentMarks.setSubjectCode(Integer.parseInt(subjectCodes[i]));
				studentMarks.setSubjectName(subjectNames[i]);
				studentMarks.setInternal(Integer.parseInt(internals[i]));
				studentMarks.setExternal(Integer.parseInt(externals[i]));
				studentMarks.setTotal(Integer.parseInt(totals[i]));
				studentMarks.setGrade(grades[i]);
				studentMarks.setResult(results[i]);
				studentDetails.add(studentMarks);
			}

			ServiceImpl service = new ServiceImpl();
			String status = service.update(studentDetails, semester);

			if (status.equals("success")) {
				HttpSession session = request.getSession();
				session.setAttribute("update", "success");

				try {
					response.sendRedirect("../../editpage.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("update", "failure");
				try {
					response.sendRedirect("../../editpage.jsp");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		
		
		
		

		if (requestURI.endsWith("add")) {

			String sem = request.getParameter("addsem");

			ServiceImpl service = new ServiceImpl();
			ArrayList<StudentMarks> studentDetails = service.fetch(sem);

			try {
				if (studentDetails != null) {
					HttpSession session = request.getSession();
					
					session.setAttribute("add-student-details", studentDetails);

					RequestDispatcher rd = request.getRequestDispatcher("../addpage.jsp");
					rd.forward(request, response);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		
		
		
		
		if (requestURI.endsWith("insert")) {
			String sem = request.getParameter("addsem");
			Integer rollno = Integer.parseInt(request.getParameter("addrollnumber"));
			String name = request.getParameter("addname");
			String dob = request.getParameter("adddob");

			Student student = new Student();
			student.setRollno(rollno);
			student.setName(name);
			student.setDob(dob);

			ServiceImpl service = new ServiceImpl();
			String status = service.put(student);

			if (status.equals("success")) {
				String[] subjectCodes = request.getParameterValues("addsubjectcode");
				String[] subjectNames = request.getParameterValues("addsubjectname");
				String[] internals = request.getParameterValues("addinternal");
				String[] externals = request.getParameterValues("addexternal");
				String[] totals = request.getParameterValues("addtotal");
				String[] grades = request.getParameterValues("addgrade");
				String[] results = request.getParameterValues("addresult");

				ArrayList<StudentMarks> studentDetails = new ArrayList<>();

				StudentMarks studentMarks = null;

				for (int i = 0; i < subjectCodes.length; i++) {
					studentMarks = new StudentMarks();
					studentMarks.setSubjectCode(Integer.parseInt(subjectCodes[i]));
					studentMarks.setSubjectName(subjectNames[i]);
					studentMarks.setInternal(Integer.parseInt(internals[i]));
					studentMarks.setExternal(Integer.parseInt(externals[i]));
					studentMarks.setTotal(Integer.parseInt(totals[i]));
					studentMarks.setGrade(grades[i]);
					studentMarks.setResult(results[i]);
					studentDetails.add(studentMarks);
				}

				String status1 = service.put(student.getRollno(), studentDetails, sem);

				if (status1.equals("success")) {

					HttpSession session = request.getSession();
					session.setAttribute("new-record", "success");
					try {
						response.sendRedirect("../admin-access.jsp");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					HttpSession session = request.getSession();
					session.setAttribute("new-record", "failure");
					try {
						response.sendRedirect("../admin-access.jsp");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			} else {
				HttpSession session = request.getSession();
				session.setAttribute("new-record", "failure");
				try {
					response.sendRedirect("../admin-access.jsp");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		if (requestURI.endsWith("delete")) {

			Integer rollno = Integer.parseInt(request.getParameter("deleterollno"));
			String sem = request.getParameter("deletesem");

			ServiceImpl service = new ServiceImpl();
			Student student = service.get(rollno);

			if (student != null) {
				String status = service.delete(rollno, sem);

				if (status.equals("success")) {

					HttpSession session = request.getSession();
					session.setAttribute("delete", "success");
					try {
						response.sendRedirect("../deletepage.jsp");
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					HttpSession session = request.getSession();
					session.setAttribute("delete", "failure");
					try {
						response.sendRedirect("../deletepage.jsp");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("delete", "not-found");
				try {
					response.sendRedirect("../deletepage.jsp");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		

	}

}
