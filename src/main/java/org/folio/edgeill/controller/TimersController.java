package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.TimersApi;
import org.folio.edgeill.service.TimersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TimersController implements TimersApi {

  private final TimersService timersService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findTimerses(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) timersService.findTimerses(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createTimers(Object body) {
    return (ResponseEntity<Void>) timersService.createTimers(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getTimersById(String id) {
    return (ResponseEntity<Void>) timersService.getTimersById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteTimersById(String id) {
    return (ResponseEntity<Void>) timersService.deleteTimersById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putTimersById(String id, Object body) {
    return (ResponseEntity<Void>) timersService.putTimersById(id, body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> timersExecute() {
    return (ResponseEntity<Void>) timersService.timersExecute();
  }
}
