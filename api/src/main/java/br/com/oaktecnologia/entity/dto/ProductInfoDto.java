package br.com.oaktecnologia.entity.dto;

import br.com.oaktecnologia.entity.Product;

import java.math.BigDecimal;

public record ProductInfoDto(Long id, String name, String description, BigDecimal price) {
    public ProductInfoDto(Product product) {
        this(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }
}
