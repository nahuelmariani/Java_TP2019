package logic;

import data.DataReserva;
import entities.*;

public class ReservaControler {
	DataReserva dr;
	
	//Constructor de la instancia
	public ReservaControler() {
		dr = new DataReserva();

	}
	
	public void altaReserva(Reserva r){
		dr.add(r);
	}
}
