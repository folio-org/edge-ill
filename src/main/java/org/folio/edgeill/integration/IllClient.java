package org.folio.edgeill.integration;

import java.util.Map;
import org.folio.edgeill.domain.dto.AvailableActionsFromState;
import org.folio.edgeill.domain.dto.AvailableActionsToState;
import org.folio.edgeill.domain.dto.FetchPatronRequestCopyrightResponse;
import org.folio.edgeill.domain.dto.GenericResult;
import org.folio.edgeill.domain.dto.PatronRequest;
import org.folio.edgeill.domain.dto.PatronRequests;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

/**
 * HTTP exchange client that proxies requests to the mod-ill backend module. Each method maps to a mod-ill endpoint as
 * declared in its module descriptor.
 */
@HttpExchange
public interface IllClient {

  @GetExchange("ill")
  ResponseEntity<Object> getIll(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/availableAction/createGraph/{id}")
  String getStateModelGraph(
    @PathVariable("id") String id,
    @RequestParam("excludeActions") String excludeActions,
    @RequestParam("excludeProtocolActions") Boolean excludeProtocolActions,
    @RequestParam("outputFormat") String outputFormat,
    @RequestParam("height") Integer height,
    @RequestParam("traverseHierarchy") Boolean traverseHierarchy);

  @GetExchange("ill/availableAction/fromStates/{id}/{actionCode}")
  AvailableActionsFromState getAvailableActionFromStates(
    @PathVariable("id") String id,
    @PathVariable("actionCode") String actionCode);

  @GetExchange("ill/availableAction/toStates/{id}/{actionCode}")
  AvailableActionsToState getAvailableActionToStates(
    @PathVariable("id") String id,
    @PathVariable("actionCode") String actionCode,
    @RequestParam("traverseHierarchy") Boolean traverseHierarchy);

  @GetExchange("ill/batch")
  ResponseEntity<Object> getBatch(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/batch")
  ResponseEntity<Object> postBatch(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/batch/{id}")
  ResponseEntity<Object> deleteBatchById(@PathVariable("id") String id);

  @GetExchange("ill/batch/{id}")
  ResponseEntity<Object> getBatchById(@PathVariable("id") String id);

  @PutExchange("ill/batch/{id}")
  ResponseEntity<Object> putBatchById(@PathVariable("id") String id, @RequestBody Object body);

  @GetExchange("ill/copyrightMessage")
  ResponseEntity<Object> getCopyrightMessage(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/copyrightMessage")
  ResponseEntity<Object> postCopyrightMessage(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @GetExchange("ill/copyrightMessage/createEditDetails")
  ResponseEntity<Object> getCopyrightMessageCreateEditDetails(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @DeleteExchange("ill/copyrightMessage/{id}")
  ResponseEntity<Object> deleteCopyrightMessageById(@PathVariable("id") String id);

  @GetExchange("ill/copyrightMessage/{id}")
  ResponseEntity<Object> getCopyrightMessageById(@PathVariable("id") String id);

  @PutExchange("ill/copyrightMessage/{id}")
  ResponseEntity<Object> putCopyrightMessageById(@PathVariable("id") String id, @RequestBody Object body);

  @GetExchange("ill/custprops")
  ResponseEntity<Object> getCustomProperties(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/custprops")
  ResponseEntity<Object> postCustprops(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/custprops/{id}")
  ResponseEntity<Object> deleteCustomPropertiesById(@PathVariable("id") String id);

  @GetExchange("ill/custprops/{id}")
  ResponseEntity<Object> getCustomPropertiesById(@PathVariable("id") String id);

  @PutExchange("ill/custprops/{id}")
  ResponseEntity<Object> putCustomPropertiesById(@PathVariable("id") String id, @RequestBody Object body);

  @GetExchange("ill/directory/api/addFriend")
  ResponseEntity<Object> getDirectoryApiAddFriend(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/directory/api/findSymbol")
  ResponseEntity<Object> getDirectoryApiFindSymbol(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/directory/api/freshen")
  ResponseEntity<Object> getDirectoryApiFreshen(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/directory/entry")
  ResponseEntity<Object> getDirectoryEntry(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/directory/entry")
  ResponseEntity<Object> postDirectoryEntry(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @PostExchange("ill/directory/entry/validate")
  ResponseEntity<Object> postDirectoryEntryValidate(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/directory/entry/{id}")
  ResponseEntity<Object> deleteDirectoryEntryById(@PathVariable("id") String id);

  @GetExchange("ill/directory/entry/{id}")
  ResponseEntity<Object> getDirectoryEntryById(@PathVariable("id") String id);

  @PutExchange("ill/directory/entry/{id}")
  ResponseEntity<Object> putDirectoryEntryById(@PathVariable("id") String id, @RequestBody Object body);

  @GetExchange("ill/directory/namingAuthority")
  ResponseEntity<Object> getDirectoryNamingAuthority(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/directory/namingAuthority")
  ResponseEntity<Object> postDirectoryNamingAuthority(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/directory/namingAuthority/{id}")
  ResponseEntity<Object> deleteDirectoryNamingAuthorityById(
    @PathVariable("id") String id);

  @GetExchange("ill/directory/namingAuthority/{id}")
  ResponseEntity<Object> getDirectoryNamingAuthorityById(
    @PathVariable("id") String id);

  @PutExchange("ill/directory/namingAuthority/{id}")
  ResponseEntity<Object> putDirectoryNamingAuthorityById(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @GetExchange("ill/directory/service")
  ResponseEntity<Object> getDirectoryService(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/directory/service")
  ResponseEntity<Object> postDirectoryService(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/directory/service/{id}")
  ResponseEntity<Object> deleteDirectoryServiceById(@PathVariable("id") String id);

  @GetExchange("ill/directory/service/{id}")
  ResponseEntity<Object> getDirectoryServiceById(@PathVariable("id") String id);

  @PutExchange("ill/directory/service/{id}")
  ResponseEntity<Object> putDirectoryServiceById(@PathVariable("id") String id, @RequestBody Object body);

  @GetExchange("ill/directory/serviceAccount")
  ResponseEntity<Object> getDirectoryServiceAccount(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/directory/serviceAccount")
  ResponseEntity<Object> postDirectoryServiceAccount(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/directory/serviceAccount/{id}")
  ResponseEntity<Object> deleteDirectoryServiceAccountById(@PathVariable("id") String id);

  @GetExchange("ill/directory/serviceAccount/{id}")
  ResponseEntity<Object> getDirectoryServiceAccountById(@PathVariable("id") String id);

  @PutExchange("ill/directory/serviceAccount/{id}")
  ResponseEntity<Object> putDirectoryServiceAccountById(@PathVariable("id") String id, @RequestBody Object body);

  @GetExchange("ill/directory/serviceCredential")
  ResponseEntity<Object> getDirectoryServiceCredential(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/directory/serviceCredential")
  ResponseEntity<Object> postDirectoryServiceCredential(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/directory/serviceCredential/{id}")
  ResponseEntity<Object> deleteDirectoryServiceCredentialById(@PathVariable("id") String id);

  @GetExchange("ill/directory/serviceCredential/{id}")
  ResponseEntity<Object> getDirectoryServiceCredentialById(@PathVariable("id") String id);

  @PutExchange("ill/directory/serviceCredential/{id}")
  ResponseEntity<Object> putDirectoryServiceCredentialById(@PathVariable("id") String id, @RequestBody Object body);

  @GetExchange("ill/directory/symbol")
  ResponseEntity<Object> getDirectorySymbol(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/directory/symbol")
  ResponseEntity<Object> postDirectorySymbol(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/directory/symbol/{id}")
  ResponseEntity<Object> deleteDirectorySymbolById(@PathVariable("id") String id);

  @GetExchange("ill/directory/symbol/{id}")
  ResponseEntity<Object> getDirectorySymbolById(@PathVariable("id") String id);

  @PutExchange("ill/directory/symbol/{id}")
  ResponseEntity<Object> putDirectorySymbolById(@PathVariable("id") String id, @RequestBody Object body);

  @GetExchange("ill/directoryGroup")
  ResponseEntity<Object> getDirectoryGroup(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/directoryGroup")
  ResponseEntity<Object> postDirectoryGroup(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/directoryGroup/{id}")
  ResponseEntity<Object> deleteDirectoryGroupById(@PathVariable("id") String id);

  @GetExchange("ill/directoryGroup/{id}")
  ResponseEntity<Object> getDirectoryGroupById(@PathVariable("id") String id);

  @PutExchange("ill/directoryGroup/{id}")
  ResponseEntity<Object> putDirectoryGroupById(@PathVariable("id") String id, @RequestBody Object body);

  @GetExchange("ill/directoryGroup/{id}/modifyMembers")
  ResponseEntity<Object> getDirectoryGroupByIdModifyMembers(@PathVariable("id") String id);

  @GetExchange("ill/directoryGroups")
  ResponseEntity<Object> getDirectoryGroups(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/directoryGroups")
  ResponseEntity<Object> postDirectoryGroups(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/directoryGroups/{id}")
  ResponseEntity<Object> deleteDirectoryGroupsById(@PathVariable("id") String id);

  @GetExchange("ill/directoryGroups/{id}")
  ResponseEntity<Object> getDirectoryGroupsById(
    @PathVariable("id") String id);

  @PutExchange("ill/directoryGroups/{id}")
  ResponseEntity<Object> putDirectoryGroupsById(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @GetExchange("ill/directoryGroups/{id}/modifyMembers")
  ResponseEntity<Object> getDirectoryGroupsByIdModifyMembers(
    @PathVariable("id") String id);

  @GetExchange("ill/documentDeliveryServer")
  ResponseEntity<Object> getDocumentDeliveryServer(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/documentDeliveryServer/createEditDetails")
  ResponseEntity<Object> getDocumentDeliveryServerCreateEditDetails(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/documentDeliveryServer/register")
  ResponseEntity<Object> postDocumentDeliveryServerRegister(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @GetExchange("ill/documentDeliveryServer/{id}")
  ResponseEntity<Object> getDocumentDeliveryServerById(
    @PathVariable("id") String id);

  @GetExchange("ill/externalApi/directoryEntry")
  ResponseEntity<Object> getExternalApiDirectoryEntry(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/externalApi/iso18626")
  ResponseEntity<Object> postExternalApiIso18626(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @GetExchange("ill/externalApi/statistics")
  ResponseEntity<Object> getExternalApiStatistics(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/externalApi/statusReport")
  ResponseEntity<Object> getExternalApiStatusReport(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/fileDefinition/fileDownload/{id}")
  ResponseEntity<byte[]> getFileDefinitionFileDownloadById(
    @PathVariable("id") String id);

  @PostExchange("ill/fileDefinition/fileUpload")
  ResponseEntity<Object> postFileDefinitionFileUpload(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/fileDefinition/{id}")
  ResponseEntity<Object> getFileDefinitionById(@PathVariable("id") String id);

  @GetExchange("ill/fileStorage/createEditDetails")
  ResponseEntity<Object> getFileStorageCreateEditDetails(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/hostLMSItemLoanPolicy")
  ResponseEntity<Object> getHostLmsitemLoanPolicy(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/hostLMSItemLoanPolicy")
  ResponseEntity<Object> postHostLmsitemLoanPolicy(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/hostLMSItemLoanPolicy/{id}")
  ResponseEntity<Object> deleteHostLmsitemLoanPolicyById(
    @PathVariable("id") String id);

  @GetExchange("ill/hostLMSItemLoanPolicy/{id}")
  ResponseEntity<Object> getHostLmsitemLoanPolicyById(
    @PathVariable("id") String id);

  @PutExchange("ill/hostLMSItemLoanPolicy/{id}")
  ResponseEntity<Object> putHostLmsitemLoanPolicyById(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @GetExchange("ill/hostLMSLocations")
  ResponseEntity<Object> getHostLmslocations(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/hostLMSLocations")
  ResponseEntity<Object> postHostLmslocations(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/hostLMSLocations/{id}")
  ResponseEntity<Object> deleteHostLmslocationsById(
    @PathVariable("id") String id);

  @GetExchange("ill/hostLMSLocations/{id}")
  ResponseEntity<Object> getHostLmslocationsById(
    @PathVariable("id") String id);

  @PutExchange("ill/hostLMSLocations/{id}")
  ResponseEntity<Object> putHostLmslocationsById(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @GetExchange("ill/hostLMSPatronProfiles")
  ResponseEntity<Object> getHostLmspatronProfiles(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/hostLMSPatronProfiles")
  ResponseEntity<Object> postHostLmspatronProfiles(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/hostLMSPatronProfiles/{id}")
  ResponseEntity<Object> deleteHostLmspatronProfilesById(
    @PathVariable("id") String id);

  @GetExchange("ill/hostLMSPatronProfiles/{id}")
  ResponseEntity<Object> getHostLmspatronProfilesById(
    @PathVariable("id") String id);

  @PutExchange("ill/hostLMSPatronProfiles/{id}")
  ResponseEntity<Object> putHostLmspatronProfilesById(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @GetExchange("illillSmtpMessage")
  ResponseEntity<Object> getIllSmtpMessage(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("illillSmtpMessage")
  ResponseEntity<Object> postIllSmtpMessage(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @GetExchange("illillSmtpMessage/createEditDetails")
  ResponseEntity<Object> getIllSmtpMessageCreateEditDetails(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("illillSmtpMessage/tokenValues/{id}")
  ResponseEntity<Object> getIllSmtpMessageTokenValuesById(
    @PathVariable("id") String id);

  @DeleteExchange("illillSmtpMessage/{id}")
  ResponseEntity<Object> deleteIllSmtpMessageById(@PathVariable("id") String id);

  @GetExchange("illillSmtpMessage/{id}")
  ResponseEntity<Object> getIllSmtpMessageById(@PathVariable("id") String id);

  @PutExchange("illillSmtpMessage/{id}")
  ResponseEntity<Object> putIllSmtpMessageById(@PathVariable("id") String id, @RequestBody Object body);

  @GetExchange("ill/institution")
  ResponseEntity<Object> getInstitution(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/institution")
  ResponseEntity<Object> postInstitution(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @GetExchange("ill/institution/createEditDetails")
  ResponseEntity<Object> getInstitutionCreateEditDetails(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @DeleteExchange("ill/institution/{id}")
  ResponseEntity<Object> deleteInstitutionById(
    @PathVariable("id") String id);

  @GetExchange("ill/institution/{id}")
  ResponseEntity<Object> getInstitutionById(
    @PathVariable("id") String id);

  @PutExchange("ill/institution/{id}")
  ResponseEntity<Object> putInstitutionById(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @GetExchange("ill/institution/{id}/modifyGroups")
  ResponseEntity<Object> getInstitutionByIdModifyGroups(
    @PathVariable("id") String id);

  @GetExchange("ill/institution/{id}/users")
  ResponseEntity<Object> getInstitutionByIdUsers(
    @PathVariable("id") String id);

  @GetExchange("ill/institutionGroup")
  ResponseEntity<Object> getInstitutionGroup(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/institutionGroup")
  ResponseEntity<Object> postInstitutionGroup(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @GetExchange("ill/institutionGroup/createEditDetails")
  ResponseEntity<Object> getInstitutionGroupCreateEditDetails(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @DeleteExchange("ill/institutionGroup/{id}")
  ResponseEntity<Object> deleteInstitutionGroupById(
    @PathVariable("id") String id);

  @GetExchange("ill/institutionGroup/{id}")
  ResponseEntity<Object> getInstitutionGroupById(
    @PathVariable("id") String id);

  @PutExchange("ill/institutionGroup/{id}")
  ResponseEntity<Object> putInstitutionGroupById(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @GetExchange("ill/institutionGroup/{id}/modifyInstitutions")
  ResponseEntity<Object> getInstitutionGroupByIdModifyInstitutions(
    @PathVariable("id") String id);

  @GetExchange("ill/institutionGroup/{id}/modifyUsers")
  ResponseEntity<Object> getInstitutionGroupByIdModifyUsers(
    @PathVariable("id") String id);

  @GetExchange("ill/institutionUser")
  ResponseEntity<Object> getInstitutionUser(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/institutionUser")
  ResponseEntity<Object> postInstitutionUser(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @GetExchange("ill/institutionUser/canManage")
  ResponseEntity<Object> getInstitutionUserCanManage(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/institutionUser/createEditDetails")
  ResponseEntity<Object> getInstitutionUserCreateEditDetails(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/institutionUser/manageInstitution")
  ResponseEntity<Object> getInstitutionUserManageInstitution(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @DeleteExchange("ill/institutionUser/{id}")
  ResponseEntity<Object> deleteInstitutionUserById(
    @PathVariable("id") String id);

  @GetExchange("ill/institutionUser/{id}")
  ResponseEntity<Object> getInstitutionUserById(
    @PathVariable("id") String id);

  @PutExchange("ill/institutionUser/{id}")
  ResponseEntity<Object> putInstitutionUserById(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @GetExchange("ill/institutionUser/{id}/institutions")
  ResponseEntity<Object> getInstitutionUserByIdInstitutions(
    @PathVariable("id") String id);

  @GetExchange("ill/institutionUser/{id}/modifyGroups")
  ResponseEntity<Object> getInstitutionUserByIdModifyGroups(
    @PathVariable("id") String id);

  @GetExchange("ill/kiwt/raml")
  ResponseEntity<Object> getKiwtRaml(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/logging")
  ResponseEntity<Object> getLogging(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/moduleDescriptor/generate")
  ResponseEntity<Object> getModuleDescriptorGenerate(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/noticeEvent")
  ResponseEntity<Object> getNoticeEvent(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/noticeEvent")
  ResponseEntity<Object> postNoticeEvent(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/noticeEvent/{id}")
  ResponseEntity<Object> deleteNoticeEventById(
    @PathVariable("id") String id);

  @GetExchange("ill/noticeEvent/{id}")
  ResponseEntity<Object> getNoticeEventById(
    @PathVariable("id") String id);

  @PutExchange("ill/noticeEvent/{id}")
  ResponseEntity<Object> putNoticeEventById(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @GetExchange("ill/noticePolicies")
  ResponseEntity<Object> getNoticePolicies(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/noticePolicies")
  ResponseEntity<Object> postNoticePolicies(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/noticePolicies/{id}")
  ResponseEntity<Object> deleteNoticePoliciesById(
    @PathVariable("id") String id);

  @GetExchange("ill/noticePolicies/{id}")
  ResponseEntity<Object> getNoticePoliciesById(
    @PathVariable("id") String id);

  @PutExchange("ill/noticePolicies/{id}")
  ResponseEntity<Object> putNoticePoliciesById(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @GetExchange("ill/patron")
  ResponseEntity<Object> getPatron(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/patron")
  ResponseEntity<Object> postPatron(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/patron/{id}")
  ResponseEntity<Object> deletePatronById(
    @PathVariable("id") String id);

  @GetExchange("ill/patron/{id}")
  ResponseEntity<Object> getPatronById(
    @PathVariable("id") String id);

  @PutExchange("ill/patron/{id}")
  ResponseEntity<Object> putPatronById(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @GetExchange("ill/patron/{id}/canCreateRequest")
  ResponseEntity<Object> getPatronByIdCanCreateRequest(
    @PathVariable("id") String id);

  @GetExchange("ill/patronrequests")
  PatronRequests getPatronRequests(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestParam("includeTerminal") Boolean includeTerminal);

  @PostExchange("ill/patronrequests")
  PatronRequest postPatronRequest(@RequestBody PatronRequest patronRequest);

  @PostExchange("ill/patronrequests/bulkAction")
  ResponseEntity<Object> postPatronRequestBulkAction(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @GetExchange("ill/patronrequests/generatePickListBatch")
  ResponseEntity<Object> getPatronRequestGeneratePickListBatch(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/patronrequests/markBatchAsPrinted")
  ResponseEntity<Object> getPatronRequestMarkBatchAsPrinted(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/patronrequests/newRequestDetails")
  ResponseEntity<Object> getPatronRequestNewRequestDetails(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/patronrequests/openURL")
  GenericResult getPatronRequestOpenUrl(@RequestParam Map<String, String> queryParams);

  @DeleteExchange("ill/patronrequests/{id}")
  void deletePatronRequestById(@PathVariable("id") String id);

  @GetExchange("ill/patronrequests/{id}")
  PatronRequest getPatronRequestsById(@PathVariable("id") String id);

  @PutExchange("ill/patronrequests/{id}")
  ResponseEntity<Object> putPatronRequestsById(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @PutExchange("ill/patronrequests/{id}/agreeCopyright")
  GenericResult agreeCopyrightByPatronRequestsById(
    @PathVariable("id") String id,
    @RequestBody PatronRequest patronRequest);

  @GetExchange("ill/patronrequests/{id}/fetchCopyright")
  FetchPatronRequestCopyrightResponse fetchCopyrightByPatronRequestId(@PathVariable("id") String id);

  @GetExchange("ill/patronrequests/{id}/manualCloseStates")
  ResponseEntity<Object> getPatronRequestByIdManualCloseStates(
    @PathVariable("id") String id);

  @GetExchange("ill/patronrequests/{id}/noticeTokenValues")
  ResponseEntity<Object> getPatronRequestByIdNoticeTokenValues(
    @PathVariable("id") String id);

  @PostExchange("ill/patronrequests/{id}/performAction")
  ResponseEntity<Object> postPatronRequestByIdPerformAction(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @PostExchange("ill/patronrequests/{id}/performActionWithFile")
  ResponseEntity<Object> postPatronRequestByIdPerformActionWithFile(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @GetExchange("ill/patronrequests/{id}/validActions")
  ResponseEntity<Object> getPatronRequestByIdValidActions(
    @PathVariable("id") String id);

  @GetExchange("ill/patronrequests/{id}/viewDocument")
  ResponseEntity<Object> getPatronRequestByIdViewDocument(
    @PathVariable("id") String id);

  @GetExchange("ill/protocol")
  ResponseEntity<Object> getProtocol(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/protocol")
  ResponseEntity<Object> postProtocol(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/protocol/{id}")
  ResponseEntity<Object> deleteProtocolById(
    @PathVariable("id") String id);

  @GetExchange("ill/protocol/{id}")
  ResponseEntity<Object> getProtocolById(
    @PathVariable("id") String id);

  @PutExchange("ill/protocol/{id}")
  ResponseEntity<Object> putProtocolById(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @GetExchange("ill/refdata")
  ResponseEntity<Object> getRefdata(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/refdata")
  ResponseEntity<Object> postRefdata(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/refdata/{id}")
  ResponseEntity<Object> deleteRefdataById(
    @PathVariable("id") String id);

  @GetExchange("ill/refdata/{id}")
  ResponseEntity<Object> getRefdataById(
    @PathVariable("id") String id);

  @PutExchange("ill/refdata/{id}")
  ResponseEntity<Object> putRefdataById(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @GetExchange("ill/refdata/{id}/{property}")
  ResponseEntity<Object> getRefdataByIdByProperty(
    @PathVariable("id") String id,
    @PathVariable("property") String property);

  @GetExchange("ill/remoteAction")
  ResponseEntity<Object> getRemoteAction(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/remoteAction")
  ResponseEntity<Object> postRemoteAction(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/remoteAction/{id}")
  ResponseEntity<Object> deleteRemoteActionById(
    @PathVariable("id") String id);

  @GetExchange("ill/remoteAction/{id}")
  ResponseEntity<Object> getRemoteActionById(
    @PathVariable("id") String id);

  @PutExchange("ill/remoteAction/{id}")
  ResponseEntity<Object> putRemoteActionById(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @GetExchange("ill/remoteAction/{id}/perform")
  ResponseEntity<Object> getRemoteActionByIdPerform(
    @PathVariable("id") String id);

  @PostExchange("ill/report/createUpdate")
  ResponseEntity<Object> postReportCreateUpdate(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/report/execute")
  ResponseEntity<byte[]> getReportExecute(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/report/generatePicklist")
  ResponseEntity<byte[]> getReportGeneratePicklist(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/search")
  ResponseEntity<Object> getSearch(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/search")
  ResponseEntity<Object> postSearch(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/search/{id}")
  ResponseEntity<Object> deleteSearchById(
    @PathVariable("id") String id);

  @GetExchange("ill/search/{id}")
  ResponseEntity<Object> getSearchById(
    @PathVariable("id") String id);

  @PutExchange("ill/search/{id}")
  ResponseEntity<Object> putSearchById(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @GetExchange("ill/searchAttribute")
  ResponseEntity<Object> getSearchAttribute(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/searchAttribute")
  ResponseEntity<Object> postSearchAttribute(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/searchAttribute/{id}")
  ResponseEntity<Object> deleteSearchAttributeById(
    @PathVariable("id") String id);

  @GetExchange("ill/searchAttribute/{id}")
  ResponseEntity<Object> getSearchAttributeById(
    @PathVariable("id") String id);

  @PutExchange("ill/searchAttribute/{id}")
  ResponseEntity<Object> putSearchAttributeById(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @GetExchange("ill/searchGroup")
  ResponseEntity<Object> getSearchGroup(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/searchGroup")
  ResponseEntity<Object> postSearchGroup(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/searchGroup/{id}")
  ResponseEntity<Object> deleteSearchGroupById(
    @PathVariable("id") String id);

  @GetExchange("ill/searchGroup/{id}")
  ResponseEntity<Object> getSearchGroupById(
    @PathVariable("id") String id);

  @PutExchange("ill/searchGroup/{id}")
  ResponseEntity<Object> putSearchGroupById(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @GetExchange("ill/searchTree")
  ResponseEntity<Object> getSearchTree(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/searchTree")
  ResponseEntity<Object> postSearchTree(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/searchTree/{id}")
  ResponseEntity<Object> deleteSearchTreeById(
    @PathVariable("id") String id);

  @GetExchange("ill/searchTree/{id}")
  ResponseEntity<Object> getSearchTreeById(
    @PathVariable("id") String id);

  @PutExchange("ill/searchTree/{id}")
  ResponseEntity<Object> putSearchTreeById(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @GetExchange("ill/settings/institutionSetting")
  ResponseEntity<Object> getSettingsInstitutionSetting(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/settings/institutionSetting")
  ResponseEntity<Object> postSettingsInstitutionSetting(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/settings/institutionSetting/{id}")
  ResponseEntity<Object> deleteSettingsInstitutionSettingById(
    @PathVariable("id") String id);

  @GetExchange("ill/settings/institutionSetting/{id}")
  ResponseEntity<Object> getSettingsInstitutionSettingById(
    @PathVariable("id") String id);

  @PutExchange("ill/settings/institutionSetting/{id}")
  ResponseEntity<Object> putSettingsInstitutionSettingById(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @GetExchange("ill/settings/systemSetting")
  ResponseEntity<Object> getSettingsSystemSetting(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/settings/systemSetting")
  ResponseEntity<Object> postSettingsSystemSetting(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/settings/systemSetting/{id}")
  ResponseEntity<Object> deleteSettingsSystemSettingById(
    @PathVariable("id") String id);

  @GetExchange("ill/settings/systemSetting/{id}")
  ResponseEntity<Object> getSettingsSystemSettingById(
    @PathVariable("id") String id);

  @PutExchange("ill/settings/systemSetting/{id}")
  ResponseEntity<Object> putSettingsSystemSettingById(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @GetExchange("ill/sharedIndexQuery")
  ResponseEntity<Object> getSharedIndexQuery(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/sharedIndexQuery/availability")
  ResponseEntity<Object> getSharedIndexQueryAvailability(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/sharedIndexQuery/byId")
  ResponseEntity<Object> getSharedIndexQueryById(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/sharedIndexQuery/byQuery")
  ResponseEntity<Object> getSharedIndexQueryByQuery(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/sharedIndexQuery/findMoreSuppliers")
  ResponseEntity<Object> getSharedIndexQueryFindMoreSuppliers(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/sharedIndexQuery/token")
  ResponseEntity<Object> postSharedIndexQueryToken(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @GetExchange("ill/shelvingLocationSites")
  ResponseEntity<Object> getShelvingLocationSites(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/shelvingLocationSites")
  ResponseEntity<Object> postShelvingLocationSites(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/shelvingLocationSites/{id}")
  ResponseEntity<Object> deleteShelvingLocationSitesById(
    @PathVariable("id") String id);

  @GetExchange("ill/shelvingLocationSites/{id}")
  ResponseEntity<Object> getShelvingLocationSitesById(
    @PathVariable("id") String id);

  @PutExchange("ill/shelvingLocationSites/{id}")
  ResponseEntity<Object> putShelvingLocationSitesById(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @GetExchange("ill/shelvingLocations")
  ResponseEntity<Object> getShelvingLocations(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/shelvingLocations")
  ResponseEntity<Object> postShelvingLocations(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/shelvingLocations/{id}")
  ResponseEntity<Object> deleteShelvingLocationsById(
    @PathVariable("id") String id);

  @GetExchange("ill/shelvingLocations/{id}")
  ResponseEntity<Object> getShelvingLocationsById(
    @PathVariable("id") String id);

  @PutExchange("ill/shelvingLocations/{id}")
  ResponseEntity<Object> putShelvingLocationsById(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @GetExchange("ill/shipments")
  ResponseEntity<Object> getShipments(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/shipments")
  ResponseEntity<Object> postShipments(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/shipments/{id}")
  ResponseEntity<Object> deleteShipmentsById(
    @PathVariable("id") String id);

  @GetExchange("ill/shipments/{id}")
  ResponseEntity<Object> getShipmentsById(
    @PathVariable("id") String id);

  @PutExchange("ill/shipments/{id}")
  ResponseEntity<Object> putShipmentsById(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @GetExchange("ill/stateModel/export")
  ResponseEntity<Object> getStateModelExport(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/stateModel/getValidActions")
  ResponseEntity<Object> getStateModelGetValidActions(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/stateModel/import")
  ResponseEntity<Object> postStateModelImport(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @GetExchange("ill/statistics")
  ResponseEntity<Object> getStatistics(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/statistics/forSymbol")
  ResponseEntity<Object> getStatisticsForSymbol(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/status")
  ResponseEntity<Object> getStatus(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/status/{id}")
  ResponseEntity<Object> getStatusById(
    @PathVariable("id") String id);

  @GetExchange("ill/swagger")
  ResponseEntity<Object> getSwagger(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/swagger/api")
  ResponseEntity<Object> getSwaggerApi(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/tags")
  ResponseEntity<Object> getTags(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/tags")
  ResponseEntity<Object> postTags(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @DeleteExchange("ill/tags/{id}")
  ResponseEntity<Object> deleteTagsById(
    @PathVariable("id") String id);

  @GetExchange("ill/tags/{id}")
  ResponseEntity<Object> getTagsById(
    @PathVariable("id") String id);

  @PutExchange("ill/tags/{id}")
  ResponseEntity<Object> putTagsById(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @GetExchange("ill/template")
  ResponseEntity<Object> getTemplate(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/template")
  ResponseEntity<Object> postTemplate(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @GetExchange("ill/template/createEditDetails")
  ResponseEntity<Object> getTemplateCreateEditDetails(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @DeleteExchange("ill/template/{id}")
  ResponseEntity<Object> deleteTemplateById(
    @PathVariable("id") String id);

  @GetExchange("ill/template/{id}")
  ResponseEntity<Object> getTemplateById(
    @PathVariable("id") String id);

  @PutExchange("ill/template/{id}")
  ResponseEntity<Object> putTemplateById(
    @PathVariable("id") String id,
    @RequestBody Object body);

  @PostExchange("ill/testDocumentDelivery/offer")
  ResponseEntity<Object> postTestDocumentDeliveryOffer(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @PostExchange("ill/testDocumentDelivery/register")
  ResponseEntity<Object> postTestDocumentDeliveryRegister(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @GetExchange("ill/testExternalSearch/locate")
  ResponseEntity<Object> getTestExternalSearchLocate(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/testExternalSearch/performSearch")
  ResponseEntity<Object> getTestExternalSearchPerformSearch(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/testHostLMS/acceptItem")
  ResponseEntity<Object> getTestHostLmsacceptItem(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/testHostLMS/checkIn")
  ResponseEntity<Object> getTestHostLmscheckIn(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/testHostLMS/checkOut")
  ResponseEntity<Object> getTestHostLmscheckOut(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/testHostLMS/determineBestLocation")
  ResponseEntity<Object> getTestHostLmsdetermineBestLocation(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/testHostLMS/directZ3950")
  ResponseEntity<Object> getTestHostLmsdirectZ3950(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/testHostLMS/validate")
  ResponseEntity<Object> getTestHostLmsvalidate(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/testRouting/findMoreSuppliers")
  ResponseEntity<Object> getTestRoutingFindMoreSuppliers(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @GetExchange("ill/timers")
  ResponseEntity<Object> getTimers(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @PostExchange("ill/timers")
  ResponseEntity<Object> postTimers(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats,
    @RequestBody Object body);

  @GetExchange("ill/timers/execute")
  ResponseEntity<Object> getTimersExecute(
    @RequestParam("term") String term,
    @RequestParam("match") String match,
    @RequestParam("filters") String filters,
    @RequestParam("sort") String sort,
    @RequestParam("max") Integer max,
    @RequestParam("perPage") Integer perPage,
    @RequestParam("offset") String offset,
    @RequestParam("page") Integer page,
    @RequestParam("stats") Boolean stats);

  @DeleteExchange("ill/timers/{id}")
  ResponseEntity<Object> deleteTimersById(@PathVariable("id") String id);

  @GetExchange("ill/timers/{id}")
  ResponseEntity<Object> getTimersById(@PathVariable("id") String id);

  @PutExchange("ill/timers/{id}")
  ResponseEntity<Object> putTimersById(@PathVariable("id") String id, @RequestBody Object body);
}
