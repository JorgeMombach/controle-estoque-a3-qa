package com.controle_estoque.repository;

import com.controle_estoque.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Long> {

    List<Produto> findByAtivoTrue();
}
