package br.com.oaktecnologia.entity;

import br.com.oaktecnologia.entity.dto.ProductCreateDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Double price;
    private Boolean isAvailable;

    public Product(ProductCreateDto product) {
        this.name = product.name();
        this.description = product.description();
        this.price = product.price();
        this.isAvailable = true;
    }
}
