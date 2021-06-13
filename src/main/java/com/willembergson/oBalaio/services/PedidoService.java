package com.willembergson.oBalaio.services;

import com.willembergson.oBalaio.dto.PedidoDTO;
import com.willembergson.oBalaio.entity.Pedido;
import com.willembergson.oBalaio.entity.Produto;
import com.willembergson.oBalaio.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    private final PedidoRepository repository;

    @Autowired
    public PedidoService(PedidoRepository repository){
        this.repository = repository;
    }

    public void create(Pedido pedido){
        repository.save(pedido);
    }

    public List<PedidoDTO> findAll(){
        List<Pedido> list = repository.findAll();
        Collections.sort(list);
        return list.stream()
                .map(x -> new PedidoDTO(x)).collect(Collectors.toList());
    }

    public Pedido findById(Long id) throws Exception{
        Pedido pedido = repository.findById(id).orElseThrow(() -> new Exception());
        return pedido;
    }

    public void delete(Long id) throws  Exception{
        repository.findById(id).orElseThrow(() -> new Exception());
        repository.deleteById(id);
    }
}
