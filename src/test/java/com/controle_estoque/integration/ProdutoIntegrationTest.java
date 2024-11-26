package com.controle_estoque.integration;

import com.controle_estoque.entity.Produto;
import com.controle_estoque.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testBuscarProdutoPorId() {
        Produto produto = new Produto("Produto Teste", "Descrição Teste", 10.0, 100, true);
        Produto produtoSalvo = produtoRepository.save(produto);

        Optional<Produto> produtoEncontrado = produtoRepository.findById(produtoSalvo.getId());

        assertTrue(produtoEncontrado.isPresent());
        assertEquals("Produto Teste", produtoEncontrado.get().getNome());
    }

    @Test
    void testAtualizarProduto() {
        Produto produto = new Produto("Produto Teste", "Descrição Teste", 10.0, 100, true);
        Produto produtoSalvo = produtoRepository.save(produto);

        produtoSalvo.setNome("Produto Atualizado");
        Produto produtoAtualizado = produtoRepository.save(produtoSalvo);

        assertEquals("Produto Atualizado", produtoAtualizado.getNome());
    }

    @Test
    void testDeletarProduto() {
        Produto produto = new Produto("Produto Teste", "Descrição Teste", 10.0, 100, true);
        Produto produtoSalvo = produtoRepository.save(produto);

        produtoRepository.deleteById(produtoSalvo.getId());

        Optional<Produto> produtoDeletado = produtoRepository.findById(produtoSalvo.getId());

        assertFalse(produtoDeletado.isPresent());
    }

}