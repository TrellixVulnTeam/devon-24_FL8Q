package io.oasp.module.service.common.impl.header;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import io.oasp.module.service.common.api.config.ServiceConfig;
import io.oasp.module.service.common.api.header.ServiceHeaderContext;
import io.oasp.module.service.common.api.header.ServiceHeaderCustomizer;

/**
 * @author ssarmoka
 *
 */
public class ServiceHeaderCustomizerAuthForward implements ServiceHeaderCustomizer {

  private static final String AUTHORIZATION = "Authorization";

  /**
   *
   * The constructor.
   */
  public ServiceHeaderCustomizerAuthForward() {
    super();
  }

  @Override
  public void addHeaders(ServiceHeaderContext<?> context) {

    String auth = context.getConfig().getChildValue(ServiceConfig.KEY_SEGMENT_AUTH);
    if (!ServiceConfig.VALUE_AUTH_FORWARD.equals(auth)) {
      return;
    }
    SecurityContext securityContext = SecurityContextHolder.getContext();
    if (securityContext == null) {
      return;
    }
    String authorizationHeader = context.getConfig().getChildValue(AUTHORIZATION);
    context.setHeader(AUTHORIZATION, authorizationHeader);

  }

}
