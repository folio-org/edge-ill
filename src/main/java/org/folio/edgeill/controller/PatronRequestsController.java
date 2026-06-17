package org.folio.edgeill.controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.folio.edgeill.domain.dto.FetchPatronRequestCopyrightResponse;
import org.folio.edgeill.domain.dto.GenericResult;
import org.folio.edgeill.domain.dto.PatronRequest;
import org.folio.edgeill.domain.dto.PatronRequests;
import org.folio.edgeill.rest.resource.PatronRequestsApi;
import org.folio.edgeill.service.PatronRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PatronRequestsController implements PatronRequestsApi {

  private final PatronRequestService service;

  @Override
  public ResponseEntity<PatronRequest> create(PatronRequest requestBody) {
    return ResponseEntity.status(CREATED).body(service.create(requestBody));
  }

  @Override
  public ResponseEntity<PatronRequests> getRequests(String term, String match, String filters, String sort, Integer max,
    Integer perPage, String offset, Integer page, Boolean stats, Boolean includeTerminal) {

    var response = service.search(term, match, filters, sort, max, perPage, offset, page, stats, includeTerminal);
    return ResponseEntity.ok(response);
  }

  @Override
  public ResponseEntity<GenericResult> agreeCopyright(String tenantId, String patronRequestId, PatronRequest body) {
    return ResponseEntity.ok(service.agreeCopyright(tenantId, patronRequestId, body));
  }

  @Override
  public ResponseEntity<Void> deleteById(String id) {
    service.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @Override
  public ResponseEntity<FetchPatronRequestCopyrightResponse> fetchCopyright(String tenantId, String patronRequestId) {
    return ResponseEntity.ok(service.fetchCopyright(tenantId, patronRequestId));
  }

  @Override
  public ResponseEntity<Void> generatePickListBatch() {
    return PatronRequestsApi.super.generatePickListBatch();
  }

  @Override
  public ResponseEntity<PatronRequest> getById(String id) {
    var patronRequest = service.getById(id);
    return ResponseEntity.ok(patronRequest);
  }

  @Override
  public ResponseEntity<Void> getNewRequestDetails() {
    return PatronRequestsApi.super.getNewRequestDetails();
  }

  @Override
  public ResponseEntity<GenericResult> getOpenURL(String tenantId, Map<String, String> queryParams) {
    var openUrl = service.getOpenUrl(tenantId, queryParams);
    return ResponseEntity.ok(openUrl);
  }

  @Override
  public ResponseEntity<Void> getPatronRequestsValidActions(String id) {
    return PatronRequestsApi.super.getPatronRequestsValidActions(id);
  }

  @Override
  public ResponseEntity<Void> markBatchAsPrinted() {
    return PatronRequestsApi.super.markBatchAsPrinted();
  }

  @Override
  public ResponseEntity<Void> patronrequestsManualCloseStates(String id) {
    return PatronRequestsApi.super.patronrequestsManualCloseStates(id);
  }

  @Override
  public ResponseEntity<Void> patronrequestsNoticeTokenValues(String id) {
    return PatronRequestsApi.super.patronrequestsNoticeTokenValues(id);
  }

  @Override
  public ResponseEntity<Void> patronrequestsPerformAction(String id, Object body) {
    return PatronRequestsApi.super.patronrequestsPerformAction(id, body);
  }

  @Override
  public ResponseEntity<Void> postBulkAction(Object body) {
    return PatronRequestsApi.super.postBulkAction(body);
  }

  @Override
  public ResponseEntity<Void> postPatronRequestsActionWithFile(String id, Object body) {
    return PatronRequestsApi.super.postPatronRequestsActionWithFile(id, body);
  }

  @Override
  public ResponseEntity<Void> updateById(String id, Object body) {
    return PatronRequestsApi.super.updateById(id, body);
  }

  @Override
  public ResponseEntity<Void> viewDocument(String id) {
    return PatronRequestsApi.super.viewDocument(id);
  }
}
