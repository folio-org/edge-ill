package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.HostLmsItemLoanPolicyApi;
import org.folio.edgeill.service.HostLmsItemLoanPolicyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HostLmsItemLoanPolicyController implements HostLmsItemLoanPolicyApi {

  private final HostLmsItemLoanPolicyService service;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findHostLMSItemLoanPolicies(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) service.find(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createHostLMSItemLoanPolicy(Object body) {
    return (ResponseEntity<Void>) service.create(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getHostLMSItemLoanPolicyById(String id) {
    return (ResponseEntity<Void>) service.getById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteHostLMSItemLoanPolicyById(String id) {
    return (ResponseEntity<Void>) service.deleteById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putHostLMSItemLoanPolicyById(String id, Object body) {
    return (ResponseEntity<Void>) service.updateById(id, body);
  }
}
