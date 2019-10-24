package mx.uacm.reclutaSoft.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnTransformer;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
//	@ManyToOne
//	@JoinColumn(name="rol_id")
//	private Rol rol;
	
	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private List<Rol> roles = new ArrayList<Rol>();
	
	private String nombre;
	
	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	private String correo;
	
	@ColumnTransformer(write=" MD5(?) ", read=" MD5(?) ")
	private String contrasenia;
	
	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private List<Proyecto> participaciones;
	
	private String telefono;
	
	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private List<Habilidad> habilidades;
	
	private int edad;
	
	private String web;
	
	private int reputacion;
	
	private String titulo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public List<Rol> getRoles() {
		return roles;
	}
	
	public void setRoles(List<Rol> roles) {
		this.roles = roles;
		for (Rol rol : roles) {
			rol.setUsuario(this);
		}
	}
	
	public void setRol(Rol rol) {
		roles.add(rol);
		rol.setUsuario(this);
	}
	
	public void removeRol(Rol rol) {
		roles.remove(rol);
		rol.setUsuario(null);
	}
	
//	public Rol getRol() {
//		return rol;
//	}
//
//	public void setRol(Rol rol) {
//		this.rol = rol;
//	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public List<Proyecto> getParticipaciones() {
		return participaciones;
	}

	public void setParticipaciones(List<Proyecto> participaciones) {
		this.participaciones = participaciones;
		for (Proyecto proyecto : participaciones) {
			proyecto.setUsuario(this);
		}
	}
	
	public void setParticipacion(Proyecto proyecto) {
		participaciones.add(proyecto);
		proyecto.setUsuario(this);
	}
	
	public void removeParticipacion(Proyecto proyecto) {
		participaciones.remove(proyecto);
		proyecto.setUsuario(null);
	}
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Habilidad> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(List<Habilidad> habilidades) {
		this.habilidades = habilidades;
		for (Habilidad habilidad : habilidades) {
			habilidad.setUsuario(this);
		}
	}
	
	public void setHabilidad(Habilidad habilidad) {
		habilidades.add(habilidad);
		habilidad.setUsuario(this);
	}
	
	public void removeHabilidad(Habilidad habilidad) {
		habilidades.remove(habilidad);
		habilidad.setUsuario(null);
	}
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public int getReputacion() {
		return reputacion;
	}

	public void setReputacion(int reputacion) {
		this.reputacion = reputacion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
