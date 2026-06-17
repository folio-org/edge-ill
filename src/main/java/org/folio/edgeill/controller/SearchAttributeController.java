package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.SearchAttributeApi;
import org.folio.edgeill.service.SearchAttributeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SearchAttributeController implements SearchAttributeApi {

  private final SearchAttributeService searchAttributeService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findSearchAttributes(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) searchAttributeService.findSearchAttributes(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createSearchAttribute(Object body) {
    return (ResponseEntity<Void>) searchAttributeService.createSearchAttribute(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getSearchAttributeById(String id) {
    return (ResponseEntity<Void>) searchAttributeService.getSearchAttributeById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteSearchAttributeById(String id) {
    return (ResponseEntity<Void>) searchAttributeService.deleteSearchAttributeById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putSearchAttributeById(String id, Object body) {
    return (ResponseEntity<Void>) searchAttributeService.putSearchAttributeById(id, body);
  }
}
