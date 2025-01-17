package com.hardcodacii.genesis.model;

import com.hardcodacii.genesis.service.GeneticCode;
import lombok.Getter;

/**
 * @author Dumitru Săndulache (sandulachedumitru@hotmail.com)
 */

public abstract class Organism extends Entity {
    @Getter
    protected int energy;
    protected NeuralNetwork brain;
    protected GeneticCode geneticCode;

    public Organism(int x, int y, int energy, GeneticCode geneticCode) {
        super(x, y);
        this.energy = energy;
        this.geneticCode = geneticCode;
        this.brain = new NeuralNetwork(geneticCode.getNeuralParameters());
    }

    public void decreaseEnergy(int amount) {
        energy -= amount;
    }
}
