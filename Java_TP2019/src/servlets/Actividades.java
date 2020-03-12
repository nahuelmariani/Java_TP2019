package servlets;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Actividad;
import entities.Persona;
import entities.Reserva;
import entities.Inscripcion;
import entities.Instalacion;
import logic.ActividadControler;
import logic.PersonaControler;
import logic.ReservaControler;
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
			this.actualizar(request,response);
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
		/*case "nuevaInscripcion": //se usa?
			this.buscarPorId(request, response);
			request.getRequestDispatcher("/WEB-INF/nuevaInscripcion.jsp").forward(request, response);
			break;
		case "confirmarInscripcion": //NO SE USAAA
			request.getRequestDispatcher("/WEB-INF/confirmarInscripcion.jsp").forward(request, response);
			break;
		case "inscribirse": //se usa?
			this.inscribirse(request,response);
			request.getRequestDispatcher("/WEB-INF/inscripcionActividad.jsp").forward(request, response);
			break;*/
		case "inscripcionActividad": //Botón ACTIVIDADES de homeUser.jsp
			this.listar(request,response);
			request.getRequestDispatcher("/WEB-INF/inscripcionActividad.jsp").forward(request, response);
			break;
		case "preInscribir": //Botón INSCRIBIRSE de inscripcionActividad.jsp
			//es aca. Si [cantinsc(act) < cupo(act)] preinscribir, si no, mensaje y refrescar inscrip activ.
			// if (validaCupo(actividad))
			this.preInscribir(request,response);
			//request.getRequestDispatcher("/WEB-INF/nuevaInscripcion.jsp").forward(request, response);
			break;
		case "inscribir": //Botón INSCRIBIRSE de nuevaInscripcion.jsp
			//aca debería hacer un if con la validacion, mm no
			this.inscribir(request,response);
			request.getRequestDispatcher("/WEB-INF/inscripcionActividad.jsp").forward(request, response);
			break;
		case "borrarPreInscripcion": //Botón CANCELAR de nuevaInscripcion.jsp
			this.borrarPreInscripcion(request, response);
			request.getRequestDispatcher("/WEB-INF/inscripcionActividad.jsp").forward(request, response);
			break;
		case "homeUser": //Botón VOLVER de homeUser.jsp
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
		a.setCupo(Integer.parseInt(request.getParameter("cupo")));
		
		actCtrl.altaActividad(a);
		this.listar(request, response);
	}
	
	//NO SE USA MAS
	/*private void inscribirse (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
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
	} */
	
	
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
		HashMap<Integer,Integer> inscriptos = new HashMap<Integer,Integer>();
		
		actividades = actCtrl.getAll();
		inscriptos = actCtrl.getInscriptos();
		request.getSession().setAttribute("listaActividades", actividades);
		request.getSession().setAttribute("inscriptos", inscriptos);
		
		//request.getRequestDispatcher("/WEB-INF/gestionActividad.jsp").forward(request, response);
	}
	
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		Actividad a = new Actividad();
	
		ActividadControler actCtrl = new ActividadControler();
		int idActividad = Integer.parseInt(request.getParameter("idActividad"));
		
		
		a.setNom_actividad(request.getParameter("nom_actividad"));
		a.setDesc_actividad(request.getParameter("desc_actividad"));
		a.setCupo(Integer.parseInt(request.getParameter("cupo")));
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
	
	
	private void preInscribir (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		// Busca la actividad por ID a la que se quiere preinscribir
		Actividad a = new Actividad();
		ActividadControler actCtrl = new ActividadControler();
		
		int idActividad = Integer.parseInt(request.getParameter("idActividad"));
		a = actCtrl.buscarActividadPorId(idActividad);
		
		//validar aca?
		if (actCtrl.validarCupo(a)) {
			Persona p = new Persona();
			InscripcionControler inscCtrl = new InscripcionControler();
			p = (Persona) request.getSession().getAttribute("usuario");
			if (!inscCtrl.validarExistencia(p,a)) {
				Inscripcion i = new Inscripcion();
				
				i.setAct(a);
				i.setPer(p);
				i.setConfirmada(false);
				
				System.out.println("preinscripcion realizada");
				
				request.getSession().setAttribute("actividad", a); //no sería necesario, saco la info de inscripcion
				request.getSession().setAttribute("inscripcion", i);

				inscCtrl.altaPreInscripcion(i);
				this.listar(request, response);
				request.getRequestDispatcher("/WEB-INF/nuevaInscripcion.jsp").forward(request, response);
			} else {
				request.getSession().setAttribute("message", "Ya estás inscripto a esta actividad");
				this.listar(request, response);
				request.getRequestDispatcher("/WEB-INF/inscripcionActividad.jsp").forward(request, response);
			}
			
			//actCtrl.validarCupo(a);

		} else {
			request.getSession().setAttribute("message", "No hay más cupos para esta actividad");
			this.listar(request, response);
			request.getRequestDispatcher("/WEB-INF/inscripcionActividad.jsp").forward(request, response);
		}
		
		
		

		
	}
	
	private void inscribir (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		Inscripcion i = new Inscripcion();
		InscripcionControler inscCtrl = new InscripcionControler();
		
		i = (Inscripcion) request.getSession().getAttribute("inscripcion");
		i.setConfirmada(true);
		
		inscCtrl.confirmaInscripcion(i);
		this.listar(request, response);
		
	}
	
	private void borrarPreInscripcion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		Inscripcion i = new Inscripcion();
		InscripcionControler inscCtrl = new InscripcionControler();
		i = (Inscripcion) request.getSession().getAttribute("inscripcion");
			
		inscCtrl.bajaPreInscripcion(i);
		this.listar(request, response);
		
	}
	
	
	

}


	


