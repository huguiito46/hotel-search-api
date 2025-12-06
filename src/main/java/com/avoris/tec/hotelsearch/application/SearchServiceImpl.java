package com.avoris.tec.hotelsearch.application;

import com.avoris.tec.hotelsearch.domain.model.Search;
import com.avoris.tec.hotelsearch.domain.ports.in.SearchService;
import com.avoris.tec.hotelsearch.domain.ports.out.KafkaPublisherPort;
import com.avoris.tec.hotelsearch.domain.ports.out.SaveSearchPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class SearchServiceImpl implements SearchService {

    private final KafkaPublisherPort kafkaPublisherPort;
    private final SaveSearchPort saveSearchPort;

    public SearchServiceImpl(KafkaPublisherPort kafkaPublisherPort, SaveSearchPort saveSearchPort) {
        this.kafkaPublisherPort = kafkaPublisherPort;
        this.saveSearchPort = saveSearchPort;
    }

    @Override
    public String registerSearch(Search search) {

        log.info("Executing use case: register hotel search. hotelId={}", search.getHotelId());

        kafkaPublisherPort.publish(search);
        log.debug("Search event dispatched to Kafka.");

        String id = saveSearchPort.save(search);
        log.debug("Search persisted in MongoDB. id={}", id);

        log.info("Hotel search registered successfully with id={}", id);

        return id;
    }
}


