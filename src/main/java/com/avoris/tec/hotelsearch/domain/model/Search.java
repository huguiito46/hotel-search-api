package com.avoris.tec.hotelsearch.domain.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;


@Getter
@RequiredArgsConstructor
public class Search {

    @NotNull
    private final String id;

    @NotNull
    private final String hotelId;

    @NotNull
    private final String checkIn;

    @NotNull
    private final String checkOut;

    @NotEmpty
    private final List<Integer> ages;

    /**
     * Factory method to create a Search instance with an auto-generated ID.
     */
    public static Search create(String hotelId, String checkIn, String checkOut, List<Integer> ages) {
        return new Search(
                UUID.randomUUID().toString(),
                hotelId,
                checkIn,
                checkOut,
                ages
        );
    }
}
