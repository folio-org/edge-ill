package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.ShelvingLocationsApi;
import org.folio.edgeill.service.ShelvingLocationsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShelvingLocationsController implements ShelvingLocationsApi {

  private final ShelvingLocationsService shelvingLocationsService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findShelvingLocationses(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) shelvingLocationsService.findShelvingLocationses(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createShelvingLocations(Object body) {
    return (ResponseEntity<Void>) shelvingLocationsService.createShelvingLocations(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getShelvingLocationsById(String id) {
    return (ResponseEntity<Void>) shelvingLocationsService.getShelvingLocationsById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteShelvingLocationsById(String id) {
    return (ResponseEntity<Void>) shelvingLocationsService.deleteShelvingLocationsById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putShelvingLocationsById(String id, Object body) {
    return (ResponseEntity<Void>) shelvingLocationsService.putShelvingLocationsById(id, body);
  }
}
