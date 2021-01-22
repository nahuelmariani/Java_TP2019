package logic;
import java.util.ArrayList;
import java.util.HashMap;

import data.DataInscripcion;
import entities.*;

public class InscripcionControler {
	DataInscripcion di;
	
	
	public InscripcionControler() {
		di = new DataInscripcion();

	}
	
	/*public void altaInscripcion(Inscripcion i){
		di.add(i);
	}*/
	
	public void altaPreInscripcion(Inscripcion i){
		di.add(i);
	}
	
	public void confirmaInscripcion(Inscripcion i){
		di.update(i);
	}
	
	public void bajaPreInscripcion(Inscripcion i){
		di.delete(i);
	}

	public boolean validarExistencia(Persona p, Actividad a) {
		return di.validarExistencia(p,a);
	}
	
	/*public boolean validarCupo2(Actividad a) {
		HashMap<Integer,Integer> inscriptos = new HashMap<Integer,Integer>();
		inscriptos = da.getInscriptos();
		if (inscriptos.get(a.getId_actividad()) < a.getCupo()) {
			return true;
		} else  {
			return false;
		}
	}*/
	
	public ArrayList<Persona> verInscriptos (Actividad a) {
		return di.verInscriptos(a);
		
	}
	
	public ArrayList<Actividad> getAll(int id){
		return di.getAll(id);
	}
	
	public double calcularImporte(int id)  {
		ArrayList<Actividad> actividades = new ArrayList<>();
		actividades = di.getAll(id);
		Double sum = 0.0;
		for (Actividad act: actividades) {
			sum = sum + act.getImporte_adicional();		
		}
		return sum;
	}
}
