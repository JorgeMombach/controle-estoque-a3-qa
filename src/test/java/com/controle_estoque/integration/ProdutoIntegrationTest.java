package com.controle_estoque.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.controle_estoque.entity.Produto;
import com.controle_estoque.repository.ProdutoRepository;

@DataJpaTest
class ProdutoIntegrationTest {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Test
    void testSalvarProduto() {
        Produto produto = new Produto("Produto Teste", "Descrição Teste", 10.0, 100, true);

        Produto produtoSalvo = produtoRepository.save(produto);

        assertNotNull(produtoSalvo.getId());
        assertEquals("Produto Teste", produtoSalvo.getNome());
    }

}