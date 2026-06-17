package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.SearchTreeApi;
import org.folio.edgeill.service.SearchTreeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SearchTreeController implements SearchTreeApi {

  private final SearchTreeService searchTreeService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findSearchTrees(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) searchTreeService.findSearchTrees(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createSearchTree(Object body) {
    return (ResponseEntity<Void>) searchTreeService.createSearchTree(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getSearchTreeById(String id) {
    return (ResponseEntity<Void>) searchTreeService.getSearchTreeById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteSearchTreeById(String id) {
    return (ResponseEntity<Void>) searchTreeService.deleteSearchTreeById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putSearchTreeById(String id, Object body) {
    return (ResponseEntity<Void>) searchTreeService.putSearchTreeById(id, body);
  }
}
