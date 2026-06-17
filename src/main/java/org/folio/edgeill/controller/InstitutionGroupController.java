package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.folio.edgeill.rest.resource.InstitutionGroupApi;
import org.folio.edgeill.service.InstitutionGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for institution group endpoints. Delegates to {@link IllClient} via {@link InstitutionGroupService}.
 */
@RestController
@RequiredArgsConstructor
public class InstitutionGroupController implements InstitutionGroupApi {

  private final InstitutionGroupService institutionGroupService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findInstitutionGroups(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return (ResponseEntity<Void>) institutionGroupService.findInstitutionGroups(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createInstitutionGroup(Object body) {
    return (ResponseEntity<Void>) institutionGroupService.createInstitutionGroup(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getInstitutionGroupById(String id) {
    return (ResponseEntity<Void>) institutionGroupService.getInstitutionGroupById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteInstitutionGroupById(String id) {
    return (ResponseEntity<Void>) institutionGroupService.deleteInstitutionGroupById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putInstitutionGroupById(String id, Object body) {
    return (ResponseEntity<Void>) institutionGroupService.putInstitutionGroupById(id, body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> institutionGroupCreateEditDetails() {
    return (ResponseEntity<Void>) institutionGroupService.institutionGroupCreateEditDetails();
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> institutionGroupModifyInstitutions(String id) {
    return (ResponseEntity<Void>) institutionGroupService.institutionGroupModifyInstitutions(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> institutionGroupModifyUsers(String id) {
    return (ResponseEntity<Void>) institutionGroupService.institutionGroupModifyUsers(id);
  }
}
