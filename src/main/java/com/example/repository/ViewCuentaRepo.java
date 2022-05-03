package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.model.ViewCuenta;

@Repository
public interface ViewCuentaRepo extends PagingAndSortingRepository<ViewCuenta, Integer>{
		
	Page<ViewCuenta> findAll(Pageable pageable);
	Page<ViewCuenta> findByVigente(Integer vigente, Pageable pageable);   
	Page<ViewCuenta> findByDescripcionTipoCuentaContaining(String tipoCuenta, Pageable pageable);
	Page<ViewCuenta> findAllByCodigoEstadoAndVigente(Integer estado, Integer vigente, Pageable pageable);
	Page<ViewCuenta> findByCodigoEstadoAndVigenteAndDescripcionTipoCuentaContaining(Integer codigoEstado, int i,
			String descripcionTipoCuenta, Pageable pageable);   


	
}
