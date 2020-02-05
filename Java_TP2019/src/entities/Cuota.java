package entities;

public class Cuota {
		private int id_cuota;
		private int mes;
		private int anio;
		private Double importe;
		private String estado;
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Persona getP() {
		return p;
	}
	public void setP(Persona p) {
		this.p = p;
	}
		
}
