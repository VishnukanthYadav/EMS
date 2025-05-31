package web_ems.services;

public interface DBService {
	
	public void connectDB();
	public boolean verifyLogin(String email, String password);

}
