package org.folio.edgeill.it;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.folio.edgeill.it.support.BaseIntegrationTest;
import org.folio.edgeill.support.types.IntegrationTest;
import org.folio.edgeill.support.wiremock.WireMockStub;
import org.junit.jupiter.api.Test;

@IntegrationTest
class TestDocumentDeliveryIT extends BaseIntegrationTest {

  @Test
  @WireMockStub("/wiremock/ill/test-document-delivery/200-post-offer.json")
  void testDocumentDeliveryOffer_positive_requiredFields() {
    given()
      .multiPart("systemId", "test-system-id")
      .multiPart("url", "https://doc-delivery.example.com")
      .multiPart("privateKey", "test-private-key")
      .multiPart("offerReference", "REF-001")
      .multiPart("pin", "1234")
      .multiPart("documentSecurityLevel", "NONE")
      .multiPart("attestationLevel", "SIMPLE")
      .when()
      .post("/illService/tenants/{tenantId}/testDocumentDelivery/offer", TENANT)
      .then()
      .statusCode(SC_OK)
      .body("offerURL", equalTo("https://example.com/offer/123"))
      .body("state", equalTo("PENDING"))
      .body("pin", equalTo("1234"))
      .body("workflow", equalTo("ILL"));
  }

  @Test
  @WireMockStub("/wiremock/ill/test-document-delivery/200-post-offer-with-file(all fields).json")
  void testDocumentDeliveryOffer_positive_allFields() {
    given()
      .multiPart("systemId", "test-system-id")
      .multiPart("url", "https://doc-delivery.example.com")
      .multiPart("privateKey", "test-private-key")
      .multiPart("offerReference", "REF-001")
      .multiPart("pin", "1234")
      .multiPart("documentSecurityLevel", "NONE")
      .multiPart("attestationLevel", "SIMPLE")
      .multiPart("documentTitle", "Example Document Title")
      .multiPart("patronEmail", "test_patron@sample.org")
      .multiPart("rawSourceMimeType", "application/pdf")
      .multiPart("workflow", "ILL")
      .multiPart("file", "test.pdf", "fake-pdf-content".getBytes(), "application/pdf")
      .when()
      .post("/illService/tenants/{tenantId}/testDocumentDelivery/offer", TENANT)
      .then()
      .statusCode(SC_OK)
      .body("offerURL", equalTo("https://example.com/offer/123"))
      .body("state", equalTo("PENDING"))
      .body("pin", equalTo("1234"))
      .body("workflow", equalTo("ILL"));
  }

  @Test
  void testDocumentDeliveryOffer_negative_missingRequiredValues() {
    given()
      .multiPart("systemId", "test-system-id")
      .when()
      .post("/illService/tenants/{tenantId}/testDocumentDelivery/offer", TENANT)
      .then()
      .statusCode(SC_BAD_REQUEST)
      .body("errors[0].code", is("VALIDATION_ERROR"))
      .body("errors[0].message", is("Required request parameter 'url' for method parameter type String is not present"))
      .body("errors[0].type", is("-1"));
  }

  @Test
  @WireMockStub("/wiremock/ill/test-document-delivery/200-post-register.json")
  void testDocumentDeliveryRegister_positive_allFields() {
    given()
      .multiPart("systemCode", "test-system-code")
      .multiPart("url", "https://doc-delivery.example.com")
      .multiPart("name", "Institution Name")
      .multiPart("attestationLevel", "SIMPLE")
      .when()
      .post("/illService/tenants/{tenantId}/testDocumentDelivery/register", TENANT)
      .then()
      .statusCode(SC_OK)
      .body("id", is("de783666-64a5-43d2-a0f3-63e8c8d5d3dd"))
      .body("status", is("PENDING"))
      .body("attestationType", is("SIMPLE"))
      .body("systemType", is("ILL"));
  }

  @Test
  void testDocumentDeliveryRegister_negative_missingRequiredValue() {
    given()
      .multiPart("systemCode", "test-system-code")
      .when()
      .post("/illService/tenants/{tenantId}/testDocumentDelivery/register", TENANT)
      .then()
      .statusCode(SC_BAD_REQUEST)
      .body("errors[0].code", is("VALIDATION_ERROR"))
      .body("errors[0].message", is("Required request parameter 'url' for method parameter type String is not present"))
      .body("errors[0].type", is("-1"));
  }
}
