package com.avoris.tec.hotelsearch.domain.ports.in;

import com.avoris.tec.hotelsearch.domain.model.Search;

/** Puerto de entrada del dominio.
 * Define lo que el sistema permite hacer desde el exterior (ej: Controladores REST).
 */

public interface SearchService {

    /** Registra una nueva búsqueda de hotel.
     * @param search búsqueda a registrar
     * @return identificador de la búsqueda registrada
     */

    String registerSearch(Search search);
}
