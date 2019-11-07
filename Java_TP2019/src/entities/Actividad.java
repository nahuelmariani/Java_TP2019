package entities;

public class Actividad {
	private int id_actividad;
	private String nom_actividad;
	private String desc_actividad;
	private int cupo;
	private Double importe_adicional;
	
	
	public int getId_actividad() {
		return id_actividad;
	}
	public void setId_actividad(int id_actividad) {
		this.id_actividad = id_actividad;
	}
	public String getNom_actividad() {
		return nom_actividad;
	}
	public void setNom_actividad(String nom_actividad) {
		this.nom_actividad = nom_actividad;
	}
	public String getDesc_actividad() {
		return desc_actividad;
	}
	public void setDesc_actividad(String desc_actividad) {
		this.desc_actividad = desc_actividad;
	}
	public int getCupo() {
		return cupo;
	}
	public void setCupo(int cupo) {
		this.cupo = cupo;
	}
	public Double getImporte_adicional() {
		return importe_adicional;
	}
	public void setImporte_adicional(Double importe_adicional) {
		this.importe_adicional = importe_adicional;
	}
	
	

}
