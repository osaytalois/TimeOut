

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implementation.UserDAO;
import logic.User;

/**
 * Servlet implementation class PersonClickServlet
 */
@WebServlet("/PersonClickServlet")
public class PersonClickServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonClickServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDAO uD = new UserDAO();
		int friend = Integer.parseInt(request.getParameter("tempPersonClick").toString());
		if(friend!=((User)request.getSession().getAttribute("user")).getIdUser())
			request.getSession().setAttribute("talkingWith", uD.getUserByID(friend));
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/messages.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
