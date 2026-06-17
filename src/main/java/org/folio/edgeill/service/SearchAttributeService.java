package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service for the SearchAttribute domain, delegating CRUD and search operations to mod-ill
 * via {@link IllClient}.
 */
@Service
@RequiredArgsConstructor
public class SearchAttributeService {

  private final IllClient illClient;

  /**
   * Searches for search attribute records matching the supplied criteria.
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
   * @return matching search attribute records from mod-ill
   */
  public Object findSearchAttributes(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getSearchAttribute(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  /**
   * Creates a new search attribute record.
   *
   * @param body the search attribute data
   * @return the created search attribute response from mod-ill
   */
  public Object createSearchAttribute(Object body) {
    return illClient.postSearchAttribute(null, null, null, null, null, null, null, null, null, body);
  }

  /**
   * Retrieves a search attribute by its identifier.
   *
   * @param id the search attribute identifier
   * @return the search attribute record from mod-ill
   */
  public Object getSearchAttributeById(String id) {
    return illClient.getSearchAttributeById(id);
  }

  /**
   * Deletes a search attribute by its identifier.
   *
   * @param id the search attribute identifier
   * @return the deletion response from mod-ill
   */
  public Object deleteSearchAttributeById(String id) {
    return illClient.deleteSearchAttributeById(id);
  }

  /**
   * Updates a search attribute by its identifier.
   *
   * @param id   the search attribute identifier
   * @param body the updated search attribute data
   * @return the update response from mod-ill
   */
  public Object putSearchAttributeById(String id, Object body) {
    return illClient.putSearchAttributeById(id, body);
  }
}
