package org.folio.edgeill.it;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;
import static org.folio.edge.core.utils.ApiKeyUtils.generateApiKey;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import java.util.UUID;
import org.folio.edgeill.it.support.BaseIntegrationTest;
import org.folio.edgeill.support.types.IntegrationTest;
import org.folio.edgeill.support.wiremock.WireMockStub;
import org.junit.jupiter.api.Test;

@IntegrationTest
class PatronRequestsIT extends BaseIntegrationTest {

  @Test
  @WireMockStub(value = {
    "/wiremock/ill/patron-requests/200-openURL(rft).json",
  })
  void getOpenUrl_positive_rftParams() {
    given()
      .queryParam("rft.artnum", "artnum123456")
      .queryParam("rft.atitle", "Example Article Title")
      .queryParam("rft.aufirst", "John")
      .queryParam("rft.aulast", "Doe")
      .queryParam("rft.bici", "Journal of Testing, Vol. 10, No. 2, 2024")
      .when()
      .get("/illService/tenants/{tenantId}/patronrequests/openURL", TENANT)
      .then()
      .statusCode(SC_OK)
      .body("result", equalTo("SUCCESS"))
      .body("id", notNullValue())
      .body("messages", equalTo(null));
  }

  @Test
  @WireMockStub(value = {
    "/wiremock/authn/201-post(system_login).json",
    "/wiremock/ill/patron-requests/200-get-by-id.json",
  })
  void getPatronRequestById_positive() {
    var patronRequestId = UUID.randomUUID().toString();
    given()
      .queryParam("apikey", generateApiKey(10, TENANT, API_USERNAME))
      .when()
      .get("/illService/patronrequests/{patronRequestId}", patronRequestId)
      .then()
      .statusCode(SC_OK)
      .body("id", equalTo(patronRequestId));
  }

  @Test
  void getPatronRequestById_negative_unauthorized() {
    var patronRequestId = UUID.randomUUID().toString();
    given()
      .when()
      .get("/illService/patronrequests/{patronRequestId}", patronRequestId)
      .then()
      .statusCode(SC_UNAUTHORIZED)
      .body("error", equalTo("Unauthorized"))
      .body("path", equalTo("/illService/patronrequests/%s".formatted(patronRequestId)));
  }
}
