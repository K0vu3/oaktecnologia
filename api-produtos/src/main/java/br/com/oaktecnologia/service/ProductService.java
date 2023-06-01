package br.com.oaktecnologia.service;

import br.com.oaktecnologia.entity.Product;
import br.com.oaktecnologia.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public Product create(Product product) {
        return repository.save(product);
    }
}
