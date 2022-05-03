package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Cuenta;

@Repository
public interface CuentaRepo extends PagingAndSortingRepository<Cuenta, Integer>{
	
	Cuenta findOneByCodigoTipoCuenta(Integer codigoCuenta);	
	Page<Cuenta> findAll(Pageable pageable);
	Page<Cuenta> findByVigente(Integer vigente, Pageable pageable);   
	Page<Cuenta> findByTipoCuentaContaining(String tipoCuenta, Pageable pageable);
	Page<Cuenta> findAllByEstadoCodigoEstadoAndVigente(Integer estado, Integer vigente, Pageable pageable);  	
}
