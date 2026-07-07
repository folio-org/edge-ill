package org.folio.edgeill.controller.support;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.ExternalApi;
import org.folio.edgeill.service.PublicApiProxyService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExternalApiController implements ExternalApi {

  private final PublicApiProxyService proxyService;

  @Override
  public ResponseEntity<Object> statusReport(String tenantId) {
    return proxyService.getExternalApiStatusReport(tenantId);
  }

  @Override
  public ResponseEntity<Object> statistics(String tenantId, String symbol) {
    return proxyService.getExternalApiStatistics(tenantId, symbol);
  }

  @Override
  public ResponseEntity<Resource> iso18626(String tenantId, Object body) {
    return proxyService.postExternalApiIso18626(tenantId, body);
  }

  @Override
  public ResponseEntity<Object> directoryEntry(String tenantId, String slug) {
    return proxyService.getExternalApiDirectoryEntry(tenantId, slug);
  }
}
