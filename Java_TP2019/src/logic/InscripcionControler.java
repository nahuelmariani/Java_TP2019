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
	

}
