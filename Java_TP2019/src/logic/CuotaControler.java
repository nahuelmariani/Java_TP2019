package logic;

import java.util.ArrayList;

import data.*;
import entities.*;

public class CuotaControler {
	DataCuota dc = new DataCuota();
	DataValoresCuota dvc = new DataValoresCuota();

	public void agregarCuota(Cuota c) {
		dc.add(c);
	}

	public int cobrar(Cuota cuota, Persona soc) {
		// TODO Auto-generated method stub
		Cuota cuo = new Cuota();
		int existe;
		cuo = dc.buscarCuota(cuota, soc);
		if (cuo != null) {
			existe = 1;
		}
		else {
		dc.actualizar(cuota, soc);
		existe = 0;
		}
		return existe;
	}
	
	public ArrayList<Valores_Cuota> getAll(){
		return dvc.getAll();
	}
	
	
	public void agregarValorCuota(Valores_Cuota vc) {
		dvc.add(vc);
	}
	
	
	
	public Double valorCuota() {
		return dvc.getUltValor();
	}
}
