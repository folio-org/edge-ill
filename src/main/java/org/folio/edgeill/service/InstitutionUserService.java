package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies institution user requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class InstitutionUserService {

  private final IllClient illClient;

  public Object findInstitutionUsers(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getInstitutionUser(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object createInstitutionUser(Object body) {
    return illClient.postInstitutionUser(null, null, null, null, null, null, null, null, null, body);
  }

  public Object getInstitutionUserById(String id) {
    return illClient.getInstitutionUserById(id);
  }

  public Object deleteInstitutionUserById(String id) {
    return illClient.deleteInstitutionUserById(id);
  }

  public Object putInstitutionUserById(String id, Object body) {
    return illClient.putInstitutionUserById(id, body);
  }

  public Object institutionUserCanManage() {
    return illClient.getInstitutionUserCanManage(null, null, null, null, null, null, null, null, null);
  }

  public Object institutionUserCreateEditDetails() {
    return illClient.getInstitutionUserCreateEditDetails(null, null, null, null, null, null, null, null, null);
  }

  public Object institutionUserManageInstitution() {
    return illClient.getInstitutionUserManageInstitution(null, null, null, null, null, null, null, null, null);
  }

  public Object institutionUserInstitutions(String id) {
    return illClient.getInstitutionUserByIdInstitutions(id);
  }

  public Object institutionUserModifyGroups(String id) {
    return illClient.getInstitutionUserByIdModifyGroups(id);
  }
}
