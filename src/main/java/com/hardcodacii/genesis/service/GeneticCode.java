package com.hardcodacii.genesis.service;

import lombok.Getter;

import java.util.Random;

/**
 * @author Dumitru Săndulache (sandulachedumitru@hotmail.com)
 */

public class GeneticCode {
    @Getter
    private final double[] neuralParameters;
    private final Random random;

    public GeneticCode() {
        this.random = new Random();
        this.neuralParameters = new double[5];
        initializeGenes();
    }

    private void initializeGenes() {
        for (int i = 0; i < neuralParameters.length; i++) {
            neuralParameters[i] = 0.5 + (random.nextDouble() - 0.5) * 0.1; // Random genes around 0.5
        }
    }

    public GeneticCode mutate() {
        GeneticCode mutatedCode = new GeneticCode();
        for (int i = 0; i < neuralParameters.length; i++) {
            mutatedCode.neuralParameters[i] = neuralParameters[i] + (random.nextDouble() - 0.5) * 0.01; // Small mutation
        }
        return mutatedCode;
    }

    public GeneticCode combine(GeneticCode other) {
        GeneticCode offspringGenetics = new GeneticCode();
        for (int i = 0; i < neuralParameters.length; i++) {
            offspringGenetics.neuralParameters[i] = (this.neuralParameters[i] + other.neuralParameters[i]) / 2
                    + (random.nextDouble() - 0.5) * 0.01; // Small mutation
        }
        return offspringGenetics;
    }
}
