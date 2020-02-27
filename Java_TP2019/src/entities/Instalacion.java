package entities;

public class Instalacion {
	private int id_instalacion;
	private String nom_instalacion;
	private String desc_instalacion;
	private Double importe;
	private String imagen;
	
	public int getId_instalacion() {
		return id_instalacion;
	}
	public void setId_instalacion(int id_instalacion) {
		this.id_instalacion = id_instalacion;
	}
	public String getNom_instalacion() {
		return nom_instalacion;
	}
	public void setNom_instalacion(String nom_instalacion) {
		this.nom_instalacion = nom_instalacion;
	}
	public String getDesc_instalacion() {
		return desc_instalacion;
	}
	public void setDesc_instalacion(String desc_instalacion) {
		this.desc_instalacion = desc_instalacion;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
 
}
