package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.HostLmsLocationsApi;
import org.folio.edgeill.service.HostLmsLocationsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HostLmslocationsController implements HostLmsLocationsApi {

  private final HostLmsLocationsService hostLmsLocationsService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findHostLMSLocationses(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) hostLmsLocationsService.find(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createHostLMSLocations(Object body) {
    return (ResponseEntity<Void>) hostLmsLocationsService.create(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getHostLMSLocationsById(String id) {
    return (ResponseEntity<Void>) hostLmsLocationsService.getById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteHostLMSLocationsById(String id) {
    return (ResponseEntity<Void>) hostLmsLocationsService.deleteById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putHostLMSLocationsById(String id, Object body) {
    return (ResponseEntity<Void>) hostLmsLocationsService.updateById(id, body);
  }
}
