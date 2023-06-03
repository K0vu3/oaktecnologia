package br.com.oaktecnologia.repository;

import br.com.oaktecnologia.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.nio.channels.FileChannel;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllByIsAvailableTrue(Pageable pageable);

    Page<Product> findAllByIsActiveTrue(Pageable pageable);
}
