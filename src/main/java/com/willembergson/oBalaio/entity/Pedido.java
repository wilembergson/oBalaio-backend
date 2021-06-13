package com.willembergson.oBalaio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
public class Pedido implements Comparable<Pedido>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Object[] itens;
    private Double total;
    private String date = dataAtual();

    public Pedido(){
    }

    public Pedido(Object[] itens, Double total){
        this.itens = itens;
        this.total = total;
    }

    private String dataAtual(){
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return formatar.format(LocalDateTime.now());
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

    public Double getTotal() {
        return total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido)) return false;
        Pedido pedido = (Pedido) o;
        return id.equals(pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Pedido outraPessoa) {
        if(this.id > outraPessoa.getId()){
            return -1;
        }
        else if(this.id < outraPessoa.getId()){
            return 1;
        }
        return 0;
    }
}
