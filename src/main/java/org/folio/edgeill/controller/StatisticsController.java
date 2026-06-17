package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.folio.edgeill.rest.resource.StatisticsApi;
import org.folio.edgeill.service.StatisticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for statistics endpoints. Delegates to {@link IllClient} via {@link StatisticsService}.
 */
@RestController
@RequiredArgsConstructor
public class StatisticsController implements StatisticsApi {

  private final StatisticsService statisticsService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findStatisticses(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) statisticsService.findStatisticses(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> statisticsForSymbol() {
    return (ResponseEntity<Void>) statisticsService.statisticsForSymbol();
  }
}
