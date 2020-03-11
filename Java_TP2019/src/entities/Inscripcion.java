package entities;
import java.util.*;

public class Inscripcion {
	private int id_inscripcion; //no tiene
	private Date fecha_inscripcion;
	private Actividad act;
	private Persona per;
	private Boolean confirmada;
	
	public Boolean getConfirmada() {
		return confirmada;
	}

	public void setConfirmada(Boolean confirmada) {
		this.confirmada = confirmada;
	}

	public int getId_inscripcion() {
		return id_inscripcion;
	}
	
	public void setId_inscripcion(int id_inscripcion) {
		this.id_inscripcion = id_inscripcion;
	}
	public Date getFecha_inscripcion() {
		return fecha_inscripcion;
	}
	public void setFecha_inscripcion(Date fecha_inscripcion) {
		this.fecha_inscripcion = fecha_inscripcion;
	}
	public Actividad getAct() {
		return act;
	}
	public void setAct(Actividad act) {
		this.act = act;
	}
	public Persona getPer() {
		return per;
	}
	public void setPer(Persona per) {
		this.per = per;
	}
		
	

}
