package org.folio.edgeill.controller;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.rest.resource.DirectoryApi;
import org.folio.edgeill.service.DirectoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DirectoryController implements DirectoryApi {

  private final DirectoryService directoryService;

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findDirectoryEntries(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) directoryService.findDirectoryEntries(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createDirectoryEntry(Object body) {
    return (ResponseEntity<Void>) directoryService.createDirectoryEntry(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getDirectoryEntryById(String id) {
    return (ResponseEntity<Void>) directoryService.getDirectoryEntryById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteDirectoryEntryById(String id) {
    return (ResponseEntity<Void>) directoryService.deleteDirectoryEntryById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putDirectoryEntryById(String id, Object body) {
    return (ResponseEntity<Void>) directoryService.putDirectoryEntryById(id, body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> directoryEntryValidate(Object body) {
    return (ResponseEntity<Void>) directoryService.directoryEntryValidate(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findDirectoryNamingAuthorities(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) directoryService.findDirectoryNamingAuthorities(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createDirectoryNamingAuthority(Object body) {
    return (ResponseEntity<Void>) directoryService.createDirectoryNamingAuthority(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getDirectoryNamingAuthorityById(String id) {
    return (ResponseEntity<Void>) directoryService.getDirectoryNamingAuthorityById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteDirectoryNamingAuthorityById(String id) {
    return (ResponseEntity<Void>) directoryService.deleteDirectoryNamingAuthorityById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putDirectoryNamingAuthorityById(String id, Object body) {
    return (ResponseEntity<Void>) directoryService.putDirectoryNamingAuthorityById(id, body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findDirectoryServices(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return (ResponseEntity<Void>) directoryService.findDirectoryServices(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createDirectoryService(Object body) {
    return (ResponseEntity<Void>) directoryService.createDirectoryService(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getDirectoryServiceById(String id) {
    return (ResponseEntity<Void>) directoryService.getDirectoryServiceById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteDirectoryServiceById(String id) {
    return (ResponseEntity<Void>) directoryService.deleteDirectoryServiceById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putDirectoryServiceById(String id, Object body) {
    return (ResponseEntity<Void>) directoryService.putDirectoryServiceById(id, body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findDirectoryServiceAccounts(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) directoryService.findDirectoryServiceAccounts(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createDirectoryServiceAccount(Object body) {
    return (ResponseEntity<Void>) directoryService.createDirectoryServiceAccount(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getDirectoryServiceAccountById(String id) {
    return (ResponseEntity<Void>) directoryService.getDirectoryServiceAccountById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteDirectoryServiceAccountById(String id) {
    return (ResponseEntity<Void>) directoryService.deleteDirectoryServiceAccountById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putDirectoryServiceAccountById(String id, Object body) {
    return (ResponseEntity<Void>) directoryService.putDirectoryServiceAccountById(id, body);
  }

  // --- Directory Service Credential ---

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findDirectoryServiceCredentials(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {
    return (ResponseEntity<Void>) directoryService.findDirectoryServiceCredentials(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createDirectoryServiceCredential(Object body) {
    return (ResponseEntity<Void>) directoryService.createDirectoryServiceCredential(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getDirectoryServiceCredentialById(String id) {
    return (ResponseEntity<Void>) directoryService.getDirectoryServiceCredentialById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteDirectoryServiceCredentialById(String id) {
    return (ResponseEntity<Void>) directoryService.deleteDirectoryServiceCredentialById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putDirectoryServiceCredentialById(String id, Object body) {
    return (ResponseEntity<Void>) directoryService.putDirectoryServiceCredentialById(id, body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> findDirectorySymbols(String term, String match, String filters, String sort,
    Integer max, Integer perPage, String offset, Integer page, Boolean stats) {

    return (ResponseEntity<Void>) directoryService.findDirectorySymbols(
      term, match, filters, sort, max, perPage, offset, page, stats);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> createDirectorySymbol(Object body) {
    return (ResponseEntity<Void>) directoryService.createDirectorySymbol(body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> getDirectorySymbolById(String id) {
    return (ResponseEntity<Void>) directoryService.getDirectorySymbolById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> deleteDirectorySymbolById(String id) {
    return (ResponseEntity<Void>) directoryService.deleteDirectorySymbolById(id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> putDirectorySymbolById(String id, Object body) {
    return (ResponseEntity<Void>) directoryService.putDirectorySymbolById(id, body);
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> directoryApiAddFriend() {
    return (ResponseEntity<Void>) directoryService.directoryApiAddFriend();
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> directoryApiFindSymbol() {
    return (ResponseEntity<Void>) directoryService.directoryApiFindSymbol();
  }

  @Override
  @SuppressWarnings("unchecked")
  public ResponseEntity<Void> directoryApiFreshen() {
    return (ResponseEntity<Void>) directoryService.directoryApiFreshen();
  }
}
