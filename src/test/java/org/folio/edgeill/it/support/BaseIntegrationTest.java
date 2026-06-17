package org.folio.edgeill.it.support;

import org.folio.edgeill.support.wiremock.WithWiremockContainer;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@ActiveProfiles("it")
@AutoConfigureMockMvc
@WithWiremockContainer
public class BaseIntegrationTest {

  protected static final String TENANT = "test_tenant";
  protected static final String API_USERNAME = "user";
  protected static MockMvc mockMvc;

  @BeforeAll
  static void setupMockMvc(@Autowired MockMvc mockMvc) {
    BaseIntegrationTest.mockMvc = mockMvc;
  }
}
