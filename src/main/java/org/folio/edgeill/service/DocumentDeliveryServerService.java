package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies document delivery server requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class DocumentDeliveryServerService {

  private final IllClient illClient;

  public Object find(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getDocumentDeliveryServer(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object getById(String id) {
    return illClient.getDocumentDeliveryServerById(id);
  }

  public Object documentDeliveryServerCreateEditDetails() {
    return illClient.getDocumentDeliveryServerCreateEditDetails(null, null, null, null, null, null, null, null, null);
  }

  public Object documentDeliveryServerRegister(Object body) {
    return illClient.postDocumentDeliveryServerRegister(null, null, null, null, null, null, null, null, null, body);
  }
}
