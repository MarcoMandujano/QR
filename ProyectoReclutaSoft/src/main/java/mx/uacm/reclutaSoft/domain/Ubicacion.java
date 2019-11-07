package mx.uacm.reclutaSoft.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Ubicacion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String plantel;
	private String salon;
	private String descripcion;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Taller taller;
	
	public String getPlantel() {
		return plantel;
	}
	public void setPlantel(String plantel) {
		this.plantel = plantel;
	}
	public String getSalon() {
		return salon;
	}
	public void setSalon(String salon) {
		this.salon = salon;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
