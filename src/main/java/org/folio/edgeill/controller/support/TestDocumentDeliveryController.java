package org.folio.edgeill.controller.support;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.TestDocumentDeliveryApi;
import org.folio.edgeill.service.PublicApiProxyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class TestDocumentDeliveryController implements TestDocumentDeliveryApi {

  private final PublicApiProxyService proxyService;

  @Override
  public ResponseEntity<Object> offer(String tenantId, String systemId, String url, String privateKey,
    String offerReference, String pin, String documentSecurityLevel, String attestationLevel, String documentTitle,
    String offerType, String patronEmail, String rawSourceMimeType, String workflow, MultipartFile file) {

    return proxyService.testDocumentDeliveryOffer(tenantId, systemId, url, privateKey,
      offerReference, documentTitle, pin, documentSecurityLevel, offerType,
      attestationLevel, patronEmail, rawSourceMimeType, workflow, file);
  }

  @Override
  public ResponseEntity<Object> register(String tenantId, String code, String url, String name, String level) {
    return proxyService.testDocumentDeliveryRegister(tenantId, code, url, name, level);
  }
}
