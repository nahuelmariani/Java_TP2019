package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Actividad;
import logic.ActividadControler;

/**
 * Servlet implementation class Actividades
 */
@WebServlet("/Actividades")
public class Actividades extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Actividades() {
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
		ActividadControler actCtrl = new ActividadControler();
		ArrayList<Actividad> actividades = new ArrayList<Actividad>();
		actividades = actCtrl.getAll();
		request.getSession().setAttribute("listaActividades", actividades);
		
		switch (request.getParameter("action")) {
		case "agregar":
			this.agregar(request,response);
			break;
		case "listar":
			this.listar(request,response);
			break;
		case "actualizar":
			this.actualizar(request,response);
			break;
		case "eliminar":
			this.eliminar(request,response);
			break;
		case "gestionActividad":
			request.getRequestDispatcher("/WEB-INF/gestionActividad.jsp").forward(request, response);
			break;
		case "nuevaActividad":
			request.getRequestDispatcher("/WEB-INF/nuevaActividad.jsp").forward(request, response);
			break;
		case "modificarActividad":
			this.buscarPorId(request,response);
			request.getRequestDispatcher("/WEB-INF/modificarActividad.jsp").forward(request, response);
			break;
		case "homeUser":
			request.getRequestDispatcher("/WEB-INF/home_user.jsp").forward(request, response);
			break;
		default:
			System.out.println("redirigir a página de error");
			break;
		}
	}
	
	private void agregar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		Actividad a = new Actividad();

		ActividadControler actCtrl = new ActividadControler();
		
		a.setNom_actividad(request.getParameter("nom_actividad"));
		a.setDesc_actividad(request.getParameter("desc_actividad"));
		Double importe_adicional = Double.parseDouble(request.getParameter("importe_adicional"));
		a.setImporte_adicional(importe_adicional);
		
		actCtrl.altaActividad(a);
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
		request.getRequestDispatcher("/WEB-INF/gestionActividad.jsp").forward(request, response);
		//response.sendRedirect(request.getContextPath()+"/WEB-INF/gestionUsuario.jsp");
	
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


	


