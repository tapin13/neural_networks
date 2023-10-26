package com.company;

public class Main {

    public static void main(String[] args) {
        // data for AND
	    final int[][] TRAINING_DATA = {
            // x1, x2, result of bitwise 'and' operation
            { 0, 0, 0 },
            { 0, 1, 0 },
            { 1, 0, 0 },
            { 1, 1, 1 },
        };

        // data for OR
//        final int[][] TRAINING_DATA = {
//                // x1, x2, result of bitwise 'and' operation
//                { 0, 0, 0 },
//                { 0, 1, 1 },
//                { 1, 0, 1 },
//                { 1, 1, 1 },
//        };

        final double LEARNING_RATE = 0.05;
        double[] weights = {
                Math.random(), Math.random()
//                0.4, 0.5
        };
        int epoch = 0;
        boolean errorFlag = true;

        Perceptron perceptron = new Perceptron();

        while (errorFlag) {
            System.out.println("*** epoch: " + epoch + " ***");

            errorFlag = false;
            for(int i = 0; i < TRAINING_DATA.length; i++) {
                int[] data = TRAINING_DATA[i];

                double sum = perceptron.calcSum(weights, data);
                int out = perceptron.activation(sum);
                int error = data[2] - out;

                if(error != 0) {
                    errorFlag = true;
                    weights = perceptron.adjustWeight(weights, data, error, LEARNING_RATE);
                }

                System.out.println(
                        "data: " + data[0] + ", " + data[1]
                        + " ~ sum: " + sum
                        + " ~ out: " + out
                        + " ~ error: " + error
                        + " ~ weight: " + weights[0] + ", " + weights[1]
                    );
            }

            epoch++;
        }
    }

}
