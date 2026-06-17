package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.domain.dto.AvailableActionsFromState;
import org.folio.edgeill.domain.dto.AvailableActionsToState;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvailableActionService {

  private final IllClient illClient;

  /**
   * Retrieves the available actions that can transition from a given state.
   *
   * <p>
   * This method queries the mod-ill backend to obtain all valid actions that can be performed from the specified state,
   * identified by the action code within a particular request or entity.
   * </p>
   *
   * @param id the identifier of the request or entity for which to retrieve available actions
   * @param actionCode the code representing the current state or action context
   * @return {@link AvailableActionsFromState} containing the list of available actions that can be transitioned from
   *   the specified state, or null if no actions are available
   */
  public AvailableActionsFromState getAvailableActionsFromState(String id, String actionCode) {
    return illClient.getAvailableActionFromStates(id, actionCode);
  }

  /**
   * Retrieves the available target states that can be reached with a given action.
   *
   * <p>
   * This method queries the mod-ill backend to determine all valid states that can be reached by performing the
   * specified action on the given entity. The method provides an option to traverse the state hierarchy, allowing
   * retrieval of actions across nested state structures.
   * </p>
   *
   * @param id the identifier of the request or entity for which to retrieve target states
   * @param actionCode the code representing the action to be performed
   * @param traverseHierarchy a flag indicating whether to traverse the state hierarchy to find all reachable states
   *   (true) or only direct transitions (false)
   * @return {@link AvailableActionsToState} containing the list of available target states that can be reached by
   *   performing the specified action, or null if no target states are available
   */
  public AvailableActionsToState getAvailableActionsToState(String id, String actionCode, Boolean traverseHierarchy) {
    return illClient.getAvailableActionToStates(id, actionCode, traverseHierarchy);
  }
}
