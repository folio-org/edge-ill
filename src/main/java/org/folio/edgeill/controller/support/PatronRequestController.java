package org.folio.edgeill.controller.support;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.PatronRequestsApi;
import org.folio.edgeill.service.PublicApiProxyService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PatronRequestController implements PatronRequestsApi {

  private final PublicApiProxyService proxyService;

  @Override
  public ResponseEntity<Object> openURL(String tenantId, Map<String, String> queryParameters) {
    return proxyService.getPatronRequestOpenUrl(tenantId, queryParameters);
  }

  @Override
  public ResponseEntity<Object> agreeCopyright(String tenantId, String id) {
    return proxyService.agreeCopyrightByPatronRequestsById(tenantId, id);
  }

  @Override
  public ResponseEntity<Object> fetchCopyright(String tenantId, String patronRequestId) {
    return proxyService.fetchCopyrightByPatronRequestId(tenantId, patronRequestId);
  }

  @Override
  public ResponseEntity<Resource> viewDocument(String tenantId, String patronRequestId) {
    return proxyService.viewDocumentByPatronRequestId(tenantId, patronRequestId);
  }
}
