package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies directory groups (plural) requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class DirectoryGroupsService {

  private final IllClient illClient;

  public Object findDirectoryGroupses(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getDirectoryGroups(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object createDirectoryGroups(Object body) {
    return illClient.postDirectoryGroups(null, null, null, null, null, null, null, null, null, body);
  }

  public Object getDirectoryGroupsById(String id) {
    return illClient.getDirectoryGroupsById(id);
  }

  public Object deleteDirectoryGroupsById(String id) {
    return illClient.deleteDirectoryGroupsById(id);
  }

  public Object putDirectoryGroupsById(String id, Object body) {
    return illClient.putDirectoryGroupsById(id, body);
  }

  public Object directoryGroupsModifyMembers(String id) {
    return illClient.getDirectoryGroupsByIdModifyMembers(id);
  }
}
