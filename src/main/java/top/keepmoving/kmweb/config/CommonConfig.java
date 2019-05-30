package top.keepmoving.kmweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * <p>@Author:Vince
 * <p>@Date:2019-03-07
 * <p>@Description:
 */
@Configuration
@EnableJpaRepositories(basePackages = "top.keepmoving.kmweb.domain")
public class CommonConfig {
}
