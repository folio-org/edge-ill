package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.IllSmtpMessageApi;
import org.folio.edgeill.service.IllSmtpMessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IllSmtpMessageController implements IllSmtpMessageApi {

  private final IllSmtpMessageService illSmtpMessageService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findIllSmtpMessages(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return (ResponseEntity<Void>) illSmtpMessageService.findIllSmtpMessages(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createIllSmtpMessage(Object body) {
    return (ResponseEntity<Void>) illSmtpMessageService.createIllSmtpMessage(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getIllSmtpMessageById(String id) {
    return (ResponseEntity<Void>) illSmtpMessageService.getIllSmtpMessageById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteIllSmtpMessageById(String id) {
    return (ResponseEntity<Void>) illSmtpMessageService.deleteIllSmtpMessageById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putIllSmtpMessageById(String id, Object body) {
    return (ResponseEntity<Void>) illSmtpMessageService.putIllSmtpMessageById(id, body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> illSmtpMessageCreateEditDetails() {
    return (ResponseEntity<Void>) illSmtpMessageService.illSmtpMessageCreateEditDetails();
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> illSmtpMessageTokenValuesById(String id) {
    return (ResponseEntity<Void>) illSmtpMessageService.illSmtpMessageTokenValuesById(id);
  }
}
