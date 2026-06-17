package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.SharedIndexQueryApi;
import org.folio.edgeill.service.SharedIndexQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SharedIndexQueryController implements SharedIndexQueryApi {

  private final SharedIndexQueryService sharedIndexQueryService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> sharedIndexQuery() {
    return (ResponseEntity<Void>) sharedIndexQueryService.sharedIndexQuery();
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> sharedIndexQueryAvailability() {
    return (ResponseEntity<Void>) sharedIndexQueryService.sharedIndexQueryAvailability();
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> sharedIndexQueryById() {
    return (ResponseEntity<Void>) sharedIndexQueryService.sharedIndexQueryById();
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> sharedIndexQueryByQuery() {
    return (ResponseEntity<Void>) sharedIndexQueryService.sharedIndexQueryByQuery();
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> sharedIndexQueryFindMoreSuppliers() {
    return (ResponseEntity<Void>) sharedIndexQueryService.sharedIndexQueryFindMoreSuppliers();
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> sharedIndexQueryToken(Object body) {
    return (ResponseEntity<Void>) sharedIndexQueryService.sharedIndexQueryToken(body);
  }
}
