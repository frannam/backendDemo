package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo = "estado")
public class Estado {

	private Integer codigoEstado;	
	private String estado;
	private Integer vigente;	
	private String usuarioCreacion;	
	private String fechaCreacion;	
	private String usuarioModificacion;	
	private String fechaModificacion;
	
	@Id
	public int getCodigoEstado() {
		return codigoEstado;
	}
	public void setCodigoEstado(int codigoEstado) {
		this.codigoEstado = codigoEstado;
	}
	
	@Column(name="estado", length = 100)
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}	
		
	@Column(name="vigente")
	public Integer getVigente() {
		return vigente;
	}
	public void setVigente(Integer vigente) {
		this.vigente = vigente;
	}
	
	@Column(name="usuario_creacion", length = 45)
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	
	@Column(name="fecha_creacion")
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	@Column(name="usuario_modificacion", length = 45)
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}
	
	@Column(name="fecha_modificacion")
	public String getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	} 	
	
}

