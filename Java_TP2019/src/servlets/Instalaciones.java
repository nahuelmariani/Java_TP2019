package servlets;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entities.*;
import logic.InstalacionControler;
import logic.ReservaControler;
import java.util.Date;

/**
 * Servlet implementation class Instalaciones
 */
@WebServlet("/Instalaciones")
public class Instalaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Instalaciones() {
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
		InstalacionControler instCtrl = new InstalacionControler();
		ArrayList<Instalacion> instalaciones = new ArrayList<Instalacion>();
		instalaciones = instCtrl.getAll();
		Instalacion inst = new Instalacion();
		request.getSession().setAttribute("listaInstalaciones", instalaciones);
		
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
		case "gestionInstalacion":
			request.getRequestDispatcher("/WEB-INF/gestionInstalacion.jsp").forward(request, response);
			break;
		case "reservaInstalacion":
			request.getRequestDispatcher("/WEB-INF/reservaInstalacion.jsp").forward(request, response);
			break;
		case "reservar_instalacion":
			this.buscarPorId(request, response);
			request.getRequestDispatcher("/WEB-INF/reservar_instalacion.jsp").forward(request, response);
			break;
		case "nuevaInstalacion":
			request.getRequestDispatcher("/WEB-INF/nuevaInstalacion.jsp").forward(request, response);
			break;
		case "modificar_instalacion":
			this.buscarPorId(request,response);
			request.getRequestDispatcher("/WEB-INF/modificar_instalacion.jsp").forward(request, response);
			break;
		case "reservar":
			this.reservar(request,response);
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
		Instalacion i = new Instalacion();

		InstalacionControler instCtrl = new InstalacionControler();
		
		i.setNom_instalacion(request.getParameter("nom_instalacion"));
		i.setDesc_instalacion(request.getParameter("desc_instalacion"));
		Double importe = Double.parseDouble(request.getParameter("importe"));
		i.setImporte(importe);
		
		instCtrl.altaInstalacion(i);
		this.listar(request, response);
	}
	
	private void reservar (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		Reserva r = new Reserva();

		ReservaControler resCtrl = new ReservaControler();
		
		//String fecha_hora_desde = (request.getParameter("fecha_hora_desde"));
	//	Date fecha_hora_hasta = (request.getParameter("fecha_hora_hasta"));
		Date fecha_hora_desde = Date(request.getParameter("fecha_hora_desde"));
		r.setFecha_hora_desde(fecha_hora_desde);
		Date fecha_hora_hasta = Date(request.getParameter("fecha_hora_hasta"));
		r.setFecha_hora_hasta(fecha_hora_hasta);
	
		
//		i.setNom_instSalacion(request.getParameter("nom_instalacion"));
//		i.setDesc_instalacion(request.getParameter("desc_instalacion"));
//		Double importe = Double.parseDouble(request.getParameter("importe"));
//		i.setImporte(importe);
		
		resCtrl.altaReserva(r);
		this.listar(request, response);
	} 
	private Date Date(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}

	private void buscarPorId(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		Instalacion i = new Instalacion();
		InstalacionControler instCtrl = new InstalacionControler();
		int idInstalacion = Integer.parseInt(request.getParameter("idInstalacion"));
		
		i = instCtrl.buscarInstalacionPorId(idInstalacion);
		request.getSession().setAttribute("reservarInstalacion", i);
	
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		InstalacionControler instCtrl = new InstalacionControler();
		ArrayList<Instalacion> instalaciones = new ArrayList<Instalacion>();
		instalaciones = instCtrl.getAll();
		request.getSession().setAttribute("listaInstalaciones", instalaciones);
		request.getRequestDispatcher("/WEB-INF/gestionInstalacion.jsp").forward(request, response);
		//response.sendRedirect(request.getContextPath()+"/WEB-INF/gestionUsuario.jsp");
	
	}
	
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		Instalacion i = new Instalacion();
	
		InstalacionControler instCtrl = new InstalacionControler();
		int idInstalacion = Integer.parseInt(request.getParameter("idInstalacion"));
		
		
		i.setNom_instalacion(request.getParameter("nom_instalacion"));
		i.setDesc_instalacion(request.getParameter("desc_instalacion"));
		Double importe = Double.parseDouble(request.getParameter("importe"));
		i.setImporte(importe);
		
		instCtrl.modificarInstalacion(i, idInstalacion);
		this.listar(request, response);
		
		
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		int idInstalacion = Integer.parseInt(request.getParameter("idInstalacion"));
		InstalacionControler instCtrl = new InstalacionControler();
		
		instCtrl.bajaInstalacion(idInstalacion);
		this.listar(request, response);
		
		
	}

}

