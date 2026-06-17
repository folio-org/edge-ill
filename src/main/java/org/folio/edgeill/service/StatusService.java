package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies status-related requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class StatusService {

  private final IllClient illClient;

  public Object findStatuses(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getStatus(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object getStatusById(String id) {
    return illClient.getStatusById(id);
  }
}
