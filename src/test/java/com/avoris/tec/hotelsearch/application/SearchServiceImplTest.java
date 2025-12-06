package com.avoris.tec.hotelsearch.application;

import com.avoris.tec.hotelsearch.domain.model.Search;
import com.avoris.tec.hotelsearch.domain.ports.out.KafkaPublisherPort;
import com.avoris.tec.hotelsearch.domain.ports.out.SaveSearchPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SearchServiceImplTest {

    @Mock
    private KafkaPublisherPort publisher;

    @Mock
    private SaveSearchPort save;

    @InjectMocks
    private SearchServiceImpl service;

    @Test
    void shouldRegisterSearch() {

        Search search = Search.create("H123", "2025-06-21", "2025-06-25", List.of(30, 20));

        when(save.save(search)).thenReturn("12345");

        String id = service.registerSearch(search);

        assertEquals("12345", id);
        verify(publisher).publish(search);
        verify(save).save(search);
    }
}
