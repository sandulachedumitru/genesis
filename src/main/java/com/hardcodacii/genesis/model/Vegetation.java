package com.hardcodacii.genesis.model;

/**
 * @author Dumitru Săndulache (sandulachedumitru@hotmail.com)
 */

public class Vegetation extends Entity {
    private int growthStage;

    public Vegetation(int x, int y) {
        super(x, y);
        this.growthStage = 0;
    }

    @Override
    public void act(Universe universe) {
        growthStage++;
        if (growthStage > 5) {
            growthStage = 5; // Max growth stage
        }

        System.out.println("Vegetation at (" + x + ", " + y + ") with growth stage: " + growthStage);
    }

    public boolean isEdible() {
        return growthStage == 5;
    }

    public void consume() {
        growthStage = 0; // Reset growth after consumption
    }
}
