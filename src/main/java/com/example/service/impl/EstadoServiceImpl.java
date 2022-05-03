package com.example.service.impl;

import java.text.DateFormat;
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
import com.example.repository.CuentaRepo;
import com.example.repository.EstadoRepo;

@Service
@Transactional
public class EstadoServiceImpl {

	@Autowired
	private EstadoRepo estadoRepo;
	    
	public List<Estado> listar(Estado estado1) throws Exception {		
		try {
			Estado estado = new Estado();
			estado.setVigente(1);
			List<Estado> listaEstados = estadoRepo.findByVigente(estado.getVigente());
			Estado defaultEstado = new Estado();
			defaultEstado.setCodigoEstado(0);
			defaultEstado.setEstado("Seleccione");
			listaEstados.add(0, defaultEstado);
			return listaEstados;
		} catch (Exception ex) {
			throw new Exception("Error al listar vigencias");
		}
	}	
}
