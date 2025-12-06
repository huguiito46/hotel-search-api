package com.avoris.tec.hotelsearch.adapters.out.kafka;

import com.avoris.tec.hotelsearch.domain.model.Search;
import com.avoris.tec.hotelsearch.domain.ports.out.KafkaPublisherPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaPublisherAdapter implements KafkaPublisherPort {

    private final KafkaTemplate<String, Search> kafkaTemplate;
    private final String topic;

    public KafkaPublisherAdapter(KafkaTemplate<String, Search> kafkaTemplate,
                                 @Value("${kafka.topics.hotel-availability-searches}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @Override
    public void publish(Search search) {
        log.info("Publishing search event. topic={}, hotelId={}", topic, search.getHotelId());

        kafkaTemplate.send(topic, search)
                .whenComplete((result, ex) -> {
                    if (ex != null) {
                        log.error("Failed to publish search event to Kafka", ex);
                        return;
                    }
                    log.debug("Search event published successfully. offset={}",
                            result.getRecordMetadata().offset());
                });
    }
}

