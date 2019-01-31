package com.naya.gameofthrones.signuterdecoderinformer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SignuterDecoderInformerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SignuterDecoderInformerApplication.class, args);
    }

}

