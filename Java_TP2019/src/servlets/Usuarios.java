package servlets;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Documento;
import entities.Persona;
import logic.PersonaControler;
import servlets.*;

@WebServlet("/Usuarios")
public class Usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Usuarios() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		switch (request.getParameter("action")) {
		case "agregar":
			this.agregar(request,response);
			this.listar(request, response);
			break;
		case "registrar":
			this.agregar(request,response);
			request.getRequestDispatcher("/index.html").forward(request, response);
		case "listar":
			this.listar(request,response);
			break;
		case "actualizar":
			this.actualizar(request,response);
			break;
		case "eliminar":
			this.eliminar(request,response);
			break;
		case "gestionUsuario":
			this.listar(request,response);
			break;
		case "nuevoUsuario":
			request.getRequestDispatcher("/WEB-INF/nuevoUsuario.jsp").forward(request, response);
			break;
		case "modificarUsuario":
			this.buscarPorId(request,response);
			request.getRequestDispatcher("/WEB-INF/modificarUsuario.jsp").forward(request, response);
			break;
		case "homeUser":
			request.getRequestDispatcher("/WEB-INF/homeUser.jsp").forward(request, response);
			break;
		case "index":
			request.getRequestDispatcher("/index.html").forward(request, response);
			break;
		default:
			System.out.println("Error: opcion no disponible");
			break;
		}
	}
	
	private void agregar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		Persona p = new Persona();
		PersonaControler perCtrl = new PersonaControler();
		
		p.setNombre(request.getParameter("nombre"));
		p.setApellido(request.getParameter("apellido"));
		p.setDocumento(new Documento());
		p.getDocumento().setTipo(request.getParameter("tipo_doc"));
		p.getDocumento().setNro(request.getParameter("nro_doc"));
		p.setEmail(request.getParameter("email"));
		p.setPassword(request.getParameter("password"));
		p.setTel(request.getParameter("tel"));
		p.setHabilitado((Integer.parseInt(request.getParameter("habilitado"))==1)?true:false);
		p.setRol(request.getParameter("rol"));
		
		perCtrl.altaPersona(p);
		//this.listar(request, response);
		
		
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		PersonaControler perCtrl = new PersonaControler();
		ArrayList<Persona> personas = new ArrayList<Persona>();
		
		personas = perCtrl.getAll();
		request.getSession().setAttribute("listaPersonas", personas);
		
		request.getRequestDispatcher("/WEB-INF/gestionUsuario.jsp").forward(request, response);	
	}
	
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		Persona p = new Persona();
		PersonaControler perCtrl = new PersonaControler();
		int idPersona = Integer.parseInt(request.getParameter("idUsuario"));
		
		p.setNombre(request.getParameter("nombre"));
		p.setApellido(request.getParameter("apellido"));
		p.setDocumento(new Documento());
		p.getDocumento().setTipo(request.getParameter("tipo_doc"));
		p.getDocumento().setNro(request.getParameter("nro_doc"));
		p.setEmail(request.getParameter("email"));
		p.setPassword(request.getParameter("password"));
		p.setTel(request.getParameter("tel"));
		p.setHabilitado((Integer.parseInt(request.getParameter("habilitado"))==1)?true:false);
		p.setRol(request.getParameter("rol"));
		
		perCtrl.modificarPersona(p, idPersona);
		this.listar(request, response);
		
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		PersonaControler perCtrl = new PersonaControler();
		int idPersona = Integer.parseInt(request.getParameter("idUsuario"));
		
		perCtrl.bajaPersona(idPersona);
		
		this.listar(request, response);
	}
	
	private void buscarPorId(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		Persona p = new Persona();
		PersonaControler perCtrl = new PersonaControler();
		int idPersona = Integer.parseInt(request.getParameter("idUsuario"));
		
		p = perCtrl.buscarPersonaPorId(idPersona);
		request.getSession().setAttribute("usuarioModificar", p);
	}

}
