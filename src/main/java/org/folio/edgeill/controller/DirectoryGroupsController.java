package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.DirectoryGroupsApi;
import org.folio.edgeill.service.DirectoryGroupsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DirectoryGroupsController implements DirectoryGroupsApi {

  private final DirectoryGroupsService directoryGroupsService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findDirectoryGroupses(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) directoryGroupsService.findDirectoryGroupses(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createDirectoryGroups(Object body) {
    return (ResponseEntity<Void>) directoryGroupsService.createDirectoryGroups(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getDirectoryGroupsById(String id) {
    return (ResponseEntity<Void>) directoryGroupsService.getDirectoryGroupsById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteDirectoryGroupsById(String id) {
    return (ResponseEntity<Void>) directoryGroupsService.deleteDirectoryGroupsById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putDirectoryGroupsById(String id, Object body) {
    return (ResponseEntity<Void>) directoryGroupsService.putDirectoryGroupsById(id, body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> directoryGroupsModifyMembers(String id) {
    return (ResponseEntity<Void>) directoryGroupsService.directoryGroupsModifyMembers(id);
  }
}
