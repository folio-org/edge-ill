package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies test-external-search requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class TestExternalSearchService {

  private final IllClient illClient;

  public Object testExternalSearchLocate() {
    return illClient.getTestExternalSearchLocate(null, null, null, null, null, null, null, null, null);
  }

  public Object testExternalSearchPerformSearch() {
    return illClient.getTestExternalSearchPerformSearch(null, null, null, null, null, null, null, null, null);
  }
}
