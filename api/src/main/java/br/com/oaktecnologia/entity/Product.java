package br.com.oaktecnologia.entity;

import br.com.oaktecnologia.entity.dto.ProductCreateDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name="TB_PRODUTOS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean isAvailable;
    private Boolean isActive;

    public Product(ProductCreateDto product) {
        this.name = product.name();
        this.description = product.description();
        this.price = product.price();
        this.isAvailable = true;
        this.isActive = true;
    }
}
