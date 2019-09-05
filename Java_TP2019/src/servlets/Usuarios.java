package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Documento;
import entities.Persona;
import logic.PersonaControler;

/**
 * Servlet implementation class Usuarios
 */
@WebServlet("/Usuarios")
public class Usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuarios() {
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
		PersonaControler perCtrl = new PersonaControler();
		ArrayList<Persona> personas = new ArrayList<Persona>();
		personas = perCtrl.getAll();
		request.getSession().setAttribute("listaPersonas", personas);
		
		switch (request.getParameter("action")) {
		case "agregar":
			this.agregar(request,response);
			break;
		case "editar":
			this.editar(request,response);
			break;
		case "eliminar":
			this.eliminar(request,response);
			break;
		case "gestionUsuario":
			request.getRequestDispatcher("/WEB-INF/gestionUsuario.jsp").forward(request, response);
			break;
		case "nuevoUsuario":
			request.getRequestDispatcher("/WEB-INF/nuevoUsuario.jsp").forward(request, response);
			break;
		case "gestionInstalaciones":
			request.getRequestDispatcher("/WEB-INF/home_user.jsp").forward(request, response);
			break;
		default:
			break;
		}
	}
	
	private void agregar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		Persona p = new Persona();
		p.setDocumento(new Documento());
		PersonaControler perCtrl = new PersonaControler();
		
		p.setNombre(request.getParameter("nombre"));
		p.setApellido(request.getParameter("apellido"));
		p.getDocumento().setTipo(request.getParameter("tipo_doc"));
		p.getDocumento().setNro(request.getParameter("nro_doc"));
		p.setEmail(request.getParameter("email"));
		p.setPassword(request.getParameter("password"));
		p.setTel(request.getParameter("tel"));
		p.setHabilitado(true);
		
		perCtrl.altaPersona(p);
		
		request.getRequestDispatcher("/WEB-INF/gestionUsuario.jsp").forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		int idPersona = Integer.parseInt(request.getParameter("idUsuario"));
		PersonaControler perCtrl = new PersonaControler();
		
		perCtrl.bajaPersona(idPersona);
		
		request.getRequestDispatcher("/WEB-INF/gestionUsuario.jsp").forward(request, response);
		
	}

}
