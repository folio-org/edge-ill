package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies application-level requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class ApplicationService {

  private final IllClient illClient;

  /**
   * Returns the application-level settings from mod-ill.
   *
   * @return response from mod-ill containing application settings
   */
  public Object ill() {
    return illClient.getIll(null, null, null, null, null, null, null, null, null);
  }
}
