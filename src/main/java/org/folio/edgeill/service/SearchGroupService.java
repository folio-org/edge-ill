package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies search-group-related requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class SearchGroupService {

  private final IllClient illClient;

  public Object findSearchGroups(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getSearchGroup(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object createSearchGroup(Object body) {
    return illClient.postSearchGroup(null, null, null, null, null, null, null, null, null, body);
  }

  public Object getSearchGroupById(String id) {
    return illClient.getSearchGroupById(id);
  }

  public Object deleteSearchGroupById(String id) {
    return illClient.deleteSearchGroupById(id);
  }

  public Object putSearchGroupById(String id, Object body) {
    return illClient.putSearchGroupById(id, body);
  }
}
