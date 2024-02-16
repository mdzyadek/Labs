package mdzyadek.labs.LR2;

import java.util.Random;
import java.util.Scanner;

public class GenerateMatrix {

    public static final int MAX_MATRIX_DIMENSION = 20;
    public static final int MATRIX_MAX_RANDOM_VALUE = 999;
    public static final int MATRIX_MIN_RANDOM_VALUE = -999;

    public static int findMaxElement(int[][] inputMatrix) {
        int maxElement = inputMatrix[0][0];

        for (int[] matrix : inputMatrix) {
            for (int i : matrix) {
                if (i > maxElement) {
                    maxElement = i;
                }
            }
        }
        return maxElement;
    }

    public static int findMinElement(int[][] inputMatrix) {
        int minElement = inputMatrix[0][0];

        for (int[] matrix : inputMatrix) {
            for (int i : matrix) {
                if (i < minElement) {
                    minElement = i;
                }
            }
        }
        return minElement;
    }

    public static float findAverage(int[][] inputMatrix) {
        float sumOfNums = 0;
        for (int[] matrix : inputMatrix) {
            for (int i : matrix) {
                sumOfNums += i;
            }

        }
        return sumOfNums / (inputMatrix.length * inputMatrix[0].length);
    }

    public static double findGeometricMean(int[][] inputMatrix) {
        int productOfNumbers = 1;
        for (int[] matrix : inputMatrix) {
            for (int i : matrix) {
                productOfNumbers *= i;
            }
        }
        if (productOfNumbers > 0) {
            return Math.pow(productOfNumbers, (double) 1 / (inputMatrix.length * inputMatrix[0].length));
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {

        Random randomNums = new Random();
        Scanner scanner = new Scanner(System.in);
        int matrixWidth;
        int matrixHeight;
        System.out.println("Hello. Do You wanna use random (type 1) or manual (type 2)?");
        int typeOfInput = scanner.nextInt();

        while (true) {
            System.out.println("Input the width of matrix:");
            matrixWidth = scanner.nextInt();
            if (1 > matrixWidth | matrixWidth > MAX_MATRIX_DIMENSION) {
                System.out.println("Please, input matrix width in range 1 to 20!");
                continue;
            } else {
                break;
            }
        }

        while (true) {
            System.out.println("Input the height of matrix:");
            matrixHeight = scanner.nextInt();
            if (1 > matrixHeight | matrixHeight > MAX_MATRIX_DIMENSION) {
                System.out.println("Please, input matrix height in range 1 to 20!");
                continue;
            } else {
                break;
            }
        }
        int[][] inputMatrix = new int[matrixHeight][matrixWidth];

        if (typeOfInput == 1) {
            for (int i = 0; i < matrixHeight; i++) {
                for (int j = 0; j < matrixWidth; j++) {
                    inputMatrix[i][j] = randomNums.nextInt(MATRIX_MAX_RANDOM_VALUE - MATRIX_MIN_RANDOM_VALUE)
                            + MATRIX_MIN_RANDOM_VALUE;
                }
            }
        } else {
            System.out.println("Manual inputting...");
            for (int i = 0; i < matrixHeight; i++) {
                for (int j = 0; j < matrixWidth; j++) {
                    String str = String.format("Input the [%s][%s] element of matrix:", i, j);
                    System.out.println(str);
                    int element = scanner.nextInt();
                    inputMatrix[i][j] = element;
                }
            }
        }
        for (int i = 0; i < matrixHeight; i++) {
            for (int j = 0; j < matrixWidth; j++) {
                System.out.print(inputMatrix[i][j] + " ");
            }
            System.out.println();
        }

        int maxElement = findMaxElement(inputMatrix);
        int minElement = findMinElement(inputMatrix);
        float average = findAverage(inputMatrix);
        double geometricMean = findGeometricMean(inputMatrix);
        System.out.printf("Max element of matrix is %s%n", maxElement);
        System.out.printf("Min element of matrix is %s%n", minElement);
        System.out.printf("Average is %s%n", average);
        if (geometricMean > 0) {
            System.out.printf("Geometric mean is %s%n", geometricMean);
        } else {
            System.out.println("It is impossible to calculate the geometric mean!");
        }
    }
}
