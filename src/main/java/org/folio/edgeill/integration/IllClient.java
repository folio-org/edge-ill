package org.folio.edgeill.integration;

import java.util.Map;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

@HttpExchange
public interface IllClient {

  @GetExchange("ill/externalApi/directoryEntry")
  ResponseEntity<Object> getExternalApiDirectoryEntry(@RequestParam(value = "slug", required = false) String slug);

  @PostExchange(value = "ill/externalApi/iso18626")
  ResponseEntity<Resource> postExternalApiIso18626(@RequestBody Object requestBody);

  @GetExchange("ill/externalApi/statistics")
  ResponseEntity<Object> getExternalApiStatistics(@RequestParam(value = "symbol", required = false) String symbol);

  @GetExchange("ill/externalApi/statusReport")
  ResponseEntity<Object> getExternalApiStatusReport();

  @GetExchange("ill/patronrequests/openURL")
  ResponseEntity<Object> getPatronRequestOpenUrl(@RequestParam Map<String, String> queryParams);

  @PutExchange(value = "ill/patronrequests/{id}/agreeCopyright", contentType = "application/json")
  ResponseEntity<Object> agreeCopyrightByPatronRequestsById(@PathVariable("id") String id);

  @GetExchange("ill/patronrequests/{id}/fetchCopyright")
  ResponseEntity<Object> fetchCopyrightByPatronRequestId(@PathVariable("id") String id);

  @GetExchange("ill/patronrequests/{id}/viewDocument")
  ResponseEntity<Resource> viewDocumentByPatronRequestId(@PathVariable("id") String id);

  @GetExchange("ill/remoteAction/{id}/perform")
  ResponseEntity<Resource> performRemoteActionById(@PathVariable("id") String id);

  @PostExchange(url = "ill/testDocumentDelivery/offer", contentType = "multipart/form-data")
  ResponseEntity<Object> postTestDocumentDeliveryOffer(
    @RequestPart(value = "systemId") String systemId,
    @RequestPart(value = "url") String url,
    @RequestPart(value = "privateKey") String privateKey,
    @RequestPart(value = "offerReference") String offerReference,
    @RequestPart(value = "documentTitle", required = false) String documentTitle,
    @RequestPart(value = "pin") String pin,
    @RequestPart(value = "documentSecurityLevel") String documentSecurityLevel,
    @RequestPart(value = "offerType", required = false) String offerType,
    @RequestPart(value = "attestationLevel") String attestationLevel,
    @RequestPart(value = "patronEmail", required = false) String patronEmail,
    @RequestPart(value = "rawSourceMimeType", required = false) String rawSourceMimeType,
    @RequestPart(value = "workflow", required = false) String workflow,
    @RequestPart(value = "file", required = false) Resource file);

  @PostExchange(value = "ill/testDocumentDelivery/register", contentType = "multipart/form-data")
  ResponseEntity<Object> postTestDocumentDeliveryRegister(
    @RequestPart(value = "systemCode") String systemCode,
    @RequestPart(value = "url") String url,
    @RequestPart(value = "name") String name,
    @RequestPart(value = "attestationLevel") String attestationLevel);
}
