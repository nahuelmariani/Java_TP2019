package servlets;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Actividad;
import entities.Persona;
import entities.Inscripcion;
import logic.ActividadControler;
import logic.PersonaControler;
import logic.InscripcionControler;


@WebServlet("/Actividades")
public class Actividades extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Actividades() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		switch (request.getParameter("action")) {
		case "agregar":
			this.agregar(request,response);
			request.getRequestDispatcher("/WEB-INF/gestionActividad.jsp").forward(request, response);	
			break;
		case "actualizar":
			request.getRequestDispatcher("/WEB-INF/gestionActividad.jsp").forward(request, response);	
			break;
		case "eliminar":
			this.eliminar(request,response);
			request.getRequestDispatcher("/WEB-INF/gestionActividad.jsp").forward(request, response);	
			break;
		case "gestionActividad":
			this.listar(request,response);
			request.getRequestDispatcher("/WEB-INF/gestionActividad.jsp").forward(request, response);	
			break;
		case "nuevaActividad":
			this.buscarPorId(request, response);
			request.getRequestDispatcher("/WEB-INF/nuevaActividad.jsp").forward(request, response);
			break;
		case "modificarActividad":
			this.buscarPorId(request,response);
			request.getRequestDispatcher("/WEB-INF/modificarActividad.jsp").forward(request, response);
			break;
		case "inscripcionActividad":
			this.listar(request,response);
			request.getRequestDispatcher("/WEB-INF/inscripcionActividad.jsp").forward(request, response);
			break;
		case "nuevaInscripcion":
			this.buscarPorId(request, response);
			request.getRequestDispatcher("/WEB-INF/nuevaInscripcion.jsp").forward(request, response);
			break;
		case "confirmarInscripcion":
			request.getRequestDispatcher("/WEB-INF/confirmarInscripcion.jsp").forward(request, response);
			break;
		case "inscribirse":
			try {
				this.inscribirse(request,response);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("/WEB-INF/inscripcionActividad.jsp").forward(request, response);
			break;
		case "homeUser":
			request.getRequestDispatcher("/WEB-INF/homeUser.jsp").forward(request, response);
			break;
		default:
			System.out.println("Error: opcion no disponible");
			break;
			
		}
	}
	
	private void agregar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		Actividad a = new Actividad();
		ActividadControler actCtrl = new ActividadControler();
		
		a.setNom_actividad(request.getParameter("nom_actividad"));
		a.setDesc_actividad(request.getParameter("desc_actividad"));
		a.setImporte_adicional(Double.parseDouble(request.getParameter("importe_adicional")));
		
		actCtrl.altaActividad(a);
		this.listar(request, response);
	}
	
	private void inscribirse (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ParseException{
		Inscripcion i = new Inscripcion();
		Actividad a = new Actividad();
		Persona p = new Persona();

		InscripcionControler resCtrl = new InscripcionControler();
		
		a = (Actividad) request.getSession().getAttribute("actividadModificar");
		p = (Persona) request.getSession().getAttribute("usuario");
		
		i.setAct(a);
		i.setPer(p);
		
		resCtrl.altaInscripcion(i);
		this.listar(request, response);
	} 
	
	
	private void buscarPorId(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		Actividad a = new Actividad();
		ActividadControler actCtrl = new ActividadControler();
		int idActividad = Integer.parseInt(request.getParameter("idActividad"));
		
		a = actCtrl.buscarActividadPorId(idActividad);
		request.getSession().setAttribute("actividadModificar", a);
	
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		ActividadControler actCtrl = new ActividadControler();
		ArrayList<Actividad> actividades = new ArrayList<Actividad>();
		
		actividades = actCtrl.getAll();
		request.getSession().setAttribute("listaActividades", actividades);
		
		//request.getRequestDispatcher("/WEB-INF/gestionActividad.jsp").forward(request, response);
	}
	
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		Actividad a = new Actividad();
	
		ActividadControler actCtrl = new ActividadControler();
		int idActividad = Integer.parseInt(request.getParameter("idActividad"));
		
		
		a.setNom_actividad(request.getParameter("nom_actividad"));
		a.setDesc_actividad(request.getParameter("desc_actividad"));
		System.out.println(request.getParameter("importe_adicional"));
		Double importe_adicional = Double.parseDouble(request.getParameter("importe_adicional"));
		a.setImporte_adicional(importe_adicional);
		
		actCtrl.modificarActividad(a, idActividad);
		this.listar(request, response);
		
		
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		int idActividad = Integer.parseInt(request.getParameter("idActividad"));
		ActividadControler actCtrl = new ActividadControler();
		
		actCtrl.bajaActividad(idActividad);
		this.listar(request, response);
		
		
	}

}


	


