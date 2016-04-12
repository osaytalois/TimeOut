

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import implementation.SignupService;
import implementation.UserDAO;
import implementation.UserInfoService;
import logic.User;
import logic.UserInfo;

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
		String userName = request.getParameter("userName_signup");
		String position = request.getParameter("position");
		String  password = request.getParameter("password_signup");
		String password1 = request.getParameter("password1_signup");

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
				UserDAO uD = new UserDAO();
				user = uD.getUserByUsername(user.getUsername());
				session.setAttribute("user",user);
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/profile.jsp");
				rd.forward(request, response);
			}else{
				response.sendRedirect("index.html");
			}
		}else{
			response.sendRedirect("index.html");
		}
		
	}

}
