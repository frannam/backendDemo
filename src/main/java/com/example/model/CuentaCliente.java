package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo = "cuenta_cliente")
public class CuentaCliente {

	private int correlativo;	
	private Cliente cliente;
    private Cuenta cuenta;	
	private Integer estadoCtaCliente;	
	private String usuarioCreacion;	
	private String fechaCreacion;	
	private String usuarioModificacion;	
	private String fechaModificacion;		
	
	@Id
	public int getCorrelativo() {
		return correlativo;
	}
	public void setCorrelativo(int correlativo) {
		this.correlativo = correlativo;
	}
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente", nullable = false, updatable = false)
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cuenta", nullable = false, updatable = false)
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}		
	
	@Column(name="estado_cta_cliente")
	public Integer getEstadoCtaCliente() {
		return estadoCtaCliente;
	}
	public void setEstadoCtaCliente(Integer estadoCtaCliente) {
		this.estadoCtaCliente = estadoCtaCliente;
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

