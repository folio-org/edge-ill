package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service for the RemoteAction domain, delegating CRUD, search and execution operations
 * to mod-ill via {@link IllClient}.
 */
@Service
@RequiredArgsConstructor
public class RemoteActionService {

  private final IllClient illClient;

  /**
   * Searches for remote action records matching the supplied criteria.
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
   * @return matching remote action records from mod-ill
   */
  public Object findRemoteActions(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getRemoteAction(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  /**
   * Creates a new remote action record.
   *
   * @param body the remote action data
   * @return the created remote action response from mod-ill
   */
  public Object createRemoteAction(Object body) {
    return illClient.postRemoteAction(null, null, null, null, null, null, null, null, null, body);
  }

  /**
   * Retrieves a remote action by its identifier.
   *
   * @param id the remote action identifier
   * @return the remote action record from mod-ill
   */
  public Object getRemoteActionById(String id) {
    return illClient.getRemoteActionById(id);
  }

  /**
   * Deletes a remote action by its identifier.
   *
   * @param id the remote action identifier
   * @return the deletion response from mod-ill
   */
  public Object deleteRemoteActionById(String id) {
    return illClient.deleteRemoteActionById(id);
  }

  /**
   * Updates a remote action by its identifier.
   *
   * @param id   the remote action identifier
   * @param body the updated remote action data
   * @return the update response from mod-ill
   */
  public Object putRemoteActionById(String id, Object body) {
    return illClient.putRemoteActionById(id, body);
  }

  /**
   * Performs the specified remote action. The tenantId from the API path is intentionally ignored;
   * only the remote action identifier is used.
   *
   * @param id the remote action identifier
   * @return the execution response from mod-ill
   */
  public Object performRemoteAction(String id) {
    return illClient.getRemoteActionByIdPerform(id);
  }
}
