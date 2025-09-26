package br.com.arquitetura_web.pratica_3.controller;

import br.com.arquitetura_web.pratica_3.model.Produto;
import br.com.arquitetura_web.pratica_3.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {

    protected final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> listar() {
        return produtoService.findAll();
    }

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscar(@PathVariable UUID id) {
        return produtoService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable UUID id, @RequestBody Produto produto) {
        return produtoService.update(id, produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable UUID id) {
        return produtoService.delete(id);
    }
}
