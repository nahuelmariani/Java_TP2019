package logic;

import java.util.ArrayList;
import java.util.HashMap;

import data.DataActividad;
//import data.Actividad;
import entities.*;


public class ActividadControler {
	DataActividad da;
	
	public ActividadControler() {
		da = new DataActividad();
	}
	
	//Metodo que le pide al DAO "getAll" 
	public ArrayList<Actividad> getAll(){
		return da.getAll();
	}
	
	public HashMap<Integer, Integer> getInscriptos(){
		return da.getInscriptos();
	}
	

	
	public boolean validarCupo(Actividad a) {
		HashMap<Integer,Integer> inscriptos = new HashMap<Integer,Integer>();
		inscriptos = da.getInscriptos();
		if (inscriptos.get(a.getId_actividad()) < a.getCupo()) {
			return true;
		} else  {
			return false;
		}
	}

	
	public Actividad buscarActividadPorId(int id){
		return da.getById(id);
	}
	public void altaActividad(Actividad a){
		da.add(a);
	}
	public void bajaActividad(int idActividad){
		da.delete(idActividad);
	}
	public void modificarActividad(Actividad a, int idActividad){
		da.update(a,idActividad);
	}
}

