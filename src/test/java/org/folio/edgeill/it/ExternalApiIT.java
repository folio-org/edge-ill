package org.folio.edgeill.it;

import static io.restassured.RestAssured.given;
import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

import io.restassured.http.ContentType;
import org.folio.edgeill.it.support.BaseIntegrationTest;
import org.folio.edgeill.support.types.IntegrationTest;
import org.folio.edgeill.support.wiremock.WireMockStub;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

@IntegrationTest
class ExternalApiIT extends BaseIntegrationTest {

  @Test
  @WireMockStub("/wiremock/ill/external-api/200-get(directory-entry).json")
  void getDirectoryEntry_positive() {
    given()
      .when()
      .get("/illService/tenants/{tenantId}/externalApi/directoryEntry", TENANT)
      .then()
      .statusCode(SC_OK)
      .contentType(ContentType.JSON)
      .body("id", equalTo("29f56fcf-7f1d-4a4e-8ad4-d1e46a22c04f"))
      .body("slug", nullValue())
      .body("name", equalTo("Test Directory Entry"))
      .body("description", equalTo("Test Directory Entry Description"));
  }

  @Test
  @WireMockStub("/wiremock/ill/external-api/200-get(directory-entry+slug).json")
  void getDirectoryEntry_positive_withSlug() {
    given()
      .param("slug", "de-slug")
      .when()
      .get("/illService/tenants/{tenantId}/externalApi/directoryEntry", TENANT)
      .then()
      .statusCode(SC_OK)
      .contentType(ContentType.JSON)
      .body("id", equalTo("29f56fcf-7f1d-4a4e-8ad4-d1e46a22c04f"))
      .body("slug", equalTo("de-slug"))
      .body("name", equalTo("Test Directory Entry"))
      .body("description", equalTo("Test Directory Entry Description"));
  }

  @Test
  @WireMockStub("/wiremock/ill/external-api/200-get(iso-18626).json")
  void postIso18626_positive() {
    given()
      .body("{\"request\":\"iso-18626\"}")
      .contentType(ContentType.JSON)
      .when()
      .post("/illService/tenants/{tenantId}/externalApi/iso18626", TENANT)
      .then()
      .statusCode(SC_OK)
      .contentType(ContentType.XML)
      .body(Matchers.containsString("ISO18626Message"));
  }

  @Test
  @WireMockStub("/wiremock/ill/external-api/200-get(statistics).json")
  void getStatistics_positive_emptyParameters() {
    given()
      .when()
      .get("/illService/tenants/{tenantId}/externalApi/statistics", TENANT)
      .then()
      .statusCode(SC_OK)
      .contentType(ContentType.JSON)
      .body("asAt", equalTo(1783097532920L))
      .body("current", equalTo(emptyList()))
      .body("requestsByState", equalTo(emptyMap()))
      .body("requestsByTag", equalTo(emptyMap()))
      .body("error", nullValue());
  }

  @Test
  @WireMockStub("/wiremock/ill/external-api/200-get(statistics+symbol).json")
  void getStatistics_positive_withSymbol() {
    given()
      .param("symbol", "authority:symbol")
      .when()
      .get("/illService/tenants/{tenantId}/externalApi/statistics", TENANT)
      .then()
      .statusCode(SC_OK)
      .contentType(ContentType.JSON)
      .body("asAt", equalTo(1783097532920L))
      .body("current", equalTo(emptyList()))
      .body("requestsByState", equalTo(emptyMap()))
      .body("requestsByTag", equalTo(emptyMap()))
      .body("error", nullValue());
  }

  @Test
  @WireMockStub("/wiremock/ill/external-api/200-get(status-report).json")
  void getStatusReport_positive() {
    given()
      .when()
      .get("/illService/tenants/{tenantId}/externalApi/statusReport", TENANT)
      .then()
      .statusCode(SC_OK)
      .contentType(ContentType.JSON)
      .body("institutions", equalTo(emptyList()));
  }
}
