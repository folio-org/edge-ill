package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies test-host-lms requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class TestHostLmsService {

  private final IllClient illClient;

  public Object testHostLmsAcceptItem() {
    return illClient.getTestHostLmsacceptItem(null, null, null, null, null, null, null, null, null);
  }

  public Object testHostLmsCheckIn() {
    return illClient.getTestHostLmscheckIn(null, null, null, null, null, null, null, null, null);
  }

  public Object testHostLmsCheckOut() {
    return illClient.getTestHostLmscheckOut(null, null, null, null, null, null, null, null, null);
  }

  public Object testHostLmsDetermineBestLocation() {
    return illClient.getTestHostLmsdetermineBestLocation(null, null, null, null, null, null, null, null, null);
  }

  public Object testHostLmsDirectZ3950() {
    return illClient.getTestHostLmsdirectZ3950(null, null, null, null, null, null, null, null, null);
  }

  public Object testHostLmsValidate() {
    return illClient.getTestHostLmsvalidate(null, null, null, null, null, null, null, null, null);
  }
}
