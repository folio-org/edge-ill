package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies batch-related requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class BatchService {

  private final IllClient illClient;

  /**
   * Searches batches with the supplied criteria.
   */
  public Object findBatches(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getBatch(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  /**
   * Creates a new batch record.
   */
  public Object createBatch(Object body) {
    return illClient.postBatch(null, null, null, null, null, null, null, null, null, body);
  }

  /**
   * Returns the batch record identified by the supplied id.
   */
  public Object getBatchById(String id) {
    return illClient.getBatchById(id);
  }

  /**
   * Deletes the batch record identified by the supplied id.
   */
  public Object deleteBatchById(String id) {
    return illClient.deleteBatchById(id);
  }

  /**
   * Updates the batch record identified by the supplied id.
   */
  public Object putBatchById(String id, Object body) {
    return illClient.putBatchById(id, body);
  }
}
