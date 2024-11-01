package com.controle_estoque.repository;

import com.controle_estoque.entity.EntradaProduto;
import com.controle_estoque.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntradaProdutoRepository extends JpaRepository <EntradaProduto, Long>{

    List<EntradaProduto> findByAtivoTrue();
}
