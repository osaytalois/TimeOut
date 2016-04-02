

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import implementation.SignupService;
import logic.User;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String position = request.getParameter("position");
		String password = request.getParameter("password");
		String password1 = request.getParameter("password1");

		User user = new User(-99 , userName, password, firstName, middleName, lastName, "null", position);
		SignupService signupService = new SignupService();		
		try{
		Date dob = new SimpleDateFormat("MM/dd/yyyy").parse("01/01/01");
		user.setDob(dob);
		}catch (ParseException | java.text.ParseException e) {  
            e.printStackTrace();  
        } 
		boolean result = signupService.checkUser(userName);
		
		if(result){
			if(password.equals(password1)){
				signupService.setUserDetails(user);
				System.out.println("user added beh");
				HttpSession session = request.getSession();
				session.setAttribute("user",user);
				response.sendRedirect("news.html");
			}else{
				response.sendRedirect("index.html");
			}
		}else{
			response.sendRedirect("index.html");
		}
		
	}

}
