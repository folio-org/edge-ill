package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service that proxies directory-related requests to the mod-ill backend,
 * covering entries, naming authorities, services, service accounts, service credentials, and symbols.
 */
@Service
@RequiredArgsConstructor
public class DirectoryService {

  private final IllClient illClient;

  // --- Directory Entry ---

  public Object findDirectoryEntries(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getDirectoryEntry(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object createDirectoryEntry(Object body) {
    return illClient.postDirectoryEntry(null, null, null, null, null, null, null, null, null, body);
  }

  public Object getDirectoryEntryById(String id) {
    return illClient.getDirectoryEntryById(id);
  }

  public Object deleteDirectoryEntryById(String id) {
    return illClient.deleteDirectoryEntryById(id);
  }

  public Object putDirectoryEntryById(String id, Object body) {
    return illClient.putDirectoryEntryById(id, body);
  }

  public Object directoryEntryValidate(Object body) {
    return illClient.postDirectoryEntryValidate(null, null, null, null, null, null, null, null, null, body);
  }

  // --- Directory Naming Authority ---

  public Object findDirectoryNamingAuthorities(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getDirectoryNamingAuthority(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object createDirectoryNamingAuthority(Object body) {
    return illClient.postDirectoryNamingAuthority(null, null, null, null, null, null, null, null, null, body);
  }

  public Object getDirectoryNamingAuthorityById(String id) {
    return illClient.getDirectoryNamingAuthorityById(id);
  }

  public Object deleteDirectoryNamingAuthorityById(String id) {
    return illClient.deleteDirectoryNamingAuthorityById(id);
  }

  public Object putDirectoryNamingAuthorityById(String id, Object body) {
    return illClient.putDirectoryNamingAuthorityById(id, body);
  }

  // --- Directory Service ---

  public Object findDirectoryServices(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getDirectoryService(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object createDirectoryService(Object body) {
    return illClient.postDirectoryService(null, null, null, null, null, null, null, null, null, body);
  }

  public Object getDirectoryServiceById(String id) {
    return illClient.getDirectoryServiceById(id);
  }

  public Object deleteDirectoryServiceById(String id) {
    return illClient.deleteDirectoryServiceById(id);
  }

  public Object putDirectoryServiceById(String id, Object body) {
    return illClient.putDirectoryServiceById(id, body);
  }

  // --- Directory Service Account ---

  public Object findDirectoryServiceAccounts(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getDirectoryServiceAccount(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object createDirectoryServiceAccount(Object body) {
    return illClient.postDirectoryServiceAccount(null, null, null, null, null, null, null, null, null, body);
  }

  public Object getDirectoryServiceAccountById(String id) {
    return illClient.getDirectoryServiceAccountById(id);
  }

  public Object deleteDirectoryServiceAccountById(String id) {
    return illClient.deleteDirectoryServiceAccountById(id);
  }

  public Object putDirectoryServiceAccountById(String id, Object body) {
    return illClient.putDirectoryServiceAccountById(id, body);
  }

  // --- Directory Service Credential ---

  public Object findDirectoryServiceCredentials(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getDirectoryServiceCredential(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object createDirectoryServiceCredential(Object body) {
    return illClient.postDirectoryServiceCredential(null, null, null, null, null, null, null, null, null, body);
  }

  public Object getDirectoryServiceCredentialById(String id) {
    return illClient.getDirectoryServiceCredentialById(id);
  }

  public Object deleteDirectoryServiceCredentialById(String id) {
    return illClient.deleteDirectoryServiceCredentialById(id);
  }

  public Object putDirectoryServiceCredentialById(String id, Object body) {
    return illClient.putDirectoryServiceCredentialById(id, body);
  }

  // --- Directory Symbol ---

  public Object findDirectorySymbols(String term, String match, String filters, String sort,
      Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return illClient.getDirectorySymbol(term, match, filters, sort, max, perPage, offset, page, stats);
  }

  public Object createDirectorySymbol(Object body) {
    return illClient.postDirectorySymbol(null, null, null, null, null, null, null, null, null, body);
  }

  public Object getDirectorySymbolById(String id) {
    return illClient.getDirectorySymbolById(id);
  }

  public Object deleteDirectorySymbolById(String id) {
    return illClient.deleteDirectorySymbolById(id);
  }

  public Object putDirectorySymbolById(String id, Object body) {
    return illClient.putDirectorySymbolById(id, body);
  }

  // --- Directory API helpers ---

  public Object directoryApiAddFriend() {
    return illClient.getDirectoryApiAddFriend(null, null, null, null, null, null, null, null, null);
  }

  public Object directoryApiFindSymbol() {
    return illClient.getDirectoryApiFindSymbol(null, null, null, null, null, null, null, null, null);
  }

  public Object directoryApiFreshen() {
    return illClient.getDirectoryApiFreshen(null, null, null, null, null, null, null, null, null);
  }
}
