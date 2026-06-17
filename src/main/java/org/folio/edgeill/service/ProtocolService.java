package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service for the Protocol domain, delegating CRUD and search operations to mod-ill
 * via {@link IllClient}.
 */
@Service
@RequiredArgsConstructor
public class ProtocolService {

  private final IllClient illClient;

  /**
   * Searches for protocol records matching the supplied criteria.
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
   * @return matching protocol records from mod-ill
   */
  public Object findProtocols(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getProtocol(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  /**
   * Creates a new protocol record.
   *
   * @param body the protocol data
   * @return the created protocol response from mod-ill
   */
  public Object createProtocol(Object body) {
    return illClient.postProtocol(null, null, null, null, null, null, null, null, null, body);
  }

  /**
   * Retrieves a protocol by its identifier.
   *
   * @param id the protocol identifier
   * @return the protocol record from mod-ill
   */
  public Object getProtocolById(String id) {
    return illClient.getProtocolById(id);
  }

  /**
   * Deletes a protocol by its identifier.
   *
   * @param id the protocol identifier
   * @return the deletion response from mod-ill
   */
  public Object deleteProtocolById(String id) {
    return illClient.deleteProtocolById(id);
  }

  /**
   * Updates a protocol by its identifier.
   *
   * @param id   the protocol identifier
   * @param body the updated protocol data
   * @return the update response from mod-ill
   */
  public Object putProtocolById(String id, Object body) {
    return illClient.putProtocolById(id, body);
  }
}
