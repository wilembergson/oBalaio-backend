package com.willembergson.oBalaio.dto;

import com.willembergson.oBalaio.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private Long id;

    @NotEmpty
    @Size(min=2, max=20)
    private String name;

    @NotEmpty
    private Double price;

    public ProdutoDTO(Produto p){
        id = p.getId();
        name = p.getName();
        price = p.getPrice();
    }

    public ProdutoDTO(Optional<Produto> p){

    }
}
