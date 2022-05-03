package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Cuenta;
import com.example.model.Estado;
import com.example.service.impl.CuentaServiceImpl;
import com.example.service.impl.EstadoServiceImpl;

@RestController
@RequestMapping("/estado") 
public class EstadoController {

	@Autowired
	private EstadoServiceImpl estadoServiceImpl;
			
	@GetMapping(value = "/listar")
	public List<Estado> listar(@ModelAttribute Estado estado) throws Exception {
		try {
			return estadoServiceImpl.listar(estado);
		}catch (Exception ex) {
			throw new Exception();
		}
	}		
}
