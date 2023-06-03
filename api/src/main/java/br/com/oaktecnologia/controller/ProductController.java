package br.com.oaktecnologia.controller;

import br.com.oaktecnologia.entity.Product;
import br.com.oaktecnologia.entity.dto.ProductCreateDto;
import br.com.oaktecnologia.entity.dto.ProductInfoDto;
import br.com.oaktecnologia.entity.dto.ProductListDto;
import br.com.oaktecnologia.entity.dto.ProductUpdateDto;
import br.com.oaktecnologia.service.ProductService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping
    public ResponseEntity<Page<ProductListDto>> getActiveProducts(Pageable pageable) {
        return ResponseEntity.ok(service.getActiveProducts(pageable));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<ProductListDto>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.getAllProducts(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        Product product = service.getById(id);
        return ResponseEntity.ok(new ProductInfoDto(product));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid ProductUpdateDto data) {
        Product product = service.update(data);
        return ResponseEntity.ok(new ProductInfoDto(product));
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity enableProductSales(@PathVariable Long id) {
        Product product = service.enableSales(id);
        return ResponseEntity.ok(new ProductInfoDto(product));
    }
}
