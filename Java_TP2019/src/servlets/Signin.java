package servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Documento;
import entities.Persona;
import logic.Login;
import logic.PersonaControler;

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
		switch (request.getParameter("action")) {
		case "ingresar":
			this.ingresar(request,response);
			break;
		case "registrar":
			request.getRequestDispatcher("WEB-INF/registrarUsuario.jsp").forward(request, response);
			break;
		case "cerrarSesion":
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			break;
		default:
			System.out.println("Error: opcion no disponible");
			break;
		}
		

	}
	
	private void ingresar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		Login ctrl = new Login();
        Persona p = new Persona();
        
        p.setEmail(request.getParameter("email"));
        p.setPassword(request.getParameter("password"));
        try {
        	if (ctrl.checkPassword(p)) {
				p = ctrl.getUser(p);
	            request.getSession().setAttribute("usuario", p);
	            System.out.println("Inicio de sesión del usuario: "+ p.getDocumento().getTipo() + " " + p.getDocumento().getNro());
	            request.getRequestDispatcher("WEB-INF/homeUser.jsp").forward(request, response);
			}else {
				throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
			}
		} catch (IllegalArgumentException e) {

			System.out.println("Inicio de sesión inválido - "+ request.getParameter("email") + ":" + request.getParameter("password"));
			request.getSession().setAttribute("message", "Nombre de usuario y/o contraseña incorrectos.");
			request.getRequestDispatcher("/index.jsp").forward(request,response);
		}

	}
}
