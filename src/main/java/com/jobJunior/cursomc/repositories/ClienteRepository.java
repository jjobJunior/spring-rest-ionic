package com.jobJunior.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobJunior.cursomc.modelo.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}