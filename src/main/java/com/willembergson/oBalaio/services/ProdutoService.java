package com.willembergson.oBalaio.services;

import com.willembergson.oBalaio.dto.PedidoDTO;
import com.willembergson.oBalaio.dto.ProdutoDTO;
import com.willembergson.oBalaio.entity.Produto;
import com.willembergson.oBalaio.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public List<ProdutoDTO> findAll(){
        List<Produto> list = produtoRepository.findAll();
        Collections.sort(list);
        return list.stream().map(x -> new ProdutoDTO(x)).collect(Collectors.toList());
    }

    public Produto findById(Long id) throws Exception{
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new Exception());
        return produto;
    }

    public void delete(Long id) throws  Exception{
        produtoRepository.findById(id).orElseThrow(() -> new Exception());
        produtoRepository.deleteById(id);
    }

    public void create(Produto produto){
        produtoRepository.save(produto);
    }

    public Produto update(Long id, Produto produto){
       try{
           Produto p = produtoRepository.getOne(id);
           updateData(p, produto);
           return produtoRepository.save(p);
       }catch(EntityNotFoundException e){
           throw new EntityNotFoundException();
       }
    }

    private void updateData(Produto p, Produto produto){
        p.setName(produto.getName());
        p.setPrice(produto.getPrice());
    }
}
