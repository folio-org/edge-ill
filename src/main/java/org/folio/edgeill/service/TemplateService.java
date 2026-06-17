package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies template-related requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class TemplateService {

  private final IllClient illClient;

  public Object findTemplates(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getTemplate(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object createTemplate(Object body) {
    return illClient.postTemplate(null, null, null, null, null, null, null, null, null, body);
  }

  public Object getTemplateById(String id) {
    return illClient.getTemplateById(id);
  }

  public Object deleteTemplateById(String id) {
    return illClient.deleteTemplateById(id);
  }

  public Object putTemplateById(String id, Object body) {
    return illClient.putTemplateById(id, body);
  }

  public Object templateCreateEditDetails() {
    return illClient.getTemplateCreateEditDetails(null, null, null, null, null, null, null, null, null);
  }
}
