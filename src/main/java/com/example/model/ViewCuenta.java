package com.example.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo = "view_cuenta")
public class ViewCuenta {

	private int codigoTipoCuenta;	
	private String descripcionTipoCuenta;
	private BigDecimal costoCuenta;	
	private Integer vigente;	
	private Integer codigoEstado;
	private String descripcionEstado;

	
	@Id
	@Column(name="codigo_tipo_cuenta")
	public int getCodigoTipoCuenta() {
		return codigoTipoCuenta;
	}
	public void setCodigoTipoCuenta(int codigoTipoCuenta) {
		this.codigoTipoCuenta = codigoTipoCuenta;
	}
	
	@Column(name="descripcion_tipo_cuenta", length = 100)
	public String getDescripcionTipoCuenta() {
		return descripcionTipoCuenta;
	}
	public void setDescripcionTipoCuenta(String descripcionTipoCuenta) {
		this.descripcionTipoCuenta = descripcionTipoCuenta;
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
	
	@Column(name = "codigo_estado")
	public Integer getCodigoEstado() {
		return codigoEstado;
	}
	public void setCodigoEstado(Integer codigoEstado) {
		this.codigoEstado = codigoEstado;
	} 	
	
	@Column(name="descripcion_estado")
	public String getDescripcionEstado() {
		return descripcionEstado;
	}
	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}
}

