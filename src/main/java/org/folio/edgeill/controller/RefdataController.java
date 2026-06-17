package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.RefdataApi;
import org.folio.edgeill.service.RefdataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RefdataController implements RefdataApi {

  private final RefdataService refdataService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findRefdatas(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) refdataService.findRefdatas(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createRefdata(Object body) {
    return (ResponseEntity<Void>) refdataService.createRefdata(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getRefdataById(String id) {
    return (ResponseEntity<Void>) refdataService.getRefdataById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteRefdataById(String id) {
    return (ResponseEntity<Void>) refdataService.deleteRefdataById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putRefdataById(String id, Object body) {
    return (ResponseEntity<Void>) refdataService.putRefdataById(id, body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> refdataByIdProperty(String id, String property) {
    return (ResponseEntity<Void>) refdataService.refdataByIdProperty(id, property);
  }
}
