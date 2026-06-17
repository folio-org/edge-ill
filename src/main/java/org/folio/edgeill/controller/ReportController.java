package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.ReportApi;
import org.folio.edgeill.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReportController implements ReportApi {

  private final ReportService reportService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> reportCreateUpdate() {
    return (ResponseEntity<Void>) reportService.reportCreateUpdate();
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<org.springframework.core.io.Resource> reportExecute() {
    return (ResponseEntity<org.springframework.core.io.Resource>) reportService.reportExecute();
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<org.springframework.core.io.Resource> reportGeneratePicklist() {
    return (ResponseEntity<org.springframework.core.io.Resource>) reportService.reportGeneratePicklist();
  }
}
