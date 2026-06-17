package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies file storage requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class FileStorageService {

  private final IllClient illClient;

  public Object fileStorageCreateEditDetails() {
    return illClient.getFileStorageCreateEditDetails(null, null, null, null, null, null, null, null, null);
  }
}
