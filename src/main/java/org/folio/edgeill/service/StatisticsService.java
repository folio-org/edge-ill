package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies statistics-related requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class StatisticsService {

  private final IllClient illClient;

  public Object findStatisticses(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getStatistics(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object statisticsForSymbol() {
    return illClient.getStatisticsForSymbol(null, null, null, null, null, null, null, null, null);
  }
}
