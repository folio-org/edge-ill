package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies state-model-related requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class StateModelService {

  private final IllClient illClient;

  public Object stateModelExport() {
    return illClient.getStateModelExport(null, null, null, null, null, null, null, null, null);
  }

  public Object stateModelGetValidActions() {
    return illClient.getStateModelGetValidActions(null, null, null, null, null, null, null, null, null);
  }

  public Object stateModelImport() {
    return illClient.postStateModelImport(null, null, null, null, null, null, null, null, null, null);
  }
}
