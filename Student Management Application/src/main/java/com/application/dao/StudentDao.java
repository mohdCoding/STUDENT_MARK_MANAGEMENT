package com.application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.application.dto.Student;
import com.application.dto.StudentMarks;
import com.util.DatabaseConnection.DBConnection;

public class StudentDao {

	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet resultSet = null;

	public Student get(Integer rollno) {

		Student student = null;
		try {
			connection = DBConnection.connect();

			if (connection != null) {
				String query = "select rollno, name, dob from student where rollno = ?";
				pstmt = connection.prepareStatement(query);
				pstmt.setInt(1, rollno);

				resultSet = pstmt.executeQuery();

				if (resultSet != null) {
					if (resultSet.next()) {
						student = new Student();
						student.setRollno(resultSet.getInt(1));
						student.setName(resultSet.getString(2));
						student.setDob(resultSet.getString(3));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return student;
	}

	public ArrayList<StudentMarks> fetch(Integer rollno, String sem) {
		ArrayList<StudentMarks> studentMarks = new ArrayList<StudentMarks>();
		StudentMarks studentMark = null;
		String query = "select * from sem" + sem + " where rollno = ?";

		try {
			connection = DBConnection.connect();

			if (connection != null) {
				pstmt = connection.prepareStatement(query);
				if (pstmt != null) {
					pstmt.setInt(1, rollno);
					ResultSet resultSet = pstmt.executeQuery();

					if (resultSet != null) {
						while (resultSet.next()) {
							studentMark = new StudentMarks();
							studentMark.setRollno(resultSet.getInt(1));
							studentMark.setSubjectCode(resultSet.getInt(2));
							studentMark.setSubjectName(resultSet.getString(3));
							studentMark.setInternal(resultSet.getInt(4));
							studentMark.setExternal(resultSet.getInt(5));
							studentMark.setTotal(resultSet.getInt(6));
							studentMark.setGrade(resultSet.getString(7));
							studentMark.setResult(resultSet.getString(8));
							studentMarks.add(studentMark);

						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return studentMarks;
	}

	public String update(ArrayList<StudentMarks> studentDetails, String sem) {
		String status = "failure";

		String query = "update sem" + sem
				+ " set subject_code = ?, subject_name = ?, internal = ?, external = ?, total = ?, grade = ?, result = ? where subject_code = ?";
		try {
			connection = DBConnection.connect();

			pstmt = connection.prepareStatement(query);
			StudentMarks studentMarks = null;
			if (pstmt != null) {
				for (int i = 0; i < studentDetails.size(); i++) {
					studentMarks = studentDetails.get(i);

					pstmt.setInt(1, studentMarks.getSubjectCode());

					pstmt.setString(2, studentMarks.getSubjectName());

					pstmt.setInt(3, studentMarks.getInternal());

					pstmt.setInt(4, studentMarks.getExternal());

					pstmt.setInt(5, studentMarks.getTotal());

					pstmt.setString(6, studentMarks.getGrade());

					pstmt.setString(7, studentMarks.getResult());

					pstmt.setInt(8, studentMarks.getSubjectCode());

					Integer rowsAff = pstmt.executeUpdate();
					status = "success";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public ArrayList<StudentMarks> fetch(String sem) {
		ArrayList<StudentMarks> studentDetails = new ArrayList<StudentMarks>();

		String query = "select subject_code, subject_name from sem" + sem + " where rollno = ?";
		StudentMarks studentMark = null;
		try {

			connection = DBConnection.connect();

			if (connection != null) {
				pstmt = connection.prepareStatement(query);
				pstmt.setInt(1, 202603217);
				ResultSet resultSet = pstmt.executeQuery();

				if (resultSet != null) {
					while (resultSet.next()) {
						studentMark = new StudentMarks();
						studentMark.setSubjectCode(resultSet.getInt(1));
						studentMark.setSubjectName(resultSet.getString(2));
						studentDetails.add(studentMark);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return studentDetails;
	}

	public String put(Student student) {

		String status = "failure";

		Student student1 = get(student.getRollno());

		if (student1 == null) {
			String query = "insert into student values(?, ?, ?)";
			try {
				connection = DBConnection.connect();

				if (connection != null) {
					pstmt = connection.prepareStatement(query);
					pstmt.setInt(1, student.getRollno());
					pstmt.setString(2, student.getName());
					pstmt.setString(3, student.getDob());

					Integer rowsAff = pstmt.executeUpdate();

					if (rowsAff == 1) {
						status = "success";
					} else {
						status = "failure";
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			status = "success";
		}

		return status;

	}

	public String put(Integer rollno, ArrayList<StudentMarks> studentDetails, String sem) {
		String status = "failure";

		String query = "insert into sem" + sem + " values(?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = DBConnection.connect();

			pstmt = connection.prepareStatement(query);
			StudentMarks studentMarks = null;
			for (int i = 0; i < studentDetails.size(); i++) {
				studentMarks = studentDetails.get(i);

				pstmt.setInt(1, rollno);

				pstmt.setInt(2, studentMarks.getSubjectCode());

				pstmt.setString(3, studentMarks.getSubjectName());

				pstmt.setInt(4, studentMarks.getInternal());

				pstmt.setInt(5, studentMarks.getExternal());

				pstmt.setInt(6, studentMarks.getTotal());

				pstmt.setString(7, studentMarks.getGrade());

				pstmt.setString(8, studentMarks.getResult());

				Integer rowsAff = pstmt.executeUpdate();
				if (rowsAff == 1) {
					status = "success";
				} else {
					status = "failure";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;

	}

//	private String delete(Integer rollno) {
//
//		String status = "failure";
//		String query = "delete from student where rollno = ?";
//		try {
//			connection = DBConnection.connect();
//
//			if (connection != null) {
//				pstmt = connection.prepareStatement(query);
//				pstmt.setInt(1, rollno);
//
//				Integer rowsAff = pstmt.executeUpdate();
//
//				if (rowsAff == 1) {
//					status = "success";
//				} else {
//					status = "failure";
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return status;
//	}

	public String delete(Integer rollno, String sem) {
		String status = "failure";
		String query = "delete from sem" + sem + " where rollno = ?";

		try {
		

			
				connection = DBConnection.connect();

				if (connection != null) {
					pstmt = connection.prepareStatement(query);
					pstmt.setInt(1, rollno);

					Integer rowsAff = pstmt.executeUpdate();

					if (rowsAff >= 1) {
						status = "success";
					} else {
						status = "failure";
					}

				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

}
