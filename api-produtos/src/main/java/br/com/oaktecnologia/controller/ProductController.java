package br.com.oaktecnologia.controller;

import br.com.oaktecnologia.entity.Product;
import br.com.oaktecnologia.entity.dto.ProductCreateDto;
import br.com.oaktecnologia.entity.dto.ProductInfoDto;
import br.com.oaktecnologia.service.ProductService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid ProductCreateDto data, UriComponentsBuilder uriBuilder) {
        Product product = new Product(data);
        service.create(product);
        var uri = uriBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(uri).body(new ProductInfoDto(product));
    }
}
