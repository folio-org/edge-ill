package org.folio.edgeill.it.support;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import io.restassured.RestAssured;
import org.folio.edgeill.support.wiremock.WithWiremockContainer;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("it")
@WithWiremockContainer
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class BaseIntegrationTest {

  protected static final String TENANT = "test_tenant";
  protected static final String API_USERNAME = "user";

  @LocalServerPort
  private int port;

  @BeforeEach
  void configureRestAssured() {
    RestAssured.port = port;
    RestAssured.baseURI = "http://localhost";
    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
  }
}


