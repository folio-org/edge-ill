package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service for the Refdata domain, delegating CRUD, search and property lookup operations
 * to mod-ill via {@link IllClient}.
 */
@Service
@RequiredArgsConstructor
public class RefdataService {

  private final IllClient illClient;

  /**
   * Searches for refdata records matching the supplied criteria.
   *
   * @param term     search term
   * @param match    match mode
   * @param filters  filter expression
   * @param sort     sort field
   * @param max      maximum number of results
   * @param perPage  results per page
   * @param offset   result offset
   * @param page     page number
   * @param stats    whether to include statistics
   * @return matching refdata records from mod-ill
   */
  public Object findRefdatas(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getRefdata(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  /**
   * Creates a new refdata record.
   *
   * @param body the refdata entry
   * @return the created refdata response from mod-ill
   */
  public Object createRefdata(Object body) {
    return illClient.postRefdata(null, null, null, null, null, null, null, null, null, body);
  }

  /**
   * Retrieves a refdata record by its identifier.
   *
   * @param id the refdata identifier
   * @return the refdata record from mod-ill
   */
  public Object getRefdataById(String id) {
    return illClient.getRefdataById(id);
  }

  /**
   * Deletes a refdata record by its identifier.
   *
   * @param id the refdata identifier
   * @return the deletion response from mod-ill
   */
  public Object deleteRefdataById(String id) {
    return illClient.deleteRefdataById(id);
  }

  /**
   * Updates a refdata record by its identifier.
   *
   * @param id   the refdata identifier
   * @param body the updated refdata data
   * @return the update response from mod-ill
   */
  public Object putRefdataById(String id, Object body) {
    return illClient.putRefdataById(id, body);
  }

  /**
   * Returns all category values for the supplied domain and property.
   *
   * @param id       the refdata domain identifier
   * @param property the property name
   * @return the refdata property values from mod-ill
   */
  public Object refdataByIdProperty(String id, String property) {
    return illClient.getRefdataByIdByProperty(id, property);
  }
}
