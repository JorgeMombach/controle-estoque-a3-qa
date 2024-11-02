package com.controle_estoque.service;

import com.controle_estoque.dto.EntradaProdutoDTO;
import com.controle_estoque.entity.EntradaProduto;
import com.controle_estoque.entity.Produto;
import com.controle_estoque.repository.EntradaProdutoRepository;
import com.controle_estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntradaProdutoService {

    private final EntradaProdutoRepository entradaProdutoRepository;
    private final ProdutoRepository produtoRepository;

    @Autowired
    public EntradaProdutoService(EntradaProdutoRepository entradaProdutoRepository, ProdutoRepository produtoRepository) {
        this.entradaProdutoRepository = entradaProdutoRepository;
        this.produtoRepository = produtoRepository;
    }

    public List<EntradaProduto> listarEntradas() {
        return entradaProdutoRepository.findByAtivoTrue();
    }

    public EntradaProduto registrarEntrada(EntradaProdutoDTO entradaProdutoDTO) {
        Produto produto = produtoRepository.findById(entradaProdutoDTO.getProdutoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + entradaProdutoDTO.getProdutoId()));

        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + entradaProdutoDTO.getQuantidade());
        produtoRepository.save(produto);

        EntradaProduto entradaProduto = new EntradaProduto(produto, entradaProdutoDTO.getQuantidade(), entradaProdutoDTO.getDataEntrada(), true);
        return entradaProdutoRepository.save(entradaProduto);
    }

    public Optional<EntradaProduto> encontrarEntradaPorId(Long id) {
        return entradaProdutoRepository.findById(id);
    }

    public void excluirEntrada(Long id) {
        EntradaProduto entradaProduto = entradaProdutoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrada não encontrada com ID: "));
        entradaProduto.setAtivo(false);
        entradaProdutoRepository.save(entradaProduto);
    }
}
