package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies copyright-message-related requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class CopyrightMessageService {

  private final IllClient illClient;

  /**
   * Searches copyright messages with the supplied criteria.
   */
  public Object findCopyrightMessages(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getCopyrightMessage(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  /**
   * Creates a new copyright message record.
   */
  public Object createCopyrightMessage(Object body) {
    return illClient.postCopyrightMessage(null, null, null, null, null, null, null, null, null, body);
  }

  /**
   * Returns the copyright message record identified by the supplied id.
   */
  public Object getCopyrightMessageById(String id) {
    return illClient.getCopyrightMessageById(id);
  }

  /**
   * Deletes the copyright message record identified by the supplied id.
   */
  public Object deleteCopyrightMessageById(String id) {
    return illClient.deleteCopyrightMessageById(id);
  }

  /**
   * Updates the copyright message record identified by the supplied id.
   */
  public Object putCopyrightMessageById(String id, Object body) {
    return illClient.putCopyrightMessageById(id, body);
  }

  /**
   * Returns the details required for creating or editing copyright messages.
   */
  public Object copyrightMessageCreateEditDetails() {
    return illClient.getCopyrightMessageCreateEditDetails(null, null, null, null, null, null, null, null, null);
  }
}
