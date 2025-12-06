package com.avoris.tec.hotelsearch.adapters.in.controller;

import com.avoris.tec.hotelsearch.adapters.in.dto.SearchRequestDto;

import com.avoris.tec.hotelsearch.adapters.in.mapper.SearchMapper;
import com.avoris.tec.hotelsearch.domain.model.Search;
import com.avoris.tec.hotelsearch.domain.ports.in.SearchQueryService;
import com.avoris.tec.hotelsearch.domain.ports.in.SearchService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v1/search")
public class SearchController {

    private final SearchService searchService;
    private final SearchQueryService searchQueryService;
    private final SearchMapper searchMapper;


    public SearchController(SearchService searchService, SearchQueryService searchQueryService, SearchMapper searchMapper) {
        this.searchService = searchService;
        this.searchQueryService = searchQueryService;
        this.searchMapper = searchMapper;
    }

    @PostMapping("/availability/hotel")
    public ResponseEntity<Map<String, String>> createSearch(@RequestBody @Valid SearchRequestDto request) {

        log.info("Received hotel availability search request. hotelId={}", request.hotelId());

        Search search = searchMapper.toDomain(request);
        String searchId = searchService.registerSearch(search);

        log.info("Search successfully registered. searchId={}", searchId);

        return ResponseEntity.ok(Map.of("searchId", searchId));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAll() {
        long total = searchQueryService.countSearches();
        return ResponseEntity.ok(total);
    }
}
