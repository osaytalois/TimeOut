

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import implementation.PostService;
import implementation.UserDAO;
import logic.Post;
import logic.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
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
		PrintWriter pw = response.getWriter();
		PostService p = new PostService();
		UserDAO uD = new UserDAO();
		HttpSession session = request.getSession();
		String uname = ((User)session.getAttribute("user")).getUsername();
		if(uD.getUserByUsername(uname)!=null){
			p.addPost(new Post(new Date(), request.getParameter("toPost"), uD.getUserByUsername(uname).getIdUser()), uname);
			//pw.println(uD.getUserByName(uname).getUsername()+" "+uD.getUserByName("loisO").getIdUser());
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/news.jsp");
		rd.forward(request, response);
	}

}
