package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.LoggingApi;
import org.folio.edgeill.service.LoggingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoggingController implements LoggingApi {

  private final LoggingService loggingService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findLoggings(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return (ResponseEntity<Void>) loggingService.findLoggings(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }
}
