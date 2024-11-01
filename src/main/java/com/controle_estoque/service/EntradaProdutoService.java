package com.controle_estoque.service;

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

    public EntradaProduto registrarEntrada(EntradaProduto entradaProduto) {
        Optional<Produto> produtoOptional = produtoRepository.findById(entradaProduto.getProduto().getId());
        if (produtoOptional.isPresent()) {
            Produto produto = produtoOptional.get();
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + entradaProduto.getQuantidade());
            produtoRepository.save(produto);
            return entradaProdutoRepository.save(entradaProduto);
        } else {
            throw new RuntimeException("Produto não encontrado com o ID: " + entradaProduto.getProduto().getId());
        }
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
