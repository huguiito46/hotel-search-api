package com.avoris.tec.hotelsearch.adapters.out.kafka;

import com.avoris.tec.hotelsearch.domain.model.Search;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.junit.jupiter.api.Test;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class KafkaPublisherAdapterIntegrationTest {

    @Test
    void shouldPublishMessageToKafka() throws Exception {
        // Arrange
        KafkaTemplate<String, Search> kafkaTemplate = mock(KafkaTemplate.class);

        KafkaPublisherAdapter adapter =
                new KafkaPublisherAdapter(kafkaTemplate, "hotel_availability_searches");

        Search search = Search.create(
                "HOTEL123",
                "2025-01-01",
                "2025-01-05",
                List.of(30)
        );

        // Mock del futuro devuelto por KafkaTemplate.send()
        CompletableFuture<SendResult<String, Search>> future = new CompletableFuture<>();
        future.complete(new SendResult<>(null, new RecordMetadata(null, 0, 0, 0L, 0, 0)));

        when(kafkaTemplate.send(eq("hotel_availability_searches"), eq(search)))
                .thenReturn(future);

        // Act
        adapter.publish(search);

        // Assert
        verify(kafkaTemplate, times(1))
                .send("hotel_availability_searches", search);
    }
}
