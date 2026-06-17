package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.DocumentDeliveryServerApi;
import org.folio.edgeill.service.DocumentDeliveryServerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DocumentDeliveryServerController implements DocumentDeliveryServerApi {

  private final DocumentDeliveryServerService documentDeliveryServerService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findDocumentDeliveryServers(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) documentDeliveryServerService.find(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getDocumentDeliveryServerById(String id) {
    return (ResponseEntity<Void>) documentDeliveryServerService.getById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> documentDeliveryServerCreateEditDetails() {
    return (ResponseEntity<Void>) documentDeliveryServerService.documentDeliveryServerCreateEditDetails();
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> documentDeliveryServerRegister(Object body) {
    return (ResponseEntity<Void>) documentDeliveryServerService.documentDeliveryServerRegister(body);
  }
}
