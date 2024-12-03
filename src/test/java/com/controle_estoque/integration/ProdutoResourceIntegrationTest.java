package com.controle_estoque.integration;

import com.controle_estoque.entity.Produto;
import com.controle_estoque.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProdutoResourceIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Test
    void testPostProduto() throws Exception {
        String produtoJson = """
                    {
                        "nome": "Produto Teste",
                        "descricao": "Descrição Teste",
                        "preco": 15.0,
                        "quantidadeEstoque": 100,
                        "ativo": true
                    }
                """;

        mockMvc.perform(post("/api/produtos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(produtoJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.nome").value("Produto Teste"))
                .andExpect(jsonPath("$.descricao").value("Descrição Teste"))
                .andExpect(jsonPath("$.preco").value(10.0))
                .andExpect(jsonPath("$.quantidadeEstoque").value(100))
                .andExpect(jsonPath("$.ativo").value(true));
    }

    @Test
    void testListProduto() throws Exception {
        Produto produto = new Produto("Produto Teste", "Descrição Teste", 10.0, 100, true);
        produtoRepository.save(produto);

        mockMvc.perform(get("/api/produtos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThan(0))))
                .andExpect(jsonPath("$[0].nome", is("Produto Teste")));
    }

}
