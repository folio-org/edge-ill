package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.ApplicationApi;
import org.folio.edgeill.service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApplicationController implements ApplicationApi {

  private final ApplicationService applicationService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> ill(String tenantId) {
    return (ResponseEntity<Void>) applicationService.ill();
  }
}
