package web_ems.services;

import java.sql.ResultSet;

public interface DBService {
	
	public void connectDB();
	public boolean verifyLogin(String email, String password);
    public ResultSet getUserByEmail(String email);
    public  void createRegistration(String name,String email,String course, String mobile, int userId);
}
