package web_ems.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web_ems.services.DBServiceImpl;

import java.io.IOException;
import java.sql.ResultSet;

@WebServlet("/registration")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session=request.getSession(false);
			String email=(String)session.getAttribute("email");
			//System.out.println(email);
			DBServiceImpl dsi =new DBServiceImpl();
			dsi.connectDB();
			ResultSet result=dsi.getUserByEmail(email);
			int userId=0;
			if(result.next()) {
				userId=result.getInt(1);
			}
			String name=request.getParameter("name");
			String course=request.getParameter("course");
			String emailId=request.getParameter("email");
			String mobile=request.getParameter("mobile");
			//System.out.println(mobile);
			//System.out.println(userId);
			dsi.createRegistration(name, emailId, course, mobile, userId);
			
			request.setAttribute("message", "Registration Created");
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/registration.jsp");
			rd.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
