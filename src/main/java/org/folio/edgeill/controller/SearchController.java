package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.SearchApi;
import org.folio.edgeill.service.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SearchController implements SearchApi {

  private final SearchService searchService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findSearches(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) searchService.findSearches(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createSearch(Object body) {
    return (ResponseEntity<Void>) searchService.createSearch(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getSearchById(String id) {
    return (ResponseEntity<Void>) searchService.getSearchById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteSearchById(String id) {
    return (ResponseEntity<Void>) searchService.deleteSearchById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putSearchById(String id, Object body) {
    return (ResponseEntity<Void>) searchService.putSearchById(id, body);
  }
}
