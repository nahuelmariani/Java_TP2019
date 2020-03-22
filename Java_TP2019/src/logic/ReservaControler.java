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
	
	public void confirmarReserva(Reserva r){
		dr.update(r);
		//validar
		//confirmar
	}
	
	public void altaPreReserva(Reserva r){
		dr.add(r);
		
	}
	
	public ArrayList<Reserva> getAll(int id){
		return dr.getAll(id);
	}
	public void cancelarRes(int idReserva){
		dr.cancelar(idReserva);
	}
	
	public boolean validarDisp(Reserva r) {
		
		return dr.validarDisp(r);
	
	}

	public void bajaPreReserva(Reserva r) {
		// TODO Auto-generated method stub
		dr.delete(r);
	}
}
