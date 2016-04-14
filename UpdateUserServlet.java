

import java.io.IOException;
import implementation.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.User;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
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
		
		User u = (User) request.getSession().getAttribute("user");
	
		String dpPath = request.getParameter("new_dp");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String oldPassword = request.getParameter("old_password");
		String newPassword = request.getParameter("new_password");
		String newPassword1 = request.getParameter("new_password1");
		//String birthdayMonth = request.getParameter("birthday_month");
		//String birthdayDay = request.getParameter("birthday_day");
		//String birthdayYear = request.getParameter("birthday_year");
		
		//String dateString = birthdayDay+"-"+birthdayMonth+"-"+birthdayYear;
		//DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
		
		//try{
			//Date d = df.parse(dateString);
			//System.out.println(df.format(d));
		//}catch(Exception ex){
			//System.out.println(ex);
		//}
		UserDAO dao = new UserDAO();
		User user = dao.getUserByUsername(u.getUsername());

		 if(user.getPassword().equals(oldPassword) && newPassword.equals(newPassword1)){
			user.setDp(dpPath);
			user.setFirstName(firstname);
			user.setSurName(lastname);
			user.setPassword(newPassword);
			
			dao.updateUser(u);
			
			request.getSession().setAttribute("user",u);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/ProfileServlet");
			rd.forward(request, response);
			
	}else{
			response.sendRedirect("settings.html");
		}
	}

}
