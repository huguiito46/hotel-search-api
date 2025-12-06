package com.avoris.tec.hotelsearch.adapters.out.mongo;

import com.avoris.tec.hotelsearch.domain.model.Search;
import com.avoris.tec.hotelsearch.domain.ports.out.CountSearchPort;
import com.avoris.tec.hotelsearch.domain.ports.out.SaveSearchPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class MongoSearchAdapter implements SaveSearchPort, CountSearchPort {

    private final SearchMongoRepository repository;

    public MongoSearchAdapter(SearchMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public String save(Search search) {
        log.info("Persisting search in MongoDB. hotelId={}", search.getHotelId());
        return repository.save(search).getId();
    }

    @Override
    public long count() {
        log.debug("Counting all searches in MongoDB...");
        return repository.count();
    }
}
