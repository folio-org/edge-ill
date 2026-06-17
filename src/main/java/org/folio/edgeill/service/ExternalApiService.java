package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies external API requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class ExternalApiService {

  private final IllClient illClient;

  public Object externalApiDirectoryEntry() {
    return illClient.getExternalApiDirectoryEntry(null, null, null, null, null, null, null, null, null);
  }

  public Object externalApiIso18626(Object body) {
    return illClient.postExternalApiIso18626(null, null, null, null, null, null, null, null, null, body);
  }

  public Object externalApiStatistics() {
    return illClient.getExternalApiStatistics(null, null, null, null, null, null, null, null, null);
  }

  public Object externalApiStatusReport() {
    return illClient.getExternalApiStatusReport(null, null, null, null, null, null, null, null, null);
  }
}
