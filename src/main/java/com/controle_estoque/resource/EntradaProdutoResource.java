package com.controle_estoque.resource;

import com.controle_estoque.dto.EntradaProdutoDTO;
import com.controle_estoque.entity.EntradaProduto;
import com.controle_estoque.service.EntradaProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/entradas")
public class EntradaProdutoResource {

    private final EntradaProdutoService entradaProdutoService;

    @Autowired
    public EntradaProdutoResource(EntradaProdutoService entradaProdutoService) {
        this.entradaProdutoService = entradaProdutoService;
    }

    @GetMapping
    public List<EntradaProduto> listarEntradas() {
        return entradaProdutoService.listarEntradas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntradaProduto> obterEntrada(@PathVariable Long id) {
        Optional<EntradaProduto> entradaProduto = entradaProdutoService.encontrarEntradaPorId(id);
        return entradaProduto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EntradaProduto> registrarEntrada(@RequestBody EntradaProdutoDTO entradaProdutoDTO) {
        EntradaProduto novaEntrada = entradaProdutoService.registrarEntrada(entradaProdutoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEntrada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEntrada(@PathVariable Long id) {
        entradaProdutoService.excluirEntrada(id);
        return ResponseEntity.ok().build();
    }
}
