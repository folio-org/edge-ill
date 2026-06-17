package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies shared-index-query requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class SharedIndexQueryService {

  private final IllClient illClient;

  public Object sharedIndexQuery() {
    return illClient.getSharedIndexQuery(null, null, null, null, null, null, null, null, null);
  }

  public Object sharedIndexQueryAvailability() {
    return illClient.getSharedIndexQueryAvailability(null, null, null, null, null, null, null, null, null);
  }

  public Object sharedIndexQueryById() {
    return illClient.getSharedIndexQueryById(null, null, null, null, null, null, null, null, null);
  }

  public Object sharedIndexQueryByQuery() {
    return illClient.getSharedIndexQueryByQuery(null, null, null, null, null, null, null, null, null);
  }

  public Object sharedIndexQueryFindMoreSuppliers() {
    return illClient.getSharedIndexQueryFindMoreSuppliers(null, null, null, null, null, null, null, null, null);
  }

  public Object sharedIndexQueryToken(Object body) {
    return illClient.postSharedIndexQueryToken(null, null, null, null, null, null, null, null, null, body);
  }
}
