package web_ems.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBServiceImpl implements DBService {
	
	public Connection con;
	public Statement stmt;

	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emsDB","root","9844540598");
			stmt=con.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean verifyLogin(String email, String password) {
		try {
			ResultSet rs=stmt.executeQuery("select * from user where email='"+email+"' and password='"+password+"'");
			return rs.next();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ResultSet getUserByEmail(String email) {
		try {
			ResultSet result=stmt.executeQuery("select * from user where email='"+email+"'");
			return result;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void createRegistration(String name, String email, String course, String mobile, int userId) {
      try {
    	  stmt.executeUpdate("insert into registration(name,email,course,mobile,userId) values('"+name+"' ,'"+email+"','"+course+"','"+mobile+"','"+userId+"')");
      }catch(Exception e) {
    	  e.printStackTrace();
      }
	}

}
