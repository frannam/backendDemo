package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.CuentaCliente;

@Repository
public interface CuentaClienteRepo extends JpaRepository<CuentaCliente, Integer>{
	
	
}
