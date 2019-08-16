package logic;

import data.*;
import entities.*;

public class Login {
	//Declaro el DAO de persona
	private DataPersona dp;
	
	//Constructor de la instancia
	public Login() {
		dp = new DataPersona();
	}
	
	//Metodo que le pide al DAO "getByUser"
	public Persona validate(Persona p) {
		return dp.getByUser(p);
	}
}
