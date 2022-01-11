package com.jobJunior.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobJunior.cursomc.modelo.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}