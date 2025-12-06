package com.avoris.tec.hotelsearch.domain.ports.out;

import com.avoris.tec.hotelsearch.domain.model.Search;

/** Puerto de salida para publicar mensajes en Kafka.
 *  El dominio lo define como una necesidad, pero no sabe cómo se implementa
 */

public interface KafkaPublisherPort {

    /**
     * Publica una búsqueda en Kafka.
     * @param search objeto de búsqueda
     */

    void publish(Search search);
}

