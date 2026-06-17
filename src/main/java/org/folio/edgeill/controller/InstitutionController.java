package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.InstitutionApi;
import org.folio.edgeill.service.InstitutionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InstitutionController implements InstitutionApi {

  private final InstitutionService institutionService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findInstitutions(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) institutionService.findInstitutions(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createInstitution(Object body) {
    return (ResponseEntity<Void>) institutionService.createInstitution(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getInstitutionById(String id) {
    return (ResponseEntity<Void>) institutionService.getInstitutionById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteInstitutionById(String id) {
    return (ResponseEntity<Void>) institutionService.deleteInstitutionById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putInstitutionById(String id, Object body) {
    return (ResponseEntity<Void>) institutionService.putInstitutionById(id, body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> institutionCreateEditDetails() {
    return (ResponseEntity<Void>) institutionService.institutionCreateEditDetails();
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> institutionModifyGroups(String id) {
    return (ResponseEntity<Void>) institutionService.institutionModifyGroups(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> institutionUsers(String id) {
    return (ResponseEntity<Void>) institutionService.institutionUsers(id);
  }
}
