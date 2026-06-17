package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.KiwtApi;
import org.folio.edgeill.service.KiwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KiwtController implements KiwtApi {

  private final KiwtService kiwtService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> kiwtRaml() {
    return (ResponseEntity<Void>) kiwtService.kiwtRaml();
  }
}
