package com.willembergson.oBalaio.repository;

import com.willembergson.oBalaio.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
