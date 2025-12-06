package com.avoris.tec.hotelsearch.adapters.in.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/** DTO para recibir datos de búsqueda de disponibilidad de hotel desde el cliente vía HTTP POST.
 *  Representa el cuerpo del JSON recibido en el endpoint /search.
 */
@Schema(description = "Petición de búsqueda de disponibilidad de hotel")
public record SearchRequestDto(

        @NotNull
        @Schema(description = "ID del hotel", example = "HOTEL123")
        String hotelId,

        @NotNull
        @Schema(description = "Fecha de entrada", example = "2025-06-21")
        String checkIn,

        @NotNull
        @Schema(description = "Fecha de salida", example = "2025-06-25")
        String checkOut,

        @NotEmpty
        @Schema(description = "Lista de edades de los huéspedes", example = "[30, 28, 2]")
        List<Integer> ages
) {}
