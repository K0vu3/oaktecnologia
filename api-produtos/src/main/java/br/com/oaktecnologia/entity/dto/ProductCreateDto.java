package br.com.oaktecnologia.entity.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductCreateDto(
    @NotBlank
    String name,
    @NotBlank
    String description,
    @NotNull
    BigDecimal price
) {
}
