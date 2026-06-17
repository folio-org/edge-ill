package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies tags-related requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class TagsService {

  private final IllClient illClient;

  public Object findTagses(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getTags(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object createTags(Object body) {
    return illClient.postTags(null, null, null, null, null, null, null, null, null, body);
  }

  public Object getTagsById(String id) {
    return illClient.getTagsById(id);
  }

  public Object deleteTagsById(String id) {
    return illClient.deleteTagsById(id);
  }

  public Object putTagsById(String id, Object body) {
    return illClient.putTagsById(id, body);
  }
}
