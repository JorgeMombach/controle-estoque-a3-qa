package com.controle_estoque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.controle_estoque.entity.Produto;

@SpringBootTest
class ControleEstoqueApplicationTests {

	@Test
	void testConstrutorCompleto() {
        Produto produto = new Produto("Produto A", "Descrição A", 10.0, 100, false);
        
        assertEquals("Produto A", produto.getNome());
        assertEquals("Descrição A", produto.getDescricao());
        assertEquals(10.0, produto.getPreco());
        assertEquals(100, produto.getQuantidadeEstoque());
        assertFalse(produto.getAtivo());
    }

	@Test
    void testConstrutorSemAtivo() {
        Produto produto = new Produto("Produto B", "Descrição B", 20.0, 50);
        
        assertEquals("Produto B", produto.getNome());
        assertEquals("Descrição B", produto.getDescricao());
        assertEquals(20.0, produto.getPreco());
        assertEquals(50, produto.getQuantidadeEstoque());
        assertTrue(produto.getAtivo());
    }

	@Test
    void testGettersAndSetters() {
        Produto produto = new Produto();
        
        produto.setNome("Produto C");
        assertEquals("Produto C", produto.getNome());
        
        produto.setDescricao("Descrição C");
        assertEquals("Descrição C", produto.getDescricao());
        
        produto.setPreco(30.0);
        assertEquals(30.0, produto.getPreco());
        
        produto.setQuantidadeEstoque(200);
        assertEquals(200, produto.getQuantidadeEstoque());
        
        produto.setAtivo(false);
        assertFalse(produto.getAtivo());
    }

}