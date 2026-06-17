package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.folio.edgeill.rest.resource.TestDocumentDeliveryApi;
import org.folio.edgeill.service.TestDocumentDeliveryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for test-document-delivery endpoints. Delegates to {@link IllClient}
 * via {@link TestDocumentDeliveryService}.
 */
@RestController
@RequiredArgsConstructor
public class TestDocumentDeliveryController implements TestDocumentDeliveryApi {

  private final TestDocumentDeliveryService testDocumentDeliveryService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> testOffer(String tenantId, Object body) {
    return (ResponseEntity<Void>) testDocumentDeliveryService.testOffer(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> testRegister(String tenantId, Object body) {
    return (ResponseEntity<Void>) testDocumentDeliveryService.testRegister(body);
  }
}
