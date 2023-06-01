package br.com.oaktecnologia.entity.dto;

import br.com.oaktecnologia.entity.Product;

public record ProductListDto (Long id, String name, String description, Double price){

    public ProductListDto(Product product) {
        this(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }
}
