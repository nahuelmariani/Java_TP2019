package servlets;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entities.*;
import logic.InstalacionControler;
import logic.PersonaControler;
import logic.ReservaControler;
import java.util.Date;

@WebServlet("/Instalaciones")
public class Instalaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Instalaciones() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		switch (request.getParameter("action")) {
		case "agregar":
			this.agregar(request,response);
			request.getRequestDispatcher("/WEB-INF/gestionInstalacion.jsp").forward(request, response);	
			break;
		/*case "listar":
			this.listar(request,response);
			break;*/
		case "actualizar":
			this.actualizar(request,response);
			request.getRequestDispatcher("/WEB-INF/gestionInstalacion.jsp").forward(request, response);	
			break;
		case "eliminar":
			this.eliminar(request,response);
			request.getRequestDispatcher("/WEB-INF/gestionInstalacion.jsp").forward(request, response);	
			break;
		case "gestionInstalacion":
			this.listar(request,response);
			request.getRequestDispatcher("/WEB-INF/gestionInstalacion.jsp").forward(request, response);	
			break;
		case "reservaInstalacion":
			this.listar(request,response);
			request.getRequestDispatcher("/WEB-INF/reservaInstalacion.jsp").forward(request, response);
			break;
		case "reservas":
			this.listarReservas(request,response);
			request.getRequestDispatcher("/WEB-INF/listadoReserva.jsp").forward(request, response);
			break;
		case "nuevaReserva":
			this.buscarPorId(request, response);
			request.getRequestDispatcher("/WEB-INF/nuevaReserva.jsp").forward(request, response);
			break;
		case "nuevaInstalacion":
			request.getRequestDispatcher("/WEB-INF/nuevaInstalacion.jsp").forward(request, response);
			break;
		case "confirmarReserva":
			
			request.getRequestDispatcher("/WEB-INF/confirmarReserva.jsp").forward(request, response);
			break;
		case "modificarInstalacion":
			this.buscarPorId(request,response);
			request.getRequestDispatcher("/WEB-INF/modificarInstalacion.jsp").forward(request, response);
			break;
		case "cancelarReserva":
			this.cancelarReserva(request,response);
			this.listarReservas(request,response);
			request.getRequestDispatcher("/WEB-INF/listadoReserva.jsp").forward(request, response);
		case "reservar":
			try {
				this.reservar(request,response);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("/WEB-INF/reservaInstalacion.jsp").forward(request, response);
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
		Instalacion i = new Instalacion();
		InstalacionControler instCtrl = new InstalacionControler();
		
		i.setNom_instalacion(request.getParameter("nom_instalacion"));
		i.setDesc_instalacion(request.getParameter("desc_instalacion"));
		i.setImporte(Double.parseDouble(request.getParameter("importe")));
		
		instCtrl.altaInstalacion(i);
		this.listar(request, response);
	}
	
	private void reservar (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ParseException{
		Reserva r = new Reserva();
		Instalacion i = new Instalacion();
		Persona p = new Persona();

		ReservaControler resCtrl = new ReservaControler();
		//InstalacionControler instCtrl = new InstalacionControler();
		//PersonaControler perCtrl = new PersonaControler();
		
		//String fecha_hora_desde = (request.getParameter("fecha_hora_desde"));
	//	Date fecha_hora_hasta = (request.getParameter("fecha_hora_hasta"));
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		
		//String fecha_hora_desdeStr = request.getParameter("fecha_hora_desde");
		Date fecha_hora_desde = sdf.parse(request.getParameter("fecha_hora_desde"));
		r.setFecha_hora_desde(fecha_hora_desde);
		
		//String fecha_hora_hastaStr = request.getParameter("fecha_hora_hasta");
		Date fecha_hora_hasta = sdf.parse(request.getParameter("fecha_hora_hasta"));
		r.setFecha_hora_hasta(fecha_hora_hasta);
		
		System.out.println("Fecha: " + fecha_hora_desde);
		
		/*
		int idInstalacion = Integer.parseInt(request.getParameter("idInstalacion"));
		i = instCtrl.buscarInstalacionPorId(idInstalacion);
		int idPersona = Integer.parseInt(request.getParameter("idPersona"));
		p = perCtrl.buscarPersonaPorId(idPersona);*/
		
		i = (Instalacion) request.getSession().getAttribute("instalacion");
		p = (Persona) request.getSession().getAttribute("usuario");
	
		//System.out.println("insta:" + i);
		//System.out.println("perso:" + p);
		
		r.setInst(i);
		r.setPer(p);
		

		
		/*
		Date fecha_hora_desde = Date(request.getParameter("fecha_hora_desde"));
		r.setFecha_hora_desde(fecha_hora_desde);
		Date fecha_hora_hasta = Date(request.getParameter("fecha_hora_hasta"));
		r.setFecha_hora_hasta(fecha_hora_hasta);
		System.out.println("Fecha: " + fecha_hora_desde);
		*/
		
//		i.setNom_instSalacion(request.getParameter("nom_instalacion"));
//		i.setDesc_instalacion(request.getParameter("desc_instalacion"));
//		Double importe = Double.parseDouble(request.getParameter("importe"));
//		i.setImporte(importe);
		
		resCtrl.altaReserva(r);
		this.listar(request, response);
	} 

	private void cancelarReserva(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
	
	
		int idReserva = Integer.parseInt(request.getParameter("idReserva"));
		ReservaControler resCtrl = new ReservaControler();
		
		resCtrl.cancelarRes(idReserva);

	
	}
	
	
	
	private void buscarPorId(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		Instalacion i = new Instalacion();
		InstalacionControler instCtrl = new InstalacionControler();
		int idInstalacion = Integer.parseInt(request.getParameter("idInstalacion"));
		
		i = instCtrl.buscarInstalacionPorId(idInstalacion);
		request.getSession().setAttribute("instalacion", i);
	
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		InstalacionControler instCtrl = new InstalacionControler();
		ArrayList<Instalacion> instalaciones = new ArrayList<Instalacion>();
		
		instalaciones = instCtrl.getAll();
		request.getSession().setAttribute("listaInstalaciones", instalaciones);
		

	}
	
	private void listarReservas(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		ReservaControler resCtrl = new ReservaControler();
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		Persona p = new Persona();
		p = (Persona) request.getSession().getAttribute("usuario");
		
		reservas = resCtrl.getAll(p.getId());
		request.getSession().setAttribute("listaReservas", reservas);
		

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

