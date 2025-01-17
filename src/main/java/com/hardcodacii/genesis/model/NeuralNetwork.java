package com.hardcodacii.genesis.model;

import lombok.Getter;

import java.util.Random;

/**
 * @author Dumitru Săndulache (sandulachedumitru@hotmail.com)
 */

public class NeuralNetwork {
    private final double[] inputs;
    private final double[] weights;
    private final Random random;
    @Getter
    private NeuronDevelopmentStage stage;

    public NeuralNetwork() {
        this.inputs = new double[5]; // Updated for detailed senses
        this.weights = new double[5]; // Weights for decision-making
        this.random = new Random();
        this.stage = NeuronDevelopmentStage.PROLIFERATION;
        initializeWeights();
    }

    private void initializeWeights() {
        for (int i = 0; i < weights.length; i++) {
            weights[i] = random.nextDouble(); // Random initial weights
        }
    }

    public void setInputs(double[] inputs) {
        if (inputs.length != this.inputs.length) {
            throw new IllegalArgumentException("Input size mismatch.");
        }
        System.arraycopy(inputs, 0, this.inputs, 0, inputs.length);
    }

    public double[] getOutputs() {
        if (stage != NeuronDevelopmentStage.SYNAPTOGENESIS) {
            throw new IllegalStateException("Neuron is not fully developed.");
        }
        double[] outputs = new double[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            outputs[i] = inputs[i] * weights[i];
        }
        return outputs;
    }

    public void progressDevelopment() {
        switch (stage) {
            case PROLIFERATION:
                stage = NeuronDevelopmentStage.DIFFERENTIATION;
                break;
            case DIFFERENTIATION:
                stage = NeuronDevelopmentStage.MYELINATION;
                break;
            case MYELINATION:
                stage = NeuronDevelopmentStage.SYNAPTOGENESIS;
                break;
            case SYNAPTOGENESIS:
                // Fully developed
                break;
        }
    }
}
