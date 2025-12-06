package com.avoris.tec.hotelsearch.application;

import com.avoris.tec.hotelsearch.domain.ports.out.CountSearchPort;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@org.junit.jupiter.api.extension.ExtendWith(MockitoExtension.class)
class SearchQueryServiceImplTest {

    @Mock
    private CountSearchPort countPort;

    @InjectMocks
    private SearchQueryServiceImpl service;

    @Test
    void shouldReturnTotalSearches() {
        // Arrange
        when(countPort.count()).thenReturn(5L);

        // Act
        long result = service.countSearches();

        // Assert
        assertEquals(5L, result);
        verify(countPort, times(1)).count();
    }
}
