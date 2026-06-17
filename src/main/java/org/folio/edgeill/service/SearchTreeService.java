package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies search-tree-related requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class SearchTreeService {

  private final IllClient illClient;

  public Object findSearchTrees(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getSearchTree(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object createSearchTree(Object body) {
    return illClient.postSearchTree(null, null, null, null, null, null, null, null, null, body);
  }

  public Object getSearchTreeById(String id) {
    return illClient.getSearchTreeById(id);
  }

  public Object deleteSearchTreeById(String id) {
    return illClient.deleteSearchTreeById(id);
  }

  public Object putSearchTreeById(String id, Object body) {
    return illClient.putSearchTreeById(id, body);
  }
}
