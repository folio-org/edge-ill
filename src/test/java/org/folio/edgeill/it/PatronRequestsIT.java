package org.folio.edgeill.it;

import static io.restassured.RestAssured.given;
import static java.util.Collections.emptyList;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import io.restassured.http.ContentType;
import java.util.UUID;
import org.folio.edgeill.it.support.BaseIntegrationTest;
import org.folio.edgeill.support.types.IntegrationTest;
import org.folio.edgeill.support.wiremock.WireMockStub;
import org.junit.jupiter.api.Test;

@IntegrationTest
class PatronRequestsIT extends BaseIntegrationTest {

  private static final String PATRON_REQUEST_ID = UUID.randomUUID().toString();

  @Test
  @WireMockStub("/wiremock/ill/patron-requests/200-get(open-url+rft).json")
  void openUrl_positive_rftParams() {
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
  @WireMockStub("/wiremock/ill/patron-requests/200-put(agree-copyrights).json")
  void agreeCopyright_positive() {
    given()
      .when()
      .put("/illService/tenants/{tenantId}/patronrequests/{patronRequestId}/agreeCopyright", TENANT, PATRON_REQUEST_ID)
      .then()
      .statusCode(SC_OK)
      .body("id", equalTo(PATRON_REQUEST_ID));
  }

  @Test
  @WireMockStub("/wiremock/ill/patron-requests/200-get(fetch-copyright).json")
  void fetchCopyright_positive() {
    given()
      .when()
      .get("/illService/tenants/{tenantId}/patronrequests/{patronRequestId}/fetchCopyright", TENANT, PATRON_REQUEST_ID)
      .then()
      .statusCode(SC_OK)
      .body("id", equalTo(PATRON_REQUEST_ID))
      .body("result", equalTo("SUCCESS"))
      .body("errorCode", equalTo(null))
      .body("messages", equalTo(emptyList()))
      .body("copyright", equalTo("Test License Agreement"));
  }

  @Test
  @WireMockStub("/wiremock/ill/patron-requests/200-get(view-pdf-document).json")
  void viewDocument_positive_pdfDocument() {
    given()
      .when()
      .get("/illService/tenants/{tenantId}/patronrequests/{patronRequestId}/viewDocument", TENANT, PATRON_REQUEST_ID)
      .then()
      .statusCode(SC_OK)
      .contentType("application/pdf")
      .body(equalTo("Test License Agreement"));
  }

  @Test
  @WireMockStub("/wiremock/ill/patron-requests/200-get(view-text-document).json")
  void viewDocument_positive_textDocument() {
    given()
      .when()
      .get("/illService/tenants/{tenantId}/patronrequests/{patronRequestId}/viewDocument", TENANT, PATRON_REQUEST_ID)
      .then()
      .statusCode(SC_OK)
      .contentType(ContentType.TEXT)
      .body(equalTo("Test License Agreement"));
  }
}
