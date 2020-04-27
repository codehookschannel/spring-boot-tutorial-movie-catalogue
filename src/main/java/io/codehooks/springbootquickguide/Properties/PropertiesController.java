package io.codehooks.springbootquickguide.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertiesController {

//    @Value("${io.codehooks.message}")
//    private String message;

//    @Autowired
//    Environment env;

    @Autowired
    private CodehooksProperties properties;

    @GetMapping
    public String getMessage() {
//        return message;
//        return env.getProperty("io.codehooks.message");
        return properties.getMessageRoot();
    }
}
