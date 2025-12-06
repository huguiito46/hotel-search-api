package com.avoris.tec.hotelsearch.adapters.out.mongo;

import com.avoris.tec.hotelsearch.domain.model.Search;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SearchMongoRepository extends MongoRepository<Search, String> {
}
