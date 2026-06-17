package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies institution requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class InstitutionService {

  private final IllClient illClient;

  public Object findInstitutions(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getInstitution(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object createInstitution(Object body) {
    return illClient.postInstitution(null, null, null, null, null, null, null, null, null, body);
  }

  public Object getInstitutionById(String id) {
    return illClient.getInstitutionById(id);
  }

  public Object deleteInstitutionById(String id) {
    return illClient.deleteInstitutionById(id);
  }

  public Object putInstitutionById(String id, Object body) {
    return illClient.putInstitutionById(id, body);
  }

  public Object institutionCreateEditDetails() {
    return illClient.getInstitutionCreateEditDetails(null, null, null, null, null, null, null, null, null);
  }

  public Object institutionModifyGroups(String id) {
    return illClient.getInstitutionByIdModifyGroups(id);
  }

  public Object institutionUsers(String id) {
    return illClient.getInstitutionByIdUsers(id);
  }
}
