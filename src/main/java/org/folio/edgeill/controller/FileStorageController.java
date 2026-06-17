package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.FileStorageApi;
import org.folio.edgeill.service.FileStorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FileStorageController implements FileStorageApi {

  private final FileStorageService fileStorageService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> fileStorageCreateEditDetails() {
    return (ResponseEntity<Void>) fileStorageService.fileStorageCreateEditDetails();
  }
}
