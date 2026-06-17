package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.folio.edgeill.rest.resource.StatusApi;
import org.folio.edgeill.service.StatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for status endpoints. Delegates to {@link IllClient} via {@link StatusService}.
 */
@RestController
@RequiredArgsConstructor
public class StatusController implements StatusApi {

  private final StatusService statusService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findStatuses(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return (ResponseEntity<Void>) statusService.findStatuses(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getStatusById(String id) {
    return (ResponseEntity<Void>) statusService.getStatusById(id);
  }
}
