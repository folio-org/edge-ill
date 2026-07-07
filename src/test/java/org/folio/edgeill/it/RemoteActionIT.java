package org.folio.edgeill.it;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.http.ContentType;
import java.util.UUID;
import org.folio.edgeill.it.support.BaseIntegrationTest;
import org.folio.edgeill.support.types.IntegrationTest;
import org.folio.edgeill.support.wiremock.WireMockStub;
import org.junit.jupiter.api.Test;

@IntegrationTest
class RemoteActionIT extends BaseIntegrationTest {

  @Test
  @WireMockStub("/wiremock/ill/remote-action/200-get(remote-action).json")
  void getExternalApiDirectoryEntry_positive() {
    var remoteActionId = UUID.randomUUID().toString();
    given()
      .when()
      .get("/illService/tenants/{tenantId}/remoteAction/{id}/perform", TENANT, remoteActionId)
      .then()
      .statusCode(SC_OK)
      .contentType(ContentType.TEXT)
      .body(equalTo("Action Text"));
  }

  @Test
  @WireMockStub("/wiremock/ill/remote-action/400-get(remote-action).json")
  void getExternalApiDirectoryEntry_negative_notFound() {
    var remoteActionId = UUID.randomUUID().toString();
    given()
      .when()
      .get("/illService/tenants/{tenantId}/remoteAction/{id}/perform", TENANT, remoteActionId)
      .then()
      .statusCode(SC_BAD_REQUEST)
      .contentType(ContentType.JSON)
      .body("actionResult", equalTo("INVALID_PARAMETERS"))
      .body("message", equalTo("Unable to find remote action with id: " + remoteActionId))
      .body("status", equalTo(false))
      .body("code", equalTo(0));
  }
}
