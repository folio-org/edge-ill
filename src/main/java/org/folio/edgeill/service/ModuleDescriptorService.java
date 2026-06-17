package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service for the ModuleDescriptor domain, delegating module descriptor generation to mod-ill
 * via {@link IllClient}.
 */
@Service
@RequiredArgsConstructor
public class ModuleDescriptorService {

  private final IllClient illClient;

  /**
   * Generates the module descriptor template from mod-ill.
   *
   * @return the generated module descriptor response
   */
  public Object moduleDescriptorGenerate() {
    return illClient.getModuleDescriptorGenerate(null, null, null, null, null, null, null, null, null);
  }
}
