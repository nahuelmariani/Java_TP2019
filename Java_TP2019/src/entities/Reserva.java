package entities;
import java.util.*;

public class Reserva {
	private int id_reserva;
	private Date fecha_reserva;
	private Date fecha_hora_desde;
	private Date fecha_hora_hasta;
	private Date fecha_cancelacion;
	private Instalacion inst;
	private Persona per;

	
	public double getDuracion() {
		return (double) (this.fecha_hora_hasta.getTime() - this.fecha_hora_desde.getTime())/1000/60/60;
	}
	public int getId_reserva() {
		return id_reserva;
	}
	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}
	public Date getFecha_reserva() {
		return fecha_reserva;
	}
	public void setFecha_reserva(Date fecha_reserva) {
		this.fecha_reserva = fecha_reserva;
	}
	public Date getFecha_hora_desde() {
		return fecha_hora_desde;
	}
	public void setFecha_hora_desde(Date fecha_hora_desde) {
		this.fecha_hora_desde = fecha_hora_desde;
	}
	public Date getFecha_hora_hasta() {
		return fecha_hora_hasta;
	}
	public void setFecha_hora_hasta(Date fecha_hora_hasta) {
		this.fecha_hora_hasta = fecha_hora_hasta;
	}
	public Date getFecha_cancelacion() {
		return fecha_cancelacion;
	}
	public void setFecha_cancelacion(Date fecha_cancelacion) {
		this.fecha_cancelacion = fecha_cancelacion;
	}
	public Instalacion getInst() {
		return inst;
	}
	public void setInst(Instalacion inst) {
		this.inst = inst;
	}
	public Persona getPer() {
		return per;
	}
	public void setPer(Persona per) {
		this.per = per;
	}
	
	
	
	

}
