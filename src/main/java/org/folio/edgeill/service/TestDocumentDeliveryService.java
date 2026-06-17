package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies test-document-delivery requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class TestDocumentDeliveryService {

  private final IllClient illClient;

  public Object testOffer(Object body) {
    return illClient.postTestDocumentDeliveryOffer(null, null, null, null, null, null, null, null, null, body);
  }

  public Object testRegister(Object body) {
    return illClient.postTestDocumentDeliveryRegister(null, null, null, null, null, null, null, null, null, body);
  }
}
