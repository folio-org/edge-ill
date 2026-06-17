package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service for the Logging domain, delegating log-level query requests to mod-ill via {@link IllClient}.
 */
@Service
@RequiredArgsConstructor
public class LoggingService {

  private final IllClient illClient;

  /**
   * Retrieves logging configuration entries matching the supplied search criteria.
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
   * @return the logging records from mod-ill
   */
  public Object findLoggings(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getLogging(term, match, filters, sort, max, perPage, offset, page, stats);
  }
}
