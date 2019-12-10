package logic;

import java.util.ArrayList;

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
	
	public ArrayList<Reserva> getAll(int id){
		return dr.getAll(id);
	}
	public void cancelarRes(int idReserva){
		dr.cancelar(idReserva);
	}
	
}
