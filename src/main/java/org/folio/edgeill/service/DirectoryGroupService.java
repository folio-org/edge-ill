package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies directory group requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class DirectoryGroupService {

  private final IllClient illClient;

  public Object findDirectoryGroups(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getDirectoryGroup(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object createDirectoryGroup(Object body) {
    return illClient.postDirectoryGroup(null, null, null, null, null, null, null, null, null, body);
  }

  public Object getDirectoryGroupById(String id) {
    return illClient.getDirectoryGroupById(id);
  }

  public Object deleteDirectoryGroupById(String id) {
    return illClient.deleteDirectoryGroupById(id);
  }

  public Object putDirectoryGroupById(String id, Object body) {
    return illClient.putDirectoryGroupById(id, body);
  }

  public Object directoryGroupModifyMembers(String id) {
    return illClient.getDirectoryGroupByIdModifyMembers(id);
  }
}
