package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies institution group requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class InstitutionGroupService {

  private final IllClient illClient;

  public Object findInstitutionGroups(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getInstitutionGroup(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object createInstitutionGroup(Object body) {
    return illClient.postInstitutionGroup(null, null, null, null, null, null, null, null, null, body);
  }

  public Object getInstitutionGroupById(String id) {
    return illClient.getInstitutionGroupById(id);
  }

  public Object deleteInstitutionGroupById(String id) {
    return illClient.deleteInstitutionGroupById(id);
  }

  public Object putInstitutionGroupById(String id, Object body) {
    return illClient.putInstitutionGroupById(id, body);
  }

  public Object institutionGroupCreateEditDetails() {
    return illClient.getInstitutionGroupCreateEditDetails(null, null, null, null, null, null, null, null, null);
  }

  public Object institutionGroupModifyInstitutions(String id) {
    return illClient.getInstitutionGroupByIdModifyInstitutions(id);
  }

  public Object institutionGroupModifyUsers(String id) {
    return illClient.getInstitutionGroupByIdModifyUsers(id);
  }
}
