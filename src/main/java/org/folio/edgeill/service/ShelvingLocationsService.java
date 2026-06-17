package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies shelving-locations-related requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class ShelvingLocationsService {

  private final IllClient illClient;

  public Object findShelvingLocationses(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getShelvingLocations(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object createShelvingLocations(Object body) {
    return illClient.postShelvingLocations(null, null, null, null, null, null, null, null, null, body);
  }

  public Object getShelvingLocationsById(String id) {
    return illClient.getShelvingLocationsById(id);
  }

  public Object deleteShelvingLocationsById(String id) {
    return illClient.deleteShelvingLocationsById(id);
  }

  public Object putShelvingLocationsById(String id, Object body) {
    return illClient.putShelvingLocationsById(id, body);
  }
}
