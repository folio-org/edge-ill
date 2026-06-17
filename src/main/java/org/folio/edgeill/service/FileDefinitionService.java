package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies file definition requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class FileDefinitionService {

  private final IllClient illClient;

  public Object getFileDefinitionById(String id) {
    return illClient.getFileDefinitionById(id);
  }

  public Object fileDefinitionFileDownloadById(String id) {
    return illClient.getFileDefinitionFileDownloadById(id);
  }

  public Object fileDefinitionFileUpload() {
    return illClient.postFileDefinitionFileUpload(null, null, null, null, null, null, null, null, null);
  }
}
