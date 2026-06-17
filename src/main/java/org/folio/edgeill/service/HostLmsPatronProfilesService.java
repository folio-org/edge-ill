package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies host LMS patron profiles requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class HostLmsPatronProfilesService {

  private final IllClient illClient;

  public Object find(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getHostLmspatronProfiles(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object create(Object body) {
    return illClient.postHostLmspatronProfiles(null, null, null, null, null, null, null, null, null, body);
  }

  public Object getById(String id) {
    return illClient.getHostLmspatronProfilesById(id);
  }

  public Object deleteById(String id) {
    return illClient.deleteHostLmspatronProfilesById(id);
  }

  public Object updateProfilesById(String id, Object body) {
    return illClient.putHostLmspatronProfilesById(id, body);
  }
}
