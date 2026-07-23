package org.folio.edgeill.configuration;

import lombok.RequiredArgsConstructor;
import org.folio.edgeill.integration.IllClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
@RequiredArgsConstructor
public class HttpExchangeConfiguration {

  @Qualifier("edgeHttpServiceProxyFactory")
  private final HttpServiceProxyFactory factory;

  /**
   * Creates a {@link IllClient} bean.
   *
   * @return the {@link IllClient} instance
   */
  @Bean
  public IllClient illClient() {
    return factory.createClient(IllClient.class);
  }
}
