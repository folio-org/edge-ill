package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.PatronApi;
import org.folio.edgeill.service.PatronService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PatronController implements PatronApi {

  private final PatronService patronService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findPatrons(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return (ResponseEntity<Void>) patronService.findPatrons(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createPatron(Object body) {
    return (ResponseEntity<Void>) patronService.createPatron(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getPatronById(String id) {
    return (ResponseEntity<Void>) patronService.getPatronById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deletePatronById(String id) {
    return (ResponseEntity<Void>) patronService.deletePatronById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putPatronById(String id, Object body) {
    return (ResponseEntity<Void>) patronService.putPatronById(id, body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> patronCanCreateRequest(String id) {
    return (ResponseEntity<Void>) patronService.patronCanCreateRequest(id);
  }
}
