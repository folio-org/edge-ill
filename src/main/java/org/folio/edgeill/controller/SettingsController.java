package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.SettingsApi;
import org.folio.edgeill.service.SettingsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SettingsController implements SettingsApi {

  private final SettingsService settingsService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findSettingsInstitutionSettings(String term, String match, String filters,
    String sort, Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) settingsService.findSettingsInstitutionSettings(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createSettingsInstitutionSetting(Object body) {
    return (ResponseEntity<Void>) settingsService.createSettingsInstitutionSetting(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getSettingsInstitutionSettingById(String id) {
    return (ResponseEntity<Void>) settingsService.getSettingsInstitutionSettingById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteSettingsInstitutionSettingById(String id) {
    return (ResponseEntity<Void>) settingsService.deleteSettingsInstitutionSettingById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putSettingsInstitutionSettingById(String id, Object body) {
    return (ResponseEntity<Void>) settingsService.putSettingsInstitutionSettingById(id, body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findSettingsSystemSettings(String term, String match, String filters,
    String sort, Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) settingsService.findSettingsSystemSettings(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createSettingsSystemSetting(Object body) {
    return (ResponseEntity<Void>) settingsService.createSettingsSystemSetting(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getSettingsSystemSettingById(String id) {
    return (ResponseEntity<Void>) settingsService.getSettingsSystemSettingById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteSettingsSystemSettingById(String id) {
    return (ResponseEntity<Void>) settingsService.deleteSettingsSystemSettingById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putSettingsSystemSettingById(String id, Object body) {
    return (ResponseEntity<Void>) settingsService.putSettingsSystemSettingById(id, body);
  }
}
