package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.SearchGroupApi;
import org.folio.edgeill.service.SearchGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SearchGroupController implements SearchGroupApi {

  private final SearchGroupService searchGroupService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findSearchGroups(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) searchGroupService.findSearchGroups(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createSearchGroup(Object body) {
    return (ResponseEntity<Void>) searchGroupService.createSearchGroup(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getSearchGroupById(String id) {
    return (ResponseEntity<Void>) searchGroupService.getSearchGroupById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteSearchGroupById(String id) {
    return (ResponseEntity<Void>) searchGroupService.deleteSearchGroupById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putSearchGroupById(String id, Object body) {
    return (ResponseEntity<Void>) searchGroupService.putSearchGroupById(id, body);
  }
}
