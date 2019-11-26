package servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Persona;
import logic.Login;

@WebServlet("/Signin")
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Signin() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//HttpSession session = request.getSession(false);
		//if(session != null) session.invalidate();
		request.getRequestDispatcher("/index.html").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Login ctrl = new Login();
        Persona p = new Persona();
        
        p.setEmail(request.getParameter("email"));
        p.setPassword(request.getParameter("password"));
        
        p = ctrl.validate(p);
        request.getSession().setAttribute("usuario", p);
        System.out.println(p);

        request.getRequestDispatcher("WEB-INF/homeUser.jsp").forward(request, response);
	}
}
