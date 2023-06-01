package br.com.oaktecnologia.entity.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ProductCreateDto(
    @NotBlank
    String name,
    @NotBlank
    String description,
    @NotBlank
    @Min(value=1)
    Double price
) {
}
