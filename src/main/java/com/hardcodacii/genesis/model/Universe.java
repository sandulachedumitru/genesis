package com.hardcodacii.genesis.model;


import com.hardcodacii.genesis.service.Law;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dumitru Săndulache (sandulachedumitru@hotmail.com)
 */

@Component
@Getter
public class Universe {
    private final int width;
    private final int height;
    private final List<Entity> entities;
    private final List<Law> laws;

    public Universe() {
        this.width = 10; // Can be externalized to application.properties
        this.height = 10; // Can be externalized to application.properties
        this.entities = new ArrayList<>();
        this.laws = new ArrayList<>();

        // Add entities
        entities.add(new Herbivore(5, 5, 10));
        entities.add(new Carnivore(2, 2, 15));
        entities.add(new Vegetation(7, 7));
        entities.add(new Vegetation(3, 3));

        // Add laws
        laws.add(new EnergyDecayLaw());
    }

    public void simulateStep() {
        for (Law law : laws) {
            law.apply(this);
        }
        for (Entity entity : entities) {
            entity.act(this);
        }
    }
}
