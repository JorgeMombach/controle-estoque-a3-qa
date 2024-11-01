package com.controle_estoque.repository;

import com.controle_estoque.entity.Produto;
import com.controle_estoque.entity.SaidaProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaidaProdutoRepository extends JpaRepository <SaidaProduto, Long> {

    List<SaidaProduto> findByAtivoTrue();
}
