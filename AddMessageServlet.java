

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import implementation.MessageService;
import implementation.UserDAO;
import logic.User;

/**
 * Servlet implementation class AddMessageServlet
 */
@WebServlet("/AddMessageServlet")
public class AddMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = request.getParameter("tempMessageSend");
		UserDAO uD = new UserDAO();
		MessageService mS = new MessageService();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(((User)session.getAttribute("talkingWith"))!=null)
			if(uD.getUserByUsername(((User)session.getAttribute("talkingWith")).getUsername())!=null){
				User talking = (User)session.getAttribute("talkingWith");
				mS.addMessage(user.getIdUser(), talking.getIdUser(), message, new java.sql.Date(new Date().getTime()));
			}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/messages.jsp");
		rd.forward(request, response);
	}

}
