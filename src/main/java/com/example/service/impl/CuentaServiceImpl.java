package com.example.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Cuenta;
import com.example.model.Estado;
import com.example.model.ViewCuenta;
import com.example.repository.CuentaRepo;
import com.example.repository.EstadoRepo;
import com.example.repository.ViewCuentaRepo;

@Service
@Transactional
public class CuentaServiceImpl {

	@Autowired
	private CuentaRepo cuentaRepo;
	
	@Autowired
	private ViewCuentaRepo viewCuentaRepo;
	
	@Autowired
	private EstadoRepo estadoRepo;
	
    private static String strDateFormat = "dd-MM-yyyy"; 
    private static Integer NO_VIGENTE = 0;     

    
	public Page<ViewCuenta> buscar(ViewCuenta cuenta, Pageable pageable) throws Exception {
		Page<ViewCuenta> pageFiltrado = null;
		try {
			if(cuenta.getCodigoEstado() != null && cuenta.getCodigoEstado() != 0 
					&& cuenta.getDescripcionTipoCuenta() != null) {
				pageFiltrado = viewCuentaRepo.findByCodigoEstadoAndVigenteAndDescripcionTipoCuentaContaining(cuenta.getCodigoEstado(), 1,
						cuenta.getDescripcionTipoCuenta(), pageable);
			}else if(cuenta.getCodigoEstado() != null && cuenta.getCodigoEstado() != 0) {
					pageFiltrado = viewCuentaRepo.findAllByCodigoEstadoAndVigente(cuenta.getCodigoEstado(), 1, pageable);
			}else if(cuenta.getDescripcionTipoCuenta() != null) {
					pageFiltrado = viewCuentaRepo.findByDescripcionTipoCuentaContaining(cuenta.getDescripcionTipoCuenta(), pageable);	
			}else {
				pageFiltrado = viewCuentaRepo.findAll(pageable);	
			}			
			return pageFiltrado;
		} catch (Exception ex) {
			throw new Exception("Error al buscar cuentas");
		}
	}
	
	public List<Cuenta> listar(Cuenta cuenta) {			
			return null;
	}		
	
	public Cuenta crear(Cuenta nuevo) throws Exception {	        
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
		    String fecha = sdf.format(new Date());     
		    
		    Estado estado = estadoRepo.findByCodigoEstado(1);
		    
		    Cuenta cuentaOrigen = cuentaRepo.findOneByCodigoTipoCuenta(nuevo.getCodigoTipoCuenta());
			if (cuentaOrigen != null){
				throw new Exception("Cuenta ya existe");
			}else {
				nuevo.setVigente(1);
				nuevo.setUsuarioCreacion("CTA_CREAR");
				nuevo.setFechaCreacion(fecha);
				nuevo.setUsuarioModificacion("CTA_CREAR");
				nuevo.setFechaModificacion(fecha);
				nuevo.setEstado(estado);
				return cuentaRepo.save(nuevo);	
			}
		}catch(Exception ex) {
			throw ex;
		}
	}

	public Cuenta modificar(Cuenta modificado) throws Exception {
		try {
			Cuenta cuentaOrigen = cuentaRepo.findOneByCodigoTipoCuenta(modificado.getCodigoTipoCuenta());
			if (cuentaOrigen == null){
				throw new Exception("Cuenta no existe");
			}
			
			Estado estadoNueva = estadoRepo.findByCodigoEstado(modificado.getEstado().getCodigoEstado());
			if (estadoNueva == null){
				throw new Exception("El nuevo estado no existe");
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
		    String fecha = sdf.format(new Date());   
		    		    		    
			cuentaOrigen.setTipoCuenta(modificado.getTipoCuenta());
			cuentaOrigen.setCostoCuenta(modificado.getCostoCuenta());
			cuentaOrigen.setVigente(modificado.getVigente());
			cuentaOrigen.setEstado(estadoNueva);
			cuentaOrigen.setUsuarioModificacion("CTA_MODIF");
			cuentaOrigen.setFechaModificacion(fecha);		
			return cuentaRepo.save(cuentaOrigen);
		}catch(Exception ex) {
			throw ex;
		}
	}

	public Cuenta obtener(Integer codigoTipoCuenta) {
		try {
			Cuenta jpa = cuentaRepo.findOneByCodigoTipoCuenta(codigoTipoCuenta);
			return jpa;
		}catch(Exception ex) {
			throw ex;
		}
	}

	public Cuenta eliminar(Cuenta cuentaElim) throws Exception {
		try {
			Cuenta cuentaOrigen = cuentaRepo.findOneByCodigoTipoCuenta(cuentaElim.getCodigoTipoCuenta());
			if (cuentaOrigen == null){
				throw new Exception("Cuenta no existe");
			}	
			
			SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
		    String fecha = sdf.format(new Date());   
			
			//0: no vigente y 1: vigente
			cuentaOrigen.setVigente(NO_VIGENTE);
			cuentaOrigen.setUsuarioModificacion("CTA_ELIM");
			cuentaOrigen.setFechaModificacion(fecha);		
			return cuentaRepo.save(cuentaOrigen);
		}catch(Exception ex) {
			throw ex;
		}
	}
}
