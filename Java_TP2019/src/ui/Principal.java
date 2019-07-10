package ui;

import data.*;
import entities.*;

public class Principal {

	public static void main(String[] args) {
		System.out.println("Mostrar todo: ");
		DataUsuario du = new DataUsuario();
		for(Usuario u: du.getAll()) {
			System.out.println(u);
		}
	}

}
