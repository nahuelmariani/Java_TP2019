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

	public void cobrar(int mes, Persona soc) {
		// TODO Auto-generated method stub
		dc.actualizar(mes, soc);
	}
}
