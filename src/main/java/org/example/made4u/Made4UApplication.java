package org.example.made4u;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Made4UApplication {

    public static void main(String[] args) {
        SpringApplication.run(Made4UApplication.class, args);
    }

}
