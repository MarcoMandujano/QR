package mx.uacm.reclutaSoft.domain;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Taller {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String nombre;
	private String tallerista;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private Time horaInicio;
	private Time horaFin;
	
	//@JsonBackReference
	//@JsonManagedReference
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="evento_id")
	private Evento evento;
	
	//@JsonManagedReference
	@OneToOne(mappedBy = "taller", cascade = CascadeType.ALL, 
			  fetch = FetchType.LAZY, optional = false)
	private Ubicacion ubicacion;
	
	public Evento getEvento() {
		return evento;
	}
	
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTallerista() {
		return tallerista;
	}
	public void setTallerista(String tallerista) {
		this.tallerista = tallerista;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Time getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		//this.ubicacion = ubicacion;
		
		if (ubicacion == null) {
            if (this.ubicacion != null) {
                this.ubicacion.setTaller(null);
            }
        }
        else {
        	ubicacion.setTaller(this);
        }
        this.ubicacion = ubicacion;
		
	}
	
	
	
}
