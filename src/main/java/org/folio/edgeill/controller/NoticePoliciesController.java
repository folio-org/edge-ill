package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.NoticePoliciesApi;
import org.folio.edgeill.service.NoticePoliciesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NoticePoliciesController implements NoticePoliciesApi {

  private final NoticePoliciesService noticePoliciesService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> search(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return (ResponseEntity<Void>) noticePoliciesService.search(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> create(Object body) {
    return (ResponseEntity<Void>) noticePoliciesService.create(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getNoticePoliciesById(String id) {
    return (ResponseEntity<Void>) noticePoliciesService.getNoticePoliciesById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteNoticePoliciesById(String id) {
    return (ResponseEntity<Void>) noticePoliciesService.deleteNoticePoliciesById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putNoticePoliciesById(String id, Object body) {
    return (ResponseEntity<Void>) noticePoliciesService.putNoticePoliciesById(id, body);
  }
}
