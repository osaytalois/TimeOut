

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import implementation.SearchService;
import java.util.ArrayList;
import logic.User;
import logic.Event;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
		
		String query = request.getParameter("searchBox");
		
		SearchService search = new SearchService();
		
		User u = (User) request.getSession().getAttribute("user");
		
		ArrayList<User> searchUsers = search.searchUser(query);
		ArrayList<Event> searchEvents = search.searchEvents(query);
		
		//check if the search query is the user
		for(int i = 0; i <searchUsers.size();i++){
			if(searchUsers.get(i).getUsername().equals(u.getUsername())){
				searchUsers.remove(i);
				searchUsers.add(new User("null"));
			}
		}
		
		//check the contents of the result of the query
		System.out.println(searchUsers.size());
		for(int i = 0; i<searchUsers.size(); i++)
			System.out.println(searchUsers.get(i).getUsername()+" "+searchUsers.get(i).getDp());
		System.out.println();
		
		if(searchUsers.size() > 0)
			request.getSession().setAttribute("searchUsers",searchUsers);
		
		if(searchEvents.size() > 0)
			request.getSession().setAttribute("searchEvents", searchEvents);
				
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/searchResults.jsp");
		rd.forward(request, response);
	}

}
