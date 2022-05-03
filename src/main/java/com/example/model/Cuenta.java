package com.example.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Table;

@Entity()
@Table(appliesTo = "cuenta")
public class Cuenta {

	private int codigoTipoCuenta;	
	private String tipoCuenta;
	private BigDecimal costoCuenta;	
	private Integer vigente;	
	private String usuarioCreacion;	
	private String fechaCreacion;	
	private String usuarioModificacion;	
	private String fechaModificacion;
	private Estado estado;
	
	@Id
	public int getCodigoTipoCuenta() {
		return codigoTipoCuenta;
	}
	public void setCodigoTipoCuenta(int codigoTipoCuenta) {
		this.codigoTipoCuenta = codigoTipoCuenta;
	}
	
	@Column(name="tipo_cuenta", length = 100)
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	
	@Column(name="costo_cuenta")
	public BigDecimal getCostoCuenta() {
		return costoCuenta;
	}
	public void setCostoCuenta(BigDecimal costoCuenta) {
		this.costoCuenta = costoCuenta;
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
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "estado_cuenta", nullable = false, updatable = true)
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	} 	
	
}

