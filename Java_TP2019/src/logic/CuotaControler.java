package logic;

import java.util.ArrayList;
import java.util.HashMap;

import data.*;
import entities.*;

public class CuotaControler {
	DataCuota dc = new DataCuota();
	DataValoresCuota dvc = new DataValoresCuota();

	public void agregarCuota(Cuota c) {
		dc.add(c);
	}

	/*public int cobrar(Cuota cuota, Persona soc) {
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
	}*/
	
	public void cobrar(Cuota cuota, Persona soc) {
		dc.actualizar(cuota, soc);
	}
	
	public Cuota buscarCuota(Cuota cuota, Persona socio) {
		System.out.println(cuota.getAnio() +"."+ cuota.getMes() +"."+ socio.getId());
		return dc.buscarCuota(cuota, socio);
	}
	
	public ArrayList<Valores_Cuota> getAll(){
		return dvc.getAll();
	}
	
	
	public void agregarValorCuota(Valores_Cuota vc) {
		dvc.add(vc);
	}
	
	public ArrayList<Cuota> getByAnio(int anio){
		return dc.getByAnio(anio);
	}
	
	public ArrayList<Cuota> getByAnioPer(int anio, Persona per){
		return dc.getByAnioPer(anio, per);
	}
	
	public Double valorCuota() {
		return dvc.getUltValor();
	}
	
	public int  validarCuota(Persona p) {
		ArrayList<Cuota> cuotas = new ArrayList<Cuota>();
		int debe;
		
		cuotas = dc.validarCuota(p);
		if (cuotas.isEmpty()) {
			debe = 1;
			
		}
		else {
			debe = 0;
		}
		System.out.println(debe);
		return debe;
	}

	public ArrayList<String> obtenerCuotas(ArrayList<Cuota> cuotas, Persona p) {
		ArrayList<String> cuos = new ArrayList<String>();
		cuos.add(p.getDocumento().getTipo());
		cuos.add(p.getDocumento().getNro());
		cuos.add(p.getNombre());
		cuos.add(p.getApellido());
		for (int i = 1; i < 13; i++) {
			cuos.add("0"); //no generadas
		}
		
		if (!cuotas.isEmpty()) {
			for (Cuota c : cuotas) {
				if (c.getFecha_pago()==null) {
					cuos.add(c.getMes()+3, "1");
				} else {
					cuos.add(c.getMes()+3, "2");
				}
			}
		}
		return cuos;
	}
	
}
