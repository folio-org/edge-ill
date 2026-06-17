package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.DirectoryGroupApi;
import org.folio.edgeill.service.DirectoryGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DirectoryGroupController implements DirectoryGroupApi {

  private final DirectoryGroupService directoryGroupService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findDirectoryGroups(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) directoryGroupService.findDirectoryGroups(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createDirectoryGroup(Object body) {
    return (ResponseEntity<Void>) directoryGroupService.createDirectoryGroup(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getDirectoryGroupById(String id) {
    return (ResponseEntity<Void>) directoryGroupService.getDirectoryGroupById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteDirectoryGroupById(String id) {
    return (ResponseEntity<Void>) directoryGroupService.deleteDirectoryGroupById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putDirectoryGroupById(String id, Object body) {
    return (ResponseEntity<Void>) directoryGroupService.putDirectoryGroupById(id, body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> directoryGroupModifyMembers(String id) {
    return (ResponseEntity<Void>) directoryGroupService.directoryGroupModifyMembers(id);
  }
}
