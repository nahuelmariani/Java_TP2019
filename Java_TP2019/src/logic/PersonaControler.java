package logic;

import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt;

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
	
	public ArrayList<Persona> getSocios(){
		return dp.getSocios();
	}
	
	public Persona buscarPersonaPorId(int dni){
		return dp.getById(dni);
	}
	public Persona buscarPersonaPorDNI(Persona soc){
		return dp.getByDocumento(soc);
	}
	public void altaPersona(Persona p){
		dp.add(p);
	}
	public void bajaPersona(int idPersona){
		dp.delete(idPersona);
	}
	public void modificarPersona(Persona p, int idPersona){
		dp.update(p,idPersona);
	}
	
	public String hashPassword(String password_plaintext) {
		String hashed_password = BCrypt.hashpw(password_plaintext, BCrypt.gensalt());
		return(hashed_password);
	}
	
}
