package logic;

import org.mindrot.jbcrypt.BCrypt;

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
	
	public Persona getUser(Persona p) {
		return dp.getByUser2(p);
	}
	
	public boolean checkPassword(Persona p) {
		String password_plaintext = p.getPassword();
		String stored_hash = dp.getPassword(p).getPassword();
		return BCrypt.checkpw(password_plaintext, stored_hash);
	}
	
	public String hashPassword(String password_plaintext) {
		String hashed_password = BCrypt.hashpw(password_plaintext, BCrypt.gensalt());
		return(hashed_password);
	}
	
}
