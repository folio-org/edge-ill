package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies host LMS item loan policy requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class HostLmsItemLoanPolicyService {

  private final IllClient illClient;

  public Object find(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getHostLmsitemLoanPolicy(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object create(Object body) {
    return illClient.postHostLmsitemLoanPolicy(null, null, null, null, null, null, null, null, null, body);
  }

  public Object getById(String id) {
    return illClient.getHostLmsitemLoanPolicyById(id);
  }

  public Object deleteById(String id) {
    return illClient.deleteHostLmsitemLoanPolicyById(id);
  }

  public Object updateById(String id, Object body) {
    return illClient.putHostLmsitemLoanPolicyById(id, body);
  }
}
