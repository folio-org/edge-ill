package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service for the Search domain, delegating CRUD and search operations to mod-ill
 * via {@link IllClient}.
 */
@Service
@RequiredArgsConstructor
public class SearchService {

  private final IllClient illClient;

  /**
   * Searches for search records matching the supplied criteria.
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
   * @return matching search records from mod-ill
   */
  public Object findSearches(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getSearch(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  /**
   * Creates a new search record.
   *
   * @param body the search data
   * @return the created search response from mod-ill
   */
  public Object createSearch(Object body) {
    return illClient.postSearch(null, null, null, null, null, null, null, null, null, body);
  }

  /**
   * Retrieves a search record by its identifier.
   *
   * @param id the search identifier
   * @return the search record from mod-ill
   */
  public Object getSearchById(String id) {
    return illClient.getSearchById(id);
  }

  /**
   * Deletes a search record by its identifier.
   *
   * @param id the search identifier
   * @return the deletion response from mod-ill
   */
  public Object deleteSearchById(String id) {
    return illClient.deleteSearchById(id);
  }

  /**
   * Updates a search record by its identifier.
   *
   * @param id   the search identifier
   * @param body the updated search data
   * @return the update response from mod-ill
   */
  public Object putSearchById(String id, Object body) {
    return illClient.putSearchById(id, body);
  }
}
