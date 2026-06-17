package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.CustomPropertiesApi;
import org.folio.edgeill.service.CustomPropertiesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomPropertiesController implements CustomPropertiesApi {

  private final CustomPropertiesService customPropertiesService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findCustpropses(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return (ResponseEntity<Void>) customPropertiesService.search(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createCustprops(Object body) {
    return (ResponseEntity<Void>) customPropertiesService.create(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getCustpropsById(String id) {
    return (ResponseEntity<Void>) customPropertiesService.getById(id);
  }

  @Override
  public ResponseEntity<Void> deleteCustpropsById(String id) {
    customPropertiesService.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putCustpropsById(String id, Object body) {
    return (ResponseEntity<Void>) customPropertiesService.update(id, body);
  }
}
