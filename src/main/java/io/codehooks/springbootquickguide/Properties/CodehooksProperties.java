package io.codehooks.springbootquickguide.Properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
@Data
@ConfigurationProperties(prefix = "io.codehooks")
public class CodehooksProperties {

    @NotNull
    private String message;
    private String messageRoot;
}
