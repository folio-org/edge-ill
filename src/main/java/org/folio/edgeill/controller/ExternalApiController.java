package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.ExternalApiApi;
import org.folio.edgeill.service.ExternalApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExternalApiController implements ExternalApiApi {

  private final ExternalApiService externalApiService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> externalApiDirectoryEntry() {
    return (ResponseEntity<Void>) externalApiService.externalApiDirectoryEntry();
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> externalApiIso18626(Object body) {
    return (ResponseEntity<Void>) externalApiService.externalApiIso18626(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> externalApiStatistics() {
    return (ResponseEntity<Void>) externalApiService.externalApiStatistics();
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> externalApiStatusReport() {
    return (ResponseEntity<Void>) externalApiService.externalApiStatusReport();
  }
}
