package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.TagsApi;
import org.folio.edgeill.service.TagsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TagsController implements TagsApi {

  private final TagsService tagsService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findTagses(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) tagsService.findTagses(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createTags(Object body) {
    return (ResponseEntity<Void>) tagsService.createTags(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getTagsById(String id) {
    return (ResponseEntity<Void>) tagsService.getTagsById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteTagsById(String id) {
    return (ResponseEntity<Void>) tagsService.deleteTagsById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putTagsById(String id, Object body) {
    return (ResponseEntity<Void>) tagsService.putTagsById(id, body);
  }
}
