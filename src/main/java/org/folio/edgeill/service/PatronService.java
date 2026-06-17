package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service for the Patron domain, delegating CRUD, search and eligibility check operations
 * to mod-ill via {@link IllClient}.
 */
@Service
@RequiredArgsConstructor
public class PatronService {

  private final IllClient illClient;

  /**
   * Searches for patron records matching the supplied criteria.
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
   * @return matching patron records from mod-ill
   */
  public Object findPatrons(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getPatron(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  /**
   * Creates a new patron record.
   *
   * @param body the patron data
   * @return the created patron response from mod-ill
   */
  public Object createPatron(Object body) {
    return illClient.postPatron(null, null, null, null, null, null, null, null, null, body);
  }

  /**
   * Retrieves a patron by its identifier.
   *
   * @param id the patron identifier
   * @return the patron record from mod-ill
   */
  public Object getPatronById(String id) {
    return illClient.getPatronById(id);
  }

  /**
   * Deletes a patron by its identifier.
   *
   * @param id the patron identifier
   * @return the deletion response from mod-ill
   */
  public Object deletePatronById(String id) {
    return illClient.deletePatronById(id);
  }

  /**
   * Updates a patron by its identifier.
   *
   * @param id   the patron identifier
   * @param body the updated patron data
   * @return the update response from mod-ill
   */
  public Object putPatronById(String id, Object body) {
    return illClient.putPatronById(id, body);
  }

  /**
   * Checks whether a patron is allowed to create an ILL request.
   *
   * @param id the patron identifier
   * @return the eligibility check response from mod-ill
   */
  public Object patronCanCreateRequest(String id) {
    return illClient.getPatronByIdCanCreateRequest(id);
  }
}
