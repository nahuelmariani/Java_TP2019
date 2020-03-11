package logic;
import data.DataInscripcion;
import entities.*;

public class InscripcionControler {
	DataInscripcion di;
	
	public InscripcionControler() {
		di = new DataInscripcion();

	}
	
	public void altaInscripcion(Inscripcion i){
		di.add(i);
	}
	
	public void altaPreInscripcion(Inscripcion i){
		di.add(i);
	}
	
	public void confirmaInscripcion(Inscripcion i){
		di.update(i);
	}
	
	public void bajaPreInscripcion(Inscripcion i){
		di.delete(i);
	}
	
	
	

}
