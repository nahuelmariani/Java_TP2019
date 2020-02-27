package entities;
import java.util.*;

public class Cuota {
		private int id_cuota;
		private int mes;
		private int anio;
		private Double importe;
		private Date fecha_pago;
		private Persona p;
	
		public int getId_cuota() {
		return id_cuota;
	}
	public void setId_cuota(int id_cuota) {
		this.id_cuota = id_cuota;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	
	
	public Persona getP() {
		return p;
	}
	public void setP(Persona p) {
		this.p = p;
	}
	public Date getFecha_pago() {
		return fecha_pago;
	}
	public void setFecha_pago(Date fecha_pago) {
		this.fecha_pago = fecha_pago;
	}
		
}
