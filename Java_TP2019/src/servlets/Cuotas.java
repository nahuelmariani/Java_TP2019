package servlets;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entities.*;
import logic.*;
import java.util.Date;

@WebServlet("/Cuotas")
public class Cuotas extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Cuotas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		switch (request.getParameter("action")) {
		case "agregar":
			this.agregar(request,response);
			request.getRequestDispatcher("/WEB-INF/gestionCuota.jsp").forward(request, response);	
			break;
		case "nuevaCuota":
			request.getRequestDispatcher("/WEB-INF/generarCuota.jsp").forward(request, response);	
			break;
		case "gestionCuota":
			request.getRequestDispatcher("/WEB-INF/gestionCuota.jsp").forward(request, response);	
			break;
		case "homeUser":
			request.getRequestDispatcher("/WEB-INF/homeUser.jsp").forward(request, response);	
			break;
		case "gestionCobro":
		//	this.listarSocios(request,response);
			request.getRequestDispatcher("/WEB-INF/gestionCobro.jsp").forward(request, response);	
			break;
		case "nuevoCobro":
			this.confirmarCobro(request,response);
			request.getRequestDispatcher("/WEB-INF/confirmarCobro.jsp").forward(request, response);
		case "registrarCobro":
			this.registrarCobro(request, response);
			request.getRequestDispatcher("/WEB-INF/homeUser.jsp").forward(request, response);
			break;
		
		default:
			System.out.println("Error: opcion no disponible");
			break;
		}
	}
	
	
	

	private void confirmarCobro(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		PersonaControler perCtrl = new PersonaControler();
		Persona soc = new Persona();
		Documento doc = new Documento();
		Cuota cuota = new Cuota();
		
		// recupero tipo y nro de doc y obtengo el socio. Lo seteo en la sesion
		doc.setNro(request.getParameter("dni"));
		doc.setTipo(request.getParameter("tipoDNI"));
		
		soc.setDocumento(doc);
		soc = perCtrl.buscarPersonaPorDNI(soc);
		request.getSession().setAttribute("Soc", soc);
		
		// recupero el mes ingresado, lo seteo en cuota y lo guardo en la sesion
		int mes = Integer.parseInt(request.getParameter("mes"));
		cuota.setMes(mes);
		request.getSession().setAttribute("Cuota", cuota);
		
	}

	private void registrarCobro(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		CuotaControler cuotaCtrl = new CuotaControler();
	
		// recupero cuota de la sesion para saber el mes
		Cuota cuota = (Cuota) request.getSession().getAttribute("Cuota");
		int mes = cuota.getMes();
		
		// recupero socio de la sesion para actualizar su cuota
		Persona soc = (Persona) request.getSession().getAttribute("Soc");
		cuotaCtrl.cobrar(mes, soc);
	}

	

	private void listarSocios(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		PersonaControler perCtrl = new PersonaControler();
		ArrayList<Persona> socios = new ArrayList<Persona>();
	
		socios = perCtrl.getSocios();
		request.getSession().setAttribute("listaSocios", socios);		
		
	}
	private void agregar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		Cuota c = new Cuota();
		CuotaControler cuotaCtrl = new CuotaControler();
		PersonaControler perCtrl = new PersonaControler();
		ArrayList<Persona> usuarios = new ArrayList<>();
		
		usuarios = perCtrl.getSocios();
		Calendar c1 = Calendar.getInstance();
		System.out.println(c1.get(Calendar.YEAR));
		int anio = c1.get(Calendar.YEAR);
		for (Persona per: usuarios) {
			for(int i = 1; i < 13; i++) {
				c.setMes(i);
				c.setP(per);
				c.setAnio(anio);
				c.setImporte(Double.parseDouble(request.getParameter("importe")));
				cuotaCtrl.agregar(c);
			}
		}
		
		
		
	}
}