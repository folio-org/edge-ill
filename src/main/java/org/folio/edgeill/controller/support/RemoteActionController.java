package org.folio.edgeill.controller.support;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.RemoteActionApi;
import org.folio.edgeill.service.PublicApiProxyService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RemoteActionController implements RemoteActionApi {

  private final PublicApiProxyService proxyService;

  @Override
  public ResponseEntity<Resource> perform(String tenantId, String id) {
    return proxyService.performRemoteAction(tenantId, id);
  }
}
