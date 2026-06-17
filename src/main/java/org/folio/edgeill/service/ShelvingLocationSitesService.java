package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies shelving-location-sites-related requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class ShelvingLocationSitesService {

  private final IllClient illClient;

  public Object findShelvingLocationSiteses(String term, String match, String filters,
      String sort, Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getShelvingLocationSites(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object createShelvingLocationSites(Object body) {
    return illClient.postShelvingLocationSites(null, null, null, null, null, null, null, null, null, body);
  }

  public Object getShelvingLocationSitesById(String id) {
    return illClient.getShelvingLocationSitesById(id);
  }

  public Object deleteShelvingLocationSitesById(String id) {
    return illClient.deleteShelvingLocationSitesById(id);
  }

  public Object putShelvingLocationSitesById(String id, Object body) {
    return illClient.putShelvingLocationSitesById(id, body);
  }
}
