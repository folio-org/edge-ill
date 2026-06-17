package org.folio.edgeill.service;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.stereotype.Service;

/**
 * Service for the Report domain, delegating report creation, execution and picklist generation
 * to mod-ill via {@link IllClient}.
 */
@Service
@RequiredArgsConstructor
public class ReportService {

  private final IllClient illClient;

  /**
   * Creates or updates a report in mod-ill.
   *
   * @return the create/update response from mod-ill
   */
  public Object reportCreateUpdate() {
    return illClient.postReportCreateUpdate(null, null, null, null, null, null, null, null, null);
  }

  /**
   * Executes the specified report in mod-ill and returns its byte content.
   *
   * @return the report execution response from mod-ill
   */
  public Object reportExecute() {
    return illClient.getReportExecute(null, null, null, null, null, null, null, null, null);
  }

  /**
   * Executes the picklist report in mod-ill and returns its byte content.
   *
   * @return the picklist report response from mod-ill
   */
  public Object reportGeneratePicklist() {
    return illClient.getReportGeneratePicklist(null, null, null, null, null, null, null, null, null);
  }
}
