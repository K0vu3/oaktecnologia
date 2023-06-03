package br.com.oaktecnologia.entity.dto;

import jakarta.validation.constraints.NotNull;

public record ProductUpdateDto(
        @NotNull
        Long id,
        String name,
        String description,
        String price
) {
}
