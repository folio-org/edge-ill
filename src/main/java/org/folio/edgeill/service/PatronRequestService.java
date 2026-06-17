package org.folio.edgeill.service;

import static java.util.Collections.emptyMap;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.folio.edgeill.domain.dto.FetchPatronRequestCopyrightResponse;
import org.folio.edgeill.domain.dto.GenericResult;
import org.folio.edgeill.domain.dto.PatronRequest;
import org.folio.edgeill.domain.dto.PatronRequests;
import org.folio.edgeill.integration.IllClient;
import org.folio.spring.scope.FolioExecutionContextService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatronRequestService {

  private final IllClient illClient;
  private final FolioExecutionContextService folioExecutionContextService;

  public PatronRequest create(PatronRequest body) {
    return illClient.postPatronRequest(body);
  }

  public void deleteById(String id) {
    illClient.deletePatronRequestById(id);
  }

  public PatronRequest getById(String id) {
    return illClient.getPatronRequestsById(id);
  }

  public PatronRequests search(String term, String match, String filters, String sort, Integer max,
    Integer perPage, String offset, Integer page, Boolean stats, Boolean includeTerminal) {
    return illClient.getPatronRequests(term, match, filters, sort, max, perPage, offset, page, stats, includeTerminal);
  }

  public GenericResult agreeCopyright(String tenantId, String patronRequestId, PatronRequest patronRequest) {
    return folioExecutionContextService.execute(tenantId, emptyMap(),
      () -> illClient.agreeCopyrightByPatronRequestsById(patronRequestId, patronRequest));
  }

  public FetchPatronRequestCopyrightResponse fetchCopyright(String tenantId, String patronRequestId) {
    return folioExecutionContextService.execute(tenantId, emptyMap(),
      () -> illClient.fetchCopyrightByPatronRequestId(patronRequestId));
  }

  public GenericResult getOpenUrl(String tenantId, Map<String, String> queryParams)  {
    return folioExecutionContextService.execute(tenantId, emptyMap(),
      () -> illClient.getPatronRequestOpenUrl(queryParams));
  }
}
