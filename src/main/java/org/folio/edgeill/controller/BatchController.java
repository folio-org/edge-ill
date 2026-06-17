package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.BatchApi;
import org.folio.edgeill.service.BatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BatchController implements BatchApi {

  private final BatchService batchService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findBatches(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) batchService.findBatches(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createBatch(Object body) {
    return (ResponseEntity<Void>) batchService.createBatch(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getBatchById(String id) {
    return (ResponseEntity<Void>) batchService.getBatchById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteBatchById(String id) {
    return (ResponseEntity<Void>) batchService.deleteBatchById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putBatchById(String id, Object body) {
    return (ResponseEntity<Void>) batchService.putBatchById(id, body);
  }
}
