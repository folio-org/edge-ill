package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.ProtocolApi;
import org.folio.edgeill.service.ProtocolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProtocolController implements ProtocolApi {

  private final ProtocolService protocolService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findProtocols(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) protocolService.findProtocols(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createProtocol(Object body) {
    return (ResponseEntity<Void>) protocolService.createProtocol(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getProtocolById(String id) {
    return (ResponseEntity<Void>) protocolService.getProtocolById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteProtocolById(String id) {
    return (ResponseEntity<Void>) protocolService.deleteProtocolById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putProtocolById(String id, Object body) {
    return (ResponseEntity<Void>) protocolService.putProtocolById(id, body);
  }
}
