package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies swagger-related requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class SwaggerService {

  private final IllClient illClient;

  public Object getSwagger(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getSwagger(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object getSwaggerApi(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getSwaggerApi(term, match, filters, sort, max, perPage, offset, page, stats);
  }
}
