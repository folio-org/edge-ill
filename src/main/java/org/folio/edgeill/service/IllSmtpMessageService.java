package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies ILL SMTP message requests to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class IllSmtpMessageService {

  private final IllClient illClient;

  public Object findIllSmtpMessages(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getIllSmtpMessage(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object createIllSmtpMessage(Object body) {
    return illClient.postIllSmtpMessage(null, null, null, null, null, null, null, null, null, body);
  }

  public Object getIllSmtpMessageById(String id) {
    return illClient.getIllSmtpMessageById(id);
  }

  public Object deleteIllSmtpMessageById(String id) {
    return illClient.deleteIllSmtpMessageById(id);
  }

  public Object putIllSmtpMessageById(String id, Object body) {
    return illClient.putIllSmtpMessageById(id, body);
  }

  public Object illSmtpMessageCreateEditDetails() {
    return illClient.getIllSmtpMessageCreateEditDetails(null, null, null, null, null, null, null, null, null);
  }

  public Object illSmtpMessageTokenValuesById(String id) {
    return illClient.getIllSmtpMessageTokenValuesById(id);
  }
}
