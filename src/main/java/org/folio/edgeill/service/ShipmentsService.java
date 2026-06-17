package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies shipments-related requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class ShipmentsService {

  private final IllClient illClient;

  public Object findShipmentses(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getShipments(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object createShipments(Object body) {
    return illClient.postShipments(null, null, null, null, null, null, null, null, null, body);
  }

  public Object getShipmentsById(String id) {
    return illClient.getShipmentsById(id);
  }

  public Object deleteShipmentsById(String id) {
    return illClient.deleteShipmentsById(id);
  }

  public Object putShipmentsById(String id, Object body) {
    return illClient.putShipmentsById(id, body);
  }
}
