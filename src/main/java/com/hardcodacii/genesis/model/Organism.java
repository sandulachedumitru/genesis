package com.hardcodacii.genesis.model;

/**
 * @author Dumitru Săndulache (sandulachedumitru@hotmail.com)
 */

public abstract class Organism extends Entity {
    protected int energy;
    protected NeuralNetwork brain;

    public Organism(int x, int y, int energy) {
        super(x, y);
        this.energy = energy;
        this.brain = new NeuralNetwork();
    }

    public void decreaseEnergy(int amount) {
        energy -= amount;
    }
}
