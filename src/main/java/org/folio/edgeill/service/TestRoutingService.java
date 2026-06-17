package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies test-routing requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class TestRoutingService {

  private final IllClient illClient;

  public Object testRoutingFindMoreSuppliers() {
    return illClient.getTestRoutingFindMoreSuppliers(null, null, null, null, null, null, null, null, null);
  }
}
