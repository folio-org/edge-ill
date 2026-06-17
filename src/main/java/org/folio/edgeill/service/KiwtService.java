package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service for the Kiwt domain, delegating RAML retrieval requests to mod-ill via {@link IllClient}.
 */
@Service
@RequiredArgsConstructor
public class KiwtService {

  private final IllClient illClient;

  /**
   * Retrieves the RAML file for the mod-ill application.
   *
   * @return the RAML file response from mod-ill
   */
  public Object kiwtRaml() {
    return illClient.getKiwtRaml(null, null, null, null, null, null, null, null, null);
  }
}
