package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.NoticeEventApi;
import org.folio.edgeill.service.NoticeEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NoticeEventController implements NoticeEventApi {

  private final NoticeEventService noticeEventService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findNoticeEvents(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return (ResponseEntity<Void>) noticeEventService.findNoticeEvents(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createNoticeEvent(Object body) {
    return (ResponseEntity<Void>) noticeEventService.createNoticeEvent(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getNoticeEventById(String id) {
    return (ResponseEntity<Void>) noticeEventService.getNoticeEventById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteNoticeEventById(String id) {
    return (ResponseEntity<Void>) noticeEventService.deleteNoticeEventById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putNoticeEventById(String id, Object body) {
    return (ResponseEntity<Void>) noticeEventService.putNoticeEventById(id, body);
  }
}
