package com.jobJunior.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobJunior.cursomc.modelo.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}