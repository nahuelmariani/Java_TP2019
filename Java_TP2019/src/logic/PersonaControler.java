package logic;

import java.util.ArrayList;

import data.DataPersona;
import entities.*;

public class PersonaControler {
	//Declaro el DAO de persona
	DataPersona dp;
	
	//Constructor de la instancia
	public PersonaControler() {
		dp = new DataPersona();
	}
	
	//Metodo que le pide al DAO "getAll" 
	public ArrayList<Persona> getAll(){
		return dp.getAll();
	}
}
