package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies custom properties (custprops) requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class CustomPropertiesService {

  private final IllClient illClient;

  /**
   * Searches custom properties with the supplied criteria.
   */
  public Object search(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getCustomProperties(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  /**
   * Creates a new custom properties record.
   */
  public Object create(Object body) {
    return illClient.postCustprops(null, null, null, null, null, null, null, null, null, body);
  }

  /**
   * Returns the custom properties record identified by the supplied id.
   */
  public Object getById(String id) {
    return illClient.getCustomPropertiesById(id);
  }

  /**
   * Deletes the custom properties record identified by the supplied id.
   */
  public void deleteById(String id) {
    illClient.deleteCustomPropertiesById(id);
  }

  /**
   * Updates the custom properties record identified by the supplied id.
   */
  public Object update(String id, Object body) {
    return illClient.putCustomPropertiesById(id, body);
  }
}
