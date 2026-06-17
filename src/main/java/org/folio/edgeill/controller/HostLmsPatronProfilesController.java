package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.HostLmsPatronProfilesApi;
import org.folio.edgeill.service.HostLmsPatronProfilesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HostLmsPatronProfilesController implements HostLmsPatronProfilesApi {

  private final HostLmsPatronProfilesService hostLmsPatronProfilesService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findHostLMSPatronProfileses(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) hostLmsPatronProfilesService.find(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createHostLMSPatronProfiles(Object body) {
    return (ResponseEntity<Void>) hostLmsPatronProfilesService.create(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getHostLMSPatronProfilesById(String id) {
    return (ResponseEntity<Void>) hostLmsPatronProfilesService.getById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteHostLMSPatronProfilesById(String id) {
    return (ResponseEntity<Void>) hostLmsPatronProfilesService.deleteById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putHostLMSPatronProfilesById(String id, Object body) {
    return (ResponseEntity<Void>) hostLmsPatronProfilesService.updateProfilesById(id, body);
  }
}
