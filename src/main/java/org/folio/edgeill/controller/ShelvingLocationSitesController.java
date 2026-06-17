package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.ShelvingLocationSitesApi;
import org.folio.edgeill.service.ShelvingLocationSitesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShelvingLocationSitesController implements ShelvingLocationSitesApi {

  private final ShelvingLocationSitesService shelvingLocationSitesService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findShelvingLocationSiteses(String term, String match, String filters,
    String sort, Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) shelvingLocationSitesService.findShelvingLocationSiteses(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createShelvingLocationSites(Object body) {
    return (ResponseEntity<Void>) shelvingLocationSitesService.createShelvingLocationSites(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getShelvingLocationSitesById(String id) {
    return (ResponseEntity<Void>) shelvingLocationSitesService.getShelvingLocationSitesById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteShelvingLocationSitesById(String id) {
    return (ResponseEntity<Void>) shelvingLocationSitesService.deleteShelvingLocationSitesById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putShelvingLocationSitesById(String id, Object body) {
    return (ResponseEntity<Void>) shelvingLocationSitesService.putShelvingLocationSitesById(id, body);
  }
}
