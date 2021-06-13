package com.willembergson.oBalaio.repository;

import com.willembergson.oBalaio.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
