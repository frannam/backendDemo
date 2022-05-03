package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Estado;

@Repository
public interface EstadoRepo extends JpaRepository<Estado, Integer>{
	List<Estado> findByVigente(Integer vigente);   
	List<Estado> findAll();
	Estado findByCodigoEstado(Integer codigoEstado);   


}
