

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import implementation.EventService;
import logic.Event;
import logic.User;

/**
 * Servlet implementation class AddEventServlet
 */
@WebServlet("/AddEventServlet")
public class AddEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEventServlet() {
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
		EventService eS = new EventService();
		HttpSession session = request.getSession();
		Calendar now = Calendar.getInstance();
		now.set(Calendar.MONTH, Integer.parseInt(request.getParameter("month")));
		now.set(Calendar.DAY_OF_MONTH, Integer.parseInt(request.getParameter("day"))-1);
		now.set(Calendar.YEAR, Integer.parseInt(request.getParameter("year"))-1900);
		now.set(Calendar.HOUR_OF_DAY, Integer.parseInt(request.getParameter("Hour")));
		now.set(Calendar.MINUTE, Integer.parseInt(request.getParameter("Minutes")));
		eS.addEvent(new Event(((User)session.getAttribute("user")).getIdUser(), request.getParameter("loc"), request.getParameter("eName"), now, request.getParameter("desc"), "defaultEvent.jpg"));
		Event tempEvent = eS.getEvent(((User)session.getAttribute("user")).getIdUser(), request.getParameter("loc"), request.getParameter("eName"));
		eS.addEventMember(tempEvent.getId(), tempEvent.getUserID(), 0, ((User)session.getAttribute("user")).getPosition());
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/news.jsp");
		rd.forward(request, response);
	}

}
