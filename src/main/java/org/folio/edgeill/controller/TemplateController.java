package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.TemplateApi;
import org.folio.edgeill.service.TemplateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TemplateController implements TemplateApi {

  private final TemplateService templateService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findTemplates(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) templateService.findTemplates(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createTemplate(Object body) {
    return (ResponseEntity<Void>) templateService.createTemplate(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getTemplateById(String id) {
    return (ResponseEntity<Void>) templateService.getTemplateById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteTemplateById(String id) {
    return (ResponseEntity<Void>) templateService.deleteTemplateById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putTemplateById(String id, Object body) {
    return (ResponseEntity<Void>) templateService.putTemplateById(id, body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> templateCreateEditDetails() {
    return (ResponseEntity<Void>) templateService.templateCreateEditDetails();
  }
}
