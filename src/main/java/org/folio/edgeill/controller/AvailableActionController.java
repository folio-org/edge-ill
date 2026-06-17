package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.domain.dto.AvailableActionsFromState;
import org.folio.edgeill.domain.dto.AvailableActionsToState;
import org.folio.edgeill.rest.resource.AvailableActionApi;
import org.folio.edgeill.service.AvailableActionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AvailableActionController implements AvailableActionApi {

  private final AvailableActionService availableActionService;

  @Override
  public ResponseEntity<AvailableActionsFromState> getAvailableActionsFromStates(String stateModel, String actionCode) {
    var responseBody = availableActionService.getAvailableActionsFromState(stateModel, actionCode);
    return ResponseEntity.ok(responseBody);
  }

  @Override
  public ResponseEntity<AvailableActionsToState> getAvailableActionsToStates(
    String stateModel, String actionCode, Boolean traverseHierarchy) {

    var response = availableActionService.getAvailableActionsToState(stateModel, actionCode, traverseHierarchy);
    return ResponseEntity.ok(response);
  }
}
