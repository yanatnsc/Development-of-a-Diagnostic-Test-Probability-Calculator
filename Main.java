import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double prevalence = -1;
        double sensitivity = -1;
        double specificity = -1;

        // Validate prevalence input
        while (prevalence < 0 || prevalence > 1) {
            System.out.print("Enter the prevalence of the disease (P(Disease)) as a value between 0 and 1: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid number between 0 and 1.");
                scanner.next(); // Clear the invalid input
            }
            prevalence = scanner.nextDouble();
            if (prevalence < 0 || prevalence > 1) {
                System.out.println("Please enter a value between 0 and 1.");
            }
        }

        // Validate sensitivity input
        while (sensitivity < 0 || sensitivity > 1) {
            System.out.print("Enter the sensitivity of the test (P(Test+|Disease+)) as a value between 0 and 1: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid number between 0 and 1.");
                scanner.next(); // Clear the invalid input
            }
            sensitivity = scanner.nextDouble();
            if (sensitivity < 0 || sensitivity > 1) {
                System.out.println("Please enter a value between 0 and 1.");
            }
        }

        // Validate specificity input
        while (specificity < 0 || specificity > 1) {
            System.out.print("Enter the specificity of the test (P(Test-|Disease-)) as a value between 0 and 1: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid number between 0 and 1.");
                scanner.next(); // Clear the invalid input
            }
            specificity = scanner.nextDouble();
            if (specificity < 0 || specificity > 1) {
                System.out.println("Please enter a value between 0 and 1.");
            }
        }

        // Calculate probabilities
        double pDiseaseGivenPositive = probabilityDiseaseGivenPositive(prevalence, sensitivity, specificity);
        double pDiseaseGivenNegative = probabilityDiseaseGivenNegative(prevalence, sensitivity, specificity);

        // Display results
        System.out.printf("Probability of having the disease given a positive test result: %.4f%n", pDiseaseGivenPositive);
        System.out.printf("Probability of having the disease given a negative test result: %.4f%n", pDiseaseGivenNegative);

        scanner.close();
    }

    // Method to calculate probability of having the disease given a positive test result
    public static double probabilityDiseaseGivenPositive(double prevalence, double sensitivity, double specificity) {
        double pDisease = prevalence;
        double pTestPositiveGivenDisease = sensitivity;
        double pTestPositiveGivenNoDisease = 1 - specificity;

        double pPositive = pTestPositiveGivenDisease * pDisease + pTestPositiveGivenNoDisease * (1 - pDisease);

        return (pTestPositiveGivenDisease * pDisease) / pPositive;
    }

    // Method to calculate probability of having the disease given a negative test result
    public static double probabilityDiseaseGivenNegative(double prevalence, double sensitivity, double specificity) {
        double pDisease = prevalence;
        double pTestNegativeGivenDisease = 1 - sensitivity;
        double pTestNegativeGivenNoDisease = specificity;

        double pNegative = pTestNegativeGivenDisease * pDisease + pTestNegativeGivenNoDisease * (1 - pDisease);

        return (pTestNegativeGivenDisease * pDisease) / pNegative;
    }

    // In-class example:
    // P(Disease) = 0.01
    // P(Test+|Disease+) = 0.99
    // P(Test+|Disease-) = 0.05 ==> P(Test-|Disease-) = 0.95
    // Posterior Prob P(Disease+|Test+) = 0.167
}
