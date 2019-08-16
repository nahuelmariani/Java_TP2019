package logic;

import data.DataRol;
import entities.*;

public class RolControler {
	//Declaro el DAO de rol
	DataRol dr;
	
	//Constructor de la instancia
	public RolControler() {
		dr = new DataRol();
	}
	
	//Metodo que le pide al DAO "getRol" 
	public Rol getRol(Persona p) {
		return dr.getRol(p);
	}
}
