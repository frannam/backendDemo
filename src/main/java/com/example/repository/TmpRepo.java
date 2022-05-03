package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Tmp;

@Repository
public interface TmpRepo extends JpaRepository<Tmp, Integer>{

}
