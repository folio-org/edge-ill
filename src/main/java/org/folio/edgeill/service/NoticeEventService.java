package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service for the NoticeEvent domain, delegating CRUD and search operations to mod-ill
 * via {@link IllClient}.
 */
@Service
@RequiredArgsConstructor
public class NoticeEventService {

  private final IllClient illClient;

  /**
   * Searches for notice events matching the supplied criteria.
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
   * @return matching notice event records from mod-ill
   */
  public Object findNoticeEvents(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getNoticeEvent(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  /**
   * Creates a new notice event record.
   *
   * @param body the notice event data
   * @return the created notice event response from mod-ill
   */
  public Object createNoticeEvent(Object body) {
    return illClient.postNoticeEvent(null, null, null, null, null, null, null, null, null, body);
  }

  /**
   * Retrieves a notice event by its identifier.
   *
   * @param id the notice event identifier
   * @return the notice event record from mod-ill
   */
  public Object getNoticeEventById(String id) {
    return illClient.getNoticeEventById(id);
  }

  /**
   * Deletes a notice event by its identifier.
   *
   * @param id the notice event identifier
   * @return the deletion response from mod-ill
   */
  public Object deleteNoticeEventById(String id) {
    return illClient.deleteNoticeEventById(id);
  }

  /**
   * Updates a notice event by its identifier.
   *
   * @param id   the notice event identifier
   * @param body the updated notice event data
   * @return the update response from mod-ill
   */
  public Object putNoticeEventById(String id, Object body) {
    return illClient.putNoticeEventById(id, body);
  }
}
