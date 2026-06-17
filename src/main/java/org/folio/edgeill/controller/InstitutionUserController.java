package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.folio.edgeill.rest.resource.InstitutionUserApi;
import org.folio.edgeill.service.InstitutionUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for institution user endpoints. Delegates to {@link IllClient} via {@link InstitutionUserService}.
 */
@RestController
@RequiredArgsConstructor
public class InstitutionUserController implements InstitutionUserApi {

  private final InstitutionUserService institutionUserService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findInstitutionUsers(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) institutionUserService.findInstitutionUsers(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createInstitutionUser(Object body) {
    return (ResponseEntity<Void>) institutionUserService.createInstitutionUser(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getInstitutionUserById(String id) {
    return (ResponseEntity<Void>) institutionUserService.getInstitutionUserById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteInstitutionUserById(String id) {
    return (ResponseEntity<Void>) institutionUserService.deleteInstitutionUserById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putInstitutionUserById(String id, Object body) {
    return (ResponseEntity<Void>) institutionUserService.putInstitutionUserById(id, body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> institutionUserCanManage() {
    return (ResponseEntity<Void>) institutionUserService.institutionUserCanManage();
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> institutionUserCreateEditDetails() {
    return (ResponseEntity<Void>) institutionUserService.institutionUserCreateEditDetails();
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> institutionUserManageInstitution() {
    return (ResponseEntity<Void>) institutionUserService.institutionUserManageInstitution();
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> institutionUserInstitutions(String id) {
    return (ResponseEntity<Void>) institutionUserService.institutionUserInstitutions(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> institutionUserModifyGroups(String id) {
    return (ResponseEntity<Void>) institutionUserService.institutionUserModifyGroups(id);
  }
}
