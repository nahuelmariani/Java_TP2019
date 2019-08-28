package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Persona;
import entities.Rol;
import logic.Login;
import logic.PersonaControler;
import logic.RolControler;

/**
 * Servlet implementation class Signin
 */
@WebServlet({ "/Signin", "/signin", "/signIn", "/SignIn", "/SIGNIN" })
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin() {
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
		Login ctrl = new Login(); //Logic: controlador que envia mensajes al DAO//
		PersonaControler perCtrl = new PersonaControler(); //Logic: controlador que envia mensajes al DAO
		RolControler rolCtrl = new RolControler();
		
		String email = request.getParameter("email"); //Recibo "email" desde el form de login//
        String password = request.getParameter("password"); //Recibo "password" desde el form de login//
        System.out.println(email+"|"+password); //Impresion por consola de prueba//
        
        //Creo un objeto p Persona con esos datos recibidos para pasarlo al validate(p)
        Persona p = new Persona();//
        Rol r = new Rol();
        p.setEmail(email);//
        p.setPassword(password); //
        p = ctrl.validate(p); //Realiza un getByUser al DAO de persona//
        r = rolCtrl.getRol(p);
        request.getSession().setAttribute("usuario", p);
        request.getSession().setAttribute("rol", r);
        System.out.println(p);
        System.out.println(r);
        request.getRequestDispatcher("WEB-INF/home_user.jsp").forward(request, response);
        /*
        if (r.getDescripcion().equals("admin")) {
        	System.out.println("Administrador");
        	//request.getSession().setAttribute("listaPersonas", perCtrl.getAll());
        	request.getRequestDispatcher("WEB-INF/home_admin.jsp").forward(request, response);
		}
        if (r.getDescripcion().equals("empleado")) {
        	System.out.println("Empleado del club");
        	request.getRequestDispatcher("WEB-INF/home_empleado.jsp").forward(request, response);
		}
        if (r.getDescripcion().equals("socio")) {
        	System.out.println("Socio del club");
        	request.getRequestDispatcher("WEB-INF/home_socio.jsp").forward(request, response);
		}
		*/
	}
}
