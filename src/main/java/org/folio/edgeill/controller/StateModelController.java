package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.StateModelApi;
import org.folio.edgeill.service.StateModelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StateModelController implements StateModelApi {

  private final StateModelService stateModelService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> stateModelExport() {
    return (ResponseEntity<Void>) stateModelService.stateModelExport();
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> stateModelGetValidActions() {
    return (ResponseEntity<Void>) stateModelService.stateModelGetValidActions();
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> stateModelImport(Object body) {
    return (ResponseEntity<Void>) stateModelService.stateModelImport();
  }
}
