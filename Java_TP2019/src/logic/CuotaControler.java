package logic;

import java.util.ArrayList;

import data.*;
import entities.*;

public class CuotaControler {
	DataCuota dc = new DataCuota();

	public void agregar(Cuota c) {
		// TODO Auto-generated method stub
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
}
