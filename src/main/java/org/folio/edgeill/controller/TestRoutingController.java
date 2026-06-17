package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.TestRoutingApi;
import org.folio.edgeill.service.TestRoutingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestRoutingController implements TestRoutingApi {

  private final TestRoutingService testRoutingService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> testRoutingFindMoreSuppliers() {
    return (ResponseEntity<Void>) testRoutingService.testRoutingFindMoreSuppliers();
  }
}
