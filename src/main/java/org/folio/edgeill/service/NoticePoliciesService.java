package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service for the NoticePolicies domain, delegating CRUD and search operations to mod-ill
 * via {@link IllClient}.
 */
@Service
@RequiredArgsConstructor
public class NoticePoliciesService {

  private final IllClient illClient;

  /**
   * Searches for notice policies matching the supplied criteria.
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
   * @return matching notice policy records from mod-ill
   */
  public Object search(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getNoticePolicies(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  /**
   * Creates a new notice policy record.
   *
   * @param body the notice policy data
   * @return the created notice policy response from mod-ill
   */
  public Object create(Object body) {
    return illClient.postNoticePolicies(null, null, null, null, null, null, null, null, null, body);
  }

  /**
   * Retrieves a notice policy by its identifier.
   *
   * @param id the notice policy identifier
   * @return the notice policy record from mod-ill
   */
  public Object getNoticePoliciesById(String id) {
    return illClient.getNoticePoliciesById(id);
  }

  /**
   * Deletes a notice policy by its identifier.
   *
   * @param id the notice policy identifier
   * @return the deletion response from mod-ill
   */
  public Object deleteNoticePoliciesById(String id) {
    return illClient.deleteNoticePoliciesById(id);
  }

  /**
   * Updates a notice policy by its identifier.
   *
   * @param id   the notice policy identifier
   * @param body the updated notice policy data
   * @return the update response from mod-ill
   */
  public Object putNoticePoliciesById(String id, Object body) {
    return illClient.putNoticePoliciesById(id, body);
  }
}
