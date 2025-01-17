package com.hardcodacii.genesis.model;

import com.hardcodacii.genesis.service.GeneticCode;

import java.util.Optional;

/**
 * @author Dumitru Săndulache (sandulachedumitru@hotmail.com)
 */

public class Herbivore extends Organism {
    public Herbivore(int x, int y, int energy, GeneticCode geneticCode) {
        super(x, y, energy, geneticCode);
    }

    @Override
    public void act(Universe universe) {
        brain.progressDevelopment();
        if (brain.getStage() != NeuronDevelopmentStage.SYNAPTOGENESIS) {
            System.out.println("Herbivore's brain is developing: " + brain.getStage());
            return;
        }

        double[] perception = perceive(universe);
        brain.setInputs(perception);
        double[] decisions = brain.getOutputs();

        x += (int) Math.round(decisions[0]);
        y += (int) Math.round(decisions[1]);

        x = Math.max(0, Math.min(universe.getWidth() - 1, x));
        y = Math.max(0, Math.min(universe.getHeight() - 1, y));

        if (energy > 15) {
            searchMateAndReproduce(universe);
        }

        System.out.println("Herbivore at (" + x + ", " + y + ") with energy: " + energy);
    }

    private double[] perceive(Universe universe) {
        double visualInput = universe.getEntities().stream()
                .filter(e -> e instanceof Vegetation && Math.abs(e.getX() - x) <= 3 && Math.abs(e.getY() - y) <= 3)
                .count();

        double auditoryInput = universe.getEntities().stream()
                .filter(e -> e instanceof Carnivore && Math.abs(e.getX() - x) <= 5 && Math.abs(e.getY() - y) <= 5)
                .count();

        double tactileInput = universe.getEntities().stream()
                .filter(e -> e instanceof Vegetation && Math.abs(e.getX() - x) <= 1 && Math.abs(e.getY() - y) <= 1)
                .count();

        return new double[]{visualInput, auditoryInput, tactileInput, energy / 20.0};
    }

    private void searchMateAndReproduce(Universe universe) {
        Optional<Entity> potentialMate = universe.getEntities().stream()
                .filter(e -> e instanceof Herbivore && e != this)
                .findFirst();

        if (potentialMate.isPresent()) {
            Herbivore mate = (Herbivore) potentialMate.get();
            if (Math.abs(mate.getX() - this.x) <= 1 && Math.abs(mate.getY() - this.y) <= 1) {
                System.out.println("Herbivore reproduces with a mate at (" + x + ", " + y + ")");
                GeneticCode offspringGenetics = geneticCode.combine(mate.geneticCode);
                Herbivore offspring = new Herbivore(x, y, 10, offspringGenetics);
                universe.addEntity(offspring);
                this.energy -= 5;
                mate.energy -= 5;
            }
        }
    }
}
