package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies timers-related requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class TimersService {

  private final IllClient illClient;

  public Object findTimerses(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getTimers(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object createTimers(Object body) {
    return illClient.postTimers(null, null, null, null, null, null, null, null, null, body);
  }

  public Object getTimersById(String id) {
    return illClient.getTimersById(id);
  }

  public Object deleteTimersById(String id) {
    return illClient.deleteTimersById(id);
  }

  public Object putTimersById(String id, Object body) {
    return illClient.putTimersById(id, body);
  }

  public Object timersExecute() {
    return illClient.getTimersExecute(null, null, null, null, null, null, null, null, null);
  }
}
