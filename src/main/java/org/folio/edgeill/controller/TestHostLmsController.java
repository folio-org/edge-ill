package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.TestHostLmsApi;
import org.folio.edgeill.service.TestHostLmsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestHostLmsController implements TestHostLmsApi {

  private final TestHostLmsService testHostLmsService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> testHostLMSAcceptItem() {
    return (ResponseEntity<Void>) testHostLmsService.testHostLmsAcceptItem();
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> testHostLMSCheckIn() {
    return (ResponseEntity<Void>) testHostLmsService.testHostLmsCheckIn();
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> testHostLMSCheckOut() {
    return (ResponseEntity<Void>) testHostLmsService.testHostLmsCheckOut();
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> testHostLMSDetermineBestLocation() {
    return (ResponseEntity<Void>) testHostLmsService.testHostLmsDetermineBestLocation();
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> testHostLMSDirectZ3950() {
    return (ResponseEntity<Void>) testHostLmsService.testHostLmsDirectZ3950();
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> testHostLMSValidate() {
    return (ResponseEntity<Void>) testHostLmsService.testHostLmsValidate();
  }
}
