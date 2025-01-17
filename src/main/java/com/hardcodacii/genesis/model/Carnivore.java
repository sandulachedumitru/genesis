package com.hardcodacii.genesis.model;

/**
 * @author Dumitru Săndulache (sandulachedumitru@hotmail.com)
 */

public class Carnivore extends Organism {
    public Carnivore(int x, int y, int energy) {
        super(x, y, energy);
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
