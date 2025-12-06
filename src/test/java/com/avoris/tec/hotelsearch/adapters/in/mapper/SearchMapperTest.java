package com.avoris.tec.hotelsearch.adapters.in.mapper;

import com.avoris.tec.hotelsearch.adapters.in.dto.SearchRequestDto;
import com.avoris.tec.hotelsearch.domain.model.Search;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SearchMapperTest {

    @Autowired
    private SearchMapper mapper;

    @Test
    void shouldMapDtoToDomainModel() {

        SearchRequestDto dto = new SearchRequestDto(
                "HOTEL123",
                "2025-06-21",
                "2025-06-25",
                List.of(30, 28)
        );

        Search search = mapper.toDomain(dto);

        assertEquals("HOTEL123", search.getHotelId());
        assertEquals("2025-06-21", search.getCheckIn());
        assertEquals("2025-06-25", search.getCheckOut());
        assertEquals(List.of(30, 28), search.getAges());
    }
}

