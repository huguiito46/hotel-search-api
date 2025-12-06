package com.avoris.tec.hotelsearch.domain.ports.out;

import com.avoris.tec.hotelsearch.domain.model.Search;

/** Puerto de salida para guardar una búsqueda.
 * El dominio declara que necesita guardar una búsqueda, pero no le importa dónde.
 */
public interface SaveSearchPort {

    /** Guarda una búsqueda de hotel.
     * @param search objeto a guardar
     * @return identificador generado
     */
    String save(Search search);

}