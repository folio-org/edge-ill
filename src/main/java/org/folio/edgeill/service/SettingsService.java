package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies settings-related requests (institutionSetting and systemSetting) to the mod-ill backend.
 */
@Service
@RequiredArgsConstructor
public class SettingsService {

  private final IllClient illClient;

  public Object findSettingsInstitutionSettings(String term, String match, String filters,
      String sort, Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getSettingsInstitutionSetting(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object createSettingsInstitutionSetting(Object body) {
    return illClient.postSettingsInstitutionSetting(null, null, null, null, null, null, null, null, null, body);
  }

  public Object getSettingsInstitutionSettingById(String id) {
    return illClient.getSettingsInstitutionSettingById(id);
  }

  public Object deleteSettingsInstitutionSettingById(String id) {
    return illClient.deleteSettingsInstitutionSettingById(id);
  }

  public Object putSettingsInstitutionSettingById(String id, Object body) {
    return illClient.putSettingsInstitutionSettingById(id, body);
  }

  public Object findSettingsSystemSettings(String term, String match, String filters,
      String sort, Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getSettingsSystemSetting(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object createSettingsSystemSetting(Object body) {
    return illClient.postSettingsSystemSetting(null, null, null, null, null, null, null, null, null, body);
  }

  public Object getSettingsSystemSettingById(String id) {
    return illClient.getSettingsSystemSettingById(id);
  }

  public Object deleteSettingsSystemSettingById(String id) {
    return illClient.deleteSettingsSystemSettingById(id);
  }

  public Object putSettingsSystemSettingById(String id, Object body) {
    return illClient.putSettingsSystemSettingById(id, body);
  }
}
