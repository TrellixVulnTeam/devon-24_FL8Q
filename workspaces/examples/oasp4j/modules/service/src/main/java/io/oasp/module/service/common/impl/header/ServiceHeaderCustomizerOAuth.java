package io.oasp.module.service.common.impl.header;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import io.oasp.module.logging.common.api.LoggingConstants;
import io.oasp.module.service.common.api.config.ServiceConfig;
import io.oasp.module.service.common.api.header.ServiceHeaderContext;
import io.oasp.module.service.common.api.header.ServiceHeaderCustomizer;

/**
 * Implementation of {@link ServiceHeaderCustomizer} that passes the {@link LoggingConstants#CORRELATION_ID} to a
 * subsequent {@link io.oasp.module.service.common.api.Service} invocation.
 *
 * @since 3.0.0
 */
public class ServiceHeaderCustomizerOAuth implements ServiceHeaderCustomizer {

  /**
   * The constructor.
   */
  public ServiceHeaderCustomizerOAuth() {

    super();
  }

  @Override
  public void addHeaders(ServiceHeaderContext<?> context) {

    String auth = context.getConfig().getChildValue(ServiceConfig.KEY_SEGMENT_AUTH);
    if (!"oauth".equals(auth)) {
      return;
    }
    SecurityContext securityContext = SecurityContextHolder.getContext();
    if (securityContext == null) {
      return;
    }
    Authentication authentication = securityContext.getAuthentication();
    if (authentication == null) {
      return;
    }
    Object details = authentication.getDetails();
    if (!(details instanceof Map)) {
      return;
    }
    Map<?, ?> map = (Map<?, ?>) details;
    Object oauthToken = map.get("oauth.token");
    if (oauthToken == null) {
      return;
    }
    String authorizationHeader = "Bearer " + oauthToken;
    context.setHeader("Authorization", authorizationHeader);
  }

}
