package mx.uacm.reclutaSoft.domain;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Evento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String tipoEvento;
	private String nombreEvento;
	private String descripcion;
	private String plantel;
	private String descripcionUbicacion;
	private Date fechaInicio;
	private Date fechaFin;
	
	//@JsonIgnore
	//@JsonBackReference
	@JsonManagedReference
	@OneToMany(mappedBy="evento", cascade=CascadeType.ALL, 
			   orphanRemoval=true, fetch=FetchType.LAZY)
	private List<Taller> talleres = new ArrayList<Taller>();
	
	
//	@OneToOne(mappedBy = "tipoEvento", cascade = CascadeType.ALL, 
//	  fetch = FetchType.LAZY, optional = false)
//private TipoEvento tipoEvento;


//@OneToOne(mappedBy = "ubicacion", cascade = CascadeType.ALL, 
//	  fetch = FetchType.LAZY, optional = false)
//private Ubicacion ubicacion;
	//@JsonIgnore
	public List<Taller> getTalleres() {
		return talleres;
	}
	
	//@JsonIgnore
	public void setTalleres(List<Taller> talleres2) {
		this.talleres = talleres2;
		for (Taller taller : talleres2) {
			taller.setEvento(this);
		}
	}
	
	public void setTaller(Taller taller) {
		talleres.add(taller);
		taller.setEvento(this);
	}
	
	public void removeTaller(Taller taller) {
		talleres.remove(taller);
		taller.setEvento(null);
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombreEvento() {
		return nombreEvento;
	}
	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public String getPlantel() {
		return plantel;
	}
	public void setPlantel(String plantel) {
		this.plantel = plantel;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getDescripcionUbicacion() {
		return descripcionUbicacion;
	}

	public void setDescripcionUbicacion(String descripcionUbicacion) {
		this.descripcionUbicacion = descripcionUbicacion;
	}
	
	
}
