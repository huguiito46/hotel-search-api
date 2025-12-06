package com.avoris.tec.hotelsearch.adapters.in.mapper;

import com.avoris.tec.hotelsearch.adapters.in.dto.SearchRequestDto;
import com.avoris.tec.hotelsearch.domain.model.Search;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SearchMapper {

    default Search toDomain(SearchRequestDto dto) {
        return Search.create(
                dto.hotelId(),
                dto.checkIn(),
                dto.checkOut(),
                dto.ages()
        );
    }
}
