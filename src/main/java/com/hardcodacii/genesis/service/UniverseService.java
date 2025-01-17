package com.hardcodacii.genesis.service;

import com.hardcodacii.genesis.model.Universe;
import org.springframework.stereotype.Service;

/**
 * @author Dumitru Săndulache (sandulachedumitru@hotmail.com)
 */

@Service
public class UniverseService {
    private final Universe universe;

    public UniverseService(Universe universe) {
        this.universe = universe;
    }

    public void runSimulation(int steps) {
        for (int i = 0; i < steps; i++) {
            System.out.println("Step: " + (i + 1));
            universe.simulateStep();
        }
    }
}
