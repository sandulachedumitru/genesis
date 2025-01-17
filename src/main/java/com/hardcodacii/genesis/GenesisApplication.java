package com.hardcodacii.genesis;

import com.hardcodacii.genesis.service.UniverseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GenesisApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenesisApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UniverseService universeService) {
        return args -> {
            universeService.runSimulation(10);
        };
    }
}
