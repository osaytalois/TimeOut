

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import implementation.UserDAO;
import logic.User;
import implementation.MessageService;
import logic.Recent;import java.util.ArrayList;

/**
 * Servlet implementation class RefreshPNavServlet
 */
@WebServlet("/RefreshPNavServlet")
public class RefreshPNavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefreshPNavServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO uD = new UserDAO();
		MessageService mS = new MessageService();
		ArrayList<Recent> recents = new ArrayList<Recent>();
		HttpSession session = request.getSession();
		recents = mS.getAllRecent(((User)session.getAttribute("user")).getIdUser());
		if(recents!=null){
			if(recents.size()>0)
				session.setAttribute("talkingWith", uD.getUserByID(recents.get(0).getRecipient()));
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/messages.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
