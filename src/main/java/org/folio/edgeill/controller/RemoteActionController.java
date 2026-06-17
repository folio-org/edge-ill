package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.RemoteActionApi;
import org.folio.edgeill.service.RemoteActionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RemoteActionController implements RemoteActionApi {

  private final RemoteActionService remoteActionService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findRemoteActions(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) remoteActionService.findRemoteActions(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createRemoteAction(Object body) {
    return (ResponseEntity<Void>) remoteActionService.createRemoteAction(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getRemoteActionById(String id) {
    return (ResponseEntity<Void>) remoteActionService.getRemoteActionById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteRemoteActionById(String id) {
    return (ResponseEntity<Void>) remoteActionService.deleteRemoteActionById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putRemoteActionById(String id, Object body) {
    return (ResponseEntity<Void>) remoteActionService.putRemoteActionById(id, body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> performRemoteAction(String tenantId, String id) {
    return (ResponseEntity<Void>) remoteActionService.performRemoteAction(id);
  }
}
