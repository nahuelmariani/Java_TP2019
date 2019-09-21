package logic;

import java.util.ArrayList;

import data.DataInstalacion;
//import data.Instalacion;
import entities.*;

public class InstalacionControler {
	//Declaro el DAO de instalacion
		DataInstalacion di;
		
		//Constructor de la instancia
		public InstalacionControler() {
			di = new DataInstalacion();
		}
		
		//Metodo que le pide al DAO "getAll" 
		public ArrayList<Instalacion> getAll(){
			return di.getAll();
		}
		
		public Instalacion buscarInstalacionPorId(int id){
			return di.getById(id);
		}
		public void altaInstalacion(Instalacion i){
			di.add(i);
		}
		public void bajaInstalacion(int idInstalacion){
			di.delete(idInstalacion);
		}
		public void modificarInstalacion(Instalacion i, int idInstalacion){
			di.update(i,idInstalacion);
		}
	}

