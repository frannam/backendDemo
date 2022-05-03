package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Cuenta;
import com.example.model.ViewCuenta;
import com.example.service.impl.CuentaServiceImpl;

@RestController
@RequestMapping("/api") 
public class CuentaController {

	@Autowired
	private CuentaServiceImpl cuentaServiceImpl;
			
	@GetMapping(value = "/buscar")
	public Page<ViewCuenta> buscar(@ModelAttribute ViewCuenta cuenta, Pageable pageable) throws Exception {
		return cuentaServiceImpl.buscar(cuenta, pageable);
	}

	@GetMapping(value = "/listar")
	public List<Cuenta> listar(@ModelAttribute Cuenta cuenta) {
		return cuentaServiceImpl.listar(cuenta);
	}

	@PostMapping(value = "/crear")
	public Cuenta crear(@RequestBody Cuenta cuenta) {
		try {		
			return cuentaServiceImpl.crear(cuenta);
		} catch (Exception e) {
			return null;
		}
	}

	@PutMapping(value = "/modificar")
	public Cuenta modificar(@RequestBody Cuenta cuenta) {
		try {
			return cuentaServiceImpl.modificar(cuenta);
		} catch (Exception e) {
			return null;
		}
	}

	@GetMapping(value = "/obtener/{codigoTipoCuenta}")
	public Cuenta obtener(@PathVariable Integer codigoTipoCuenta) {
		try {			
			return cuentaServiceImpl.obtener(codigoTipoCuenta);
		} catch (Exception e) {
			return null;
		}
	}

	@DeleteMapping(value = "/eliminar/{codigoTipoCuenta}")
	public Cuenta eliminar(@PathVariable Integer codigoTipoCuenta) {
		try {
			Cuenta cta = new Cuenta();
			cta.setCodigoTipoCuenta(codigoTipoCuenta);
			return cuentaServiceImpl.eliminar(cta);
		} catch (Exception e) {
			return null;
		}
	}
	
}
