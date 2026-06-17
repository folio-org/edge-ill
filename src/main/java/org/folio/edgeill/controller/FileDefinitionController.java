package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.FileDefinitionApi;
import org.folio.edgeill.service.FileDefinitionService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FileDefinitionController implements FileDefinitionApi {

  private final FileDefinitionService fileDefinitionService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getFileDefinitionById(String id) {
    return (ResponseEntity<Void>) fileDefinitionService.getFileDefinitionById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Resource> fileDefinitionFileDownloadById(String id) {
    return (ResponseEntity<Resource>) (Object) fileDefinitionService.fileDefinitionFileDownloadById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> fileDefinitionFileUpload() {
    return (ResponseEntity<Void>) fileDefinitionService.fileDefinitionFileUpload();
  }
}
