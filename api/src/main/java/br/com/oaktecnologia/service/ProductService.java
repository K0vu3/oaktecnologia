package br.com.oaktecnologia.service;

import br.com.oaktecnologia.entity.Product;
import br.com.oaktecnologia.entity.dto.ProductListDto;
import br.com.oaktecnologia.entity.dto.ProductUpdateDto;
import br.com.oaktecnologia.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public Product create(Product product) {
        return repository.save(product);
    }


    public Page<ProductListDto> getActiveProducts(Pageable pageable) {
        return repository.findAllByIsAvailableTrue(pageable).map(ProductListDto::new);
    }

    public Page<ProductListDto> getAllProducts(Pageable pageable) {
        return repository.findAll(pageable).map(ProductListDto::new);
    }


    public Product getById(Long id) {
        return repository.getReferenceById(id);
    }

    public Product update(ProductUpdateDto data) {
        Optional<Product> product = repository.findById(data.id());
        if(product.isPresent()) {
            Product updated = product.get();
            if (data.name() != null) {
                updated.setName(data.name());
            }
            if (data.description()!= null) {
                updated.setDescription(data.description());
            }
            if (data.price()!= null) {
                BigDecimal price = new BigDecimal(data.price());
                updated.setPrice(price);
            }
            return updated;
        }

        return null;
    }

    public void delete(Long id) {
        Product product = repository.getReferenceById(id);
        product.setIsAvailable(false);
    }

    public Product enable(Long id) {
        Product product = repository.getReferenceById(id);
        product.setIsAvailable(true);
        return product;
    }
}
