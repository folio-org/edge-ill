package org.folio.edgeill.service;

import static java.util.Collections.emptyMap;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.folio.spring.scope.FolioExecutionContextService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class PublicApiProxyService {

  private final IllClient illClient;
  private final FolioExecutionContextService folioExecutionContextService;

  /**
   * Agrees to copyright terms for a patron request by its ID.
   *
   * @param tenantId        the tenant identifier
   * @param patronRequestId the patron request identifier
   * @return a ResponseEntity with the result of the copyright agreement operation
   */
  public ResponseEntity<Object> agreeCopyrightByPatronRequestsById(String tenantId, String patronRequestId) {
    return folioExecutionContextService.execute(tenantId, emptyMap(),
      () -> illClient.agreeCopyrightByPatronRequestsById(patronRequestId));
  }

  /**
   * Fetches copyright information for a patron request by its ID.
   *
   * @param tenantId        the tenant identifier
   * @param patronRequestId the patron request identifier
   * @return a ResponseEntity containing the copyright information
   */
  public ResponseEntity<Object> fetchCopyrightByPatronRequestId(String tenantId, String patronRequestId) {
    return folioExecutionContextService.execute(tenantId, emptyMap(),
      () -> illClient.fetchCopyrightByPatronRequestId(patronRequestId));
  }

  /**
   * Retrieves the OpenURL for a patron request with optional query parameters.
   *
   * @param tenantId    the tenant identifier
   * @param queryParams optional query parameters to customize the OpenURL
   * @return a ResponseEntity containing the generated OpenURL
   */
  public ResponseEntity<Object> getPatronRequestOpenUrl(String tenantId, Map<String, String> queryParams) {
    return folioExecutionContextService.execute(tenantId, emptyMap(),
      () -> illClient.getPatronRequestOpenUrl(queryParams));
  }

  /**
   * Tests document delivery offer functionality by posting an offer with a document file.
   *
   * @return a ResponseEntity with the result of the document delivery offer test
   */
  public ResponseEntity<Object> testDocumentDeliveryOffer(String tenantId, String systemId, String url,
    String privateKey, String offerReference, String documentTitle, String pin, String documentSecurityLevel,
    String offerType, String attestationLevel, String patronEmail, String rawSourceMimeType, String workflow,
    MultipartFile file) {

    var fileResource = toInputStreamResource(file);
    return folioExecutionContextService.execute(tenantId, emptyMap(),
      () -> illClient.postTestDocumentDeliveryOffer(
        systemId, url, privateKey, offerReference, documentTitle,
        pin, documentSecurityLevel, offerType, attestationLevel,
        patronEmail, rawSourceMimeType, workflow, fileResource));
  }

  /**
   * Registers a system for document delivery testing.
   *
   * @param tenantId         the tenant identifier
   * @param systemCode       the unique code for the system being registered
   * @param url              the base URL of the system
   * @param name             the display name of the system
   * @param attestationLevel the attestation level for the system
   * @return a ResponseEntity with the registration result
   */
  public ResponseEntity<Object> testDocumentDeliveryRegister(String tenantId, String systemCode,
    String url, String name, String attestationLevel) {

    return folioExecutionContextService.execute(tenantId, emptyMap(),
      () -> illClient.postTestDocumentDeliveryRegister(systemCode, url, name, attestationLevel));
  }

  /**
   * Retrieves the document associated with a patron request by its ID.
   *
   * @param tenantId        the tenant identifier
   * @param patronRequestId the patron request identifier
   * @return a ResponseEntity containing the document resource
   */
  public ResponseEntity<Resource> viewDocumentByPatronRequestId(String tenantId, String patronRequestId) {
    return folioExecutionContextService.execute(tenantId, emptyMap(),
      () -> illClient.viewDocumentByPatronRequestId(patronRequestId));
  }

  /**
   * Performs a remote action on an external system by the resource ID.
   *
   * @param tenantId the tenant identifier
   * @param id       the resource identifier
   * @return a ResponseEntity with the result of the remote action
   */
  public ResponseEntity<Resource> performRemoteAction(String tenantId, String id) {
    return folioExecutionContextService.execute(tenantId, emptyMap(),
      () -> illClient.performRemoteActionById(id));
  }

  /**
   * Retrieves a directory entry from the external API by slug.
   *
   * @param tenantId the tenant identifier
   * @param slug     the directory entry slug identifier
   * @return a ResponseEntity containing the directory entry details
   */
  public ResponseEntity<Object> getExternalApiDirectoryEntry(String tenantId, String slug) {
    return folioExecutionContextService.execute(tenantId, emptyMap(),
      () -> illClient.getExternalApiDirectoryEntry(slug));
  }

  /**
   * Retrieves the current status report from the external API.
   *
   * @param tenantId the tenant identifier
   * @return a ResponseEntity containing the status report
   */
  public ResponseEntity<Object> getExternalApiStatusReport(String tenantId) {
    return folioExecutionContextService.execute(tenantId, emptyMap(),
      illClient::getExternalApiStatusReport);
  }

  /**
   * Retrieves statistics from the external API for a specific symbol.
   *
   * @param tenantId the tenant identifier
   * @param symbol   the symbol or identifier for which to retrieve statistics
   * @return a ResponseEntity containing the statistics data
   */
  public ResponseEntity<Object> getExternalApiStatistics(String tenantId, String symbol) {
    return folioExecutionContextService.execute(tenantId, emptyMap(),
      () -> illClient.getExternalApiStatistics(symbol));
  }

  /**
   * Posts an ISO 18626 formatted request to the external API.
   *
   * @param tenantId    the tenant identifier
   * @param requestBody the ISO 18626 request body
   * @return a ResponseEntity with the result of the API request
   */
  public ResponseEntity<Resource> postExternalApiIso18626(String tenantId, Object requestBody) {
    return folioExecutionContextService.execute(tenantId, emptyMap(),
      () -> illClient.postExternalApiIso18626(requestBody));
  }

  private InputStreamResource toInputStreamResource(MultipartFile file) {
    if (file == null || file.isEmpty()) {
      return null;
    }

    try {
      var inputStream = file.getInputStream();
      var filename = file.getOriginalFilename();
      var size = file.getSize();
      return new InputStreamResource(inputStream) {
        @Override
        public String getFilename() {
          return filename;
        }

        @Override
        public long contentLength() {
          return size;
        }
      };
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }
}
