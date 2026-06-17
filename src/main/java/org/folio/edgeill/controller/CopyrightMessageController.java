package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.CopyrightMessageApi;
import org.folio.edgeill.service.CopyrightMessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CopyrightMessageController implements CopyrightMessageApi {

  private final CopyrightMessageService copyrightMessageService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findCopyrightMessages(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return (ResponseEntity<Void>) copyrightMessageService.findCopyrightMessages(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createCopyrightMessage(Object body) {
    return (ResponseEntity<Void>) copyrightMessageService.createCopyrightMessage(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getCopyrightMessageById(String id) {
    return (ResponseEntity<Void>) copyrightMessageService.getCopyrightMessageById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteCopyrightMessageById(String id) {
    return (ResponseEntity<Void>) copyrightMessageService.deleteCopyrightMessageById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putCopyrightMessageById(String id, Object body) {
    return (ResponseEntity<Void>) copyrightMessageService.putCopyrightMessageById(id, body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> copyrightMessageCreateEditDetails() {
    return (ResponseEntity<Void>) copyrightMessageService.copyrightMessageCreateEditDetails();
  }
}
