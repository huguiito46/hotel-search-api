package com.avoris.tec.hotelsearch.application;

import com.avoris.tec.hotelsearch.domain.ports.in.SearchQueryService;
import com.avoris.tec.hotelsearch.domain.ports.out.CountSearchPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SearchQueryServiceImpl implements SearchQueryService {

    private final CountSearchPort countSearchPort;

    @Override
    public long countSearches() {
        log.debug("Retrieving total number of hotel searches...");
        long total = countSearchPort.count();
        log.info("Total searches found: {}", total);
        return total;
    }
}
