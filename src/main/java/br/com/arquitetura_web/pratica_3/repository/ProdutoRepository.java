package br.com.arquitetura_web.pratica_3.repository;

import br.com.arquitetura_web.pratica_3.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}
