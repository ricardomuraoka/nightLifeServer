package br.pucpr.nightlifeserver.lib.security;

import br.pucpr.nightlifeserver.rest.users.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties("security")
@PropertySource("/security.properties")
@Data
@NoArgsConstructor @AllArgsConstructor
public class SecuritySettings {
    @NotBlank
    private String issuer;
    @NotBlank
    private String secret;

    private boolean testUserAllowed = false;
    private String token;
    private User testUser;
}
