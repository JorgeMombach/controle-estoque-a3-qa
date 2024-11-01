package com.controle_estoque.repository;

import com.controle_estoque.entity.EntradaProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaProdutoRepository extends JpaRepository <EntradaProduto, Long>{
}
