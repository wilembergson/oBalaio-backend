package com.willembergson.oBalaio.dto;

import com.willembergson.oBalaio.entity.Pedido;
import lombok.AllArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@AllArgsConstructor
public class PedidoDTO {

    private Long id;

    @NotEmpty
    private Object[] itens;

    @NotEmpty
    private Double total;

    @NotEmpty
    private String date;

    public PedidoDTO(){}

    public  PedidoDTO(Pedido pedido){
        id = pedido.getId();
        itens = pedido.getItens();
        total = pedido.getTotal();
        date = pedido.getDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object[] getItens() {
        return itens;
    }

    public void setItens(Object[] itens) {
        this.itens = itens;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
