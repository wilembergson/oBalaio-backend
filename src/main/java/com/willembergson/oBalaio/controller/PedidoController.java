package com.willembergson.oBalaio.controller;

import com.willembergson.oBalaio.dto.PedidoDTO;
import com.willembergson.oBalaio.entity.Pedido;
import com.willembergson.oBalaio.entity.Produto;
import com.willembergson.oBalaio.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private PedidoService service;

    @Autowired
    public PedidoController(PedidoService service){
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPedido(@RequestBody Pedido pedido){
        service.create(pedido);
    }

    @GetMapping("/listAll")
    public List<PedidoDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pedido findById(@PathVariable Long id) throws Exception{
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws Exception {
        service.delete(id);
    }
}
