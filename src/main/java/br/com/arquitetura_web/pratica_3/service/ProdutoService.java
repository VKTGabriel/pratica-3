package br.com.arquitetura_web.pratica_3.service;

import br.com.arquitetura_web.pratica_3.model.Produto;
import br.com.arquitetura_web.pratica_3.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ResponseEntity<Produto> save(Produto produto) {
        Produto p = produtoRepository.save(produto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(p.getId())
                .toUri();

        return ResponseEntity.created(uri).body(p);
    }

    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> produtos = produtoRepository.findAll();
        return ResponseEntity.ok(produtos);
    }

    public ResponseEntity<Produto> findById(UUID id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Void> delete(UUID id) {
        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Produto> update(UUID id, Produto produto) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isPresent()) {
            Produto p = produtoOptional.get();
            p.setNome(produto.getNome());
            p.setPreco(produto.getPreco());
            produtoRepository.save(p);
            return ResponseEntity.ok(p);
        }
        return ResponseEntity.notFound().build();
    }
}
