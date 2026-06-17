package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.TestExternalSearchApi;
import org.folio.edgeill.service.TestExternalSearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestExternalSearchController implements TestExternalSearchApi {

  private final TestExternalSearchService testExternalSearchService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> testExternalSearchLocate() {
    return (ResponseEntity<Void>) testExternalSearchService.testExternalSearchLocate();
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> testExternalSearchPerformSearch() {
    return (ResponseEntity<Void>) testExternalSearchService.testExternalSearchPerformSearch();
  }
}
