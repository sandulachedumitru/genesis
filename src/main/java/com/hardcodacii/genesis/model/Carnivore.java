package com.hardcodacii.genesis.model;

import com.hardcodacii.genesis.service.GeneticCode;

/**
 * @author Dumitru Săndulache (sandulachedumitru@hotmail.com)
 */

public class Carnivore extends Organism {
    public Carnivore(int x, int y, int energy, GeneticCode geneticCode) {
        super(x, y, energy, geneticCode);
    }

    @Override
    public void act(Universe universe) {
        Herbivore target = null;
        for (Entity entity : universe.getEntities()) {
            if (entity instanceof Herbivore) {
                target = (Herbivore) entity;
                break;
            }
        }

        if (target != null) {
            if (x < target.getX()) x++;
            else if (x > target.getX()) x--;

            if (y < target.getY()) y++;
            else if (y > target.getY()) y--;

            if (x == target.getX() && y == target.getY()) {
                System.out.println("Carnivore ate a herbivore at (" + x + ", " + y + ")!");
                universe.getEntities().remove(target);
                energy += 5; // Gain energy by eating
            }
        }

        energy--;

        System.out.println("Carnivore at (" + x + ", " + y + ") with energy: " + energy);
    }
}
