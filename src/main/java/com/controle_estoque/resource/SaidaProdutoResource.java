package com.controle_estoque.resource;

import com.controle_estoque.dto.SaidaProdutoDTO;
import com.controle_estoque.entity.SaidaProduto;
import com.controle_estoque.service.SaidaProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/saidas")
public class SaidaProdutoResource {

    private final SaidaProdutoService saidaProdutoService;

    @Autowired
    public SaidaProdutoResource(SaidaProdutoService saidaProdutoService) {
        this.saidaProdutoService = saidaProdutoService;
    }

    @GetMapping
    public List<SaidaProduto> listarSaidas() {
        return saidaProdutoService.listarSaidas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaidaProduto> obterSaida(@PathVariable Long id) {
        Optional<SaidaProduto> saidaProduto = saidaProdutoService.encontrarSaidaPorId(id);
        return saidaProduto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SaidaProduto> registrarSaida(@RequestBody SaidaProdutoDTO saidaProdutoDTO) {
        SaidaProduto novaSaida = saidaProdutoService.registrarSaida(saidaProdutoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaSaida);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSaida(@PathVariable Long id) {
        saidaProdutoService.excluirSaida(id);
        return ResponseEntity.ok().build();
    }
}

