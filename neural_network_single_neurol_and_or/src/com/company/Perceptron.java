package com.company;

public class Perceptron {
    public static int activation(double i) {
        if(i > 1) {
            return 1;
        }

        return 0;
    }

    public static double calcSum(double[] weights, int[] data) {
        double sum = 0;
        for(int i = 0; i < weights.length; i++) {
            sum += weights[i] * data[i];
        }

        return sum;
    }

    public static double[] adjustWeight(double[] weights, int[] data, int error, double learningRate) {
        double[] adjustedWeights = new double[weights.length];

        for(int i = 0; i < weights.length; i++) {
            adjustedWeights[i] = learningRate * error + weights[i];
        }

        return adjustedWeights;
    }
}
