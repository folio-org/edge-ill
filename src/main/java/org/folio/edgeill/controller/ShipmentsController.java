package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.ShipmentsApi;
import org.folio.edgeill.service.ShipmentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShipmentsController implements ShipmentsApi {

  private final ShipmentsService shipmentsService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findShipmentses(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) shipmentsService.findShipmentses(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createShipments(Object body) {
    return (ResponseEntity<Void>) shipmentsService.createShipments(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getShipmentsById(String id) {
    return (ResponseEntity<Void>) shipmentsService.getShipmentsById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteShipmentsById(String id) {
    return (ResponseEntity<Void>) shipmentsService.deleteShipmentsById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putShipmentsById(String id, Object body) {
    return (ResponseEntity<Void>) shipmentsService.putShipmentsById(id, body);
  }
}
