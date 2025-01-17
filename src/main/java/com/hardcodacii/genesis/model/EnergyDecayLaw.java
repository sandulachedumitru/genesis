package com.hardcodacii.genesis.model;

import com.hardcodacii.genesis.service.Law;

/**
 * @author Dumitru Săndulache (sandulachedumitru@hotmail.com)
 */

public class EnergyDecayLaw implements Law {

    @Override
    public void apply(Universe universe) {
        for (Entity entity : universe.getEntities()) {
            if (entity instanceof Organism organism) {
                organism.decreaseEnergy(1); // Decrease energy by 1 each step
            }
        }
    }
}
