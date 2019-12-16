package ca.gc.aafc.seqdb.api.security.keycloak;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The KeycloakSpringBootConfigResolver needs to be defined in a separate file to get around startup errors.
 * See https://stackoverflow.com/a/57796450
 */
@Configuration
public class KeycloakSpringBootConfig {

  @Bean
  public KeycloakSpringBootConfigResolver keycloakConfigResolver() {
    return new KeycloakSpringBootConfigResolver();
  }

}
