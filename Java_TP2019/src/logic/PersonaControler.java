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
	
	public void buscarPersonaPorDni(int dni){
		//dp.getById(dni);
	}
	public void altaPersona(Persona p){
		dp.add(p);
	}
	public void bajaPersona(Persona p){
		//dp.deletePersona(p);
	}
	public void modificarPersona(Persona p){
		//dp.updatePersona(p);
	}
}
