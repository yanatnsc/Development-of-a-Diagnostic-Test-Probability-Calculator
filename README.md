# Development-of-a-Diagnostic-Test-Probability-Calculator
An application that allows a user to input the prevalence of a disease, the sensitivity of a diagnostic test, and the specificity of the test. The application will then compute and display the probability of the disease given the test result.

## Background:
Medical diagnostics rely heavily on accurately interpreting test results. Bayes' Theorem provides a mathematical basis for updating probabilities based on test outcomes. Your application will assist medical professionals by providing immediate calculations of disease probability based on their input values.

## Mehods:

### probabilityDiseaseGivenPositive(double prevalence, double sensitivity, double specificity)
Calculates the probability of having the disease if tested positive

### probabilityDiseaseGivenNegative(double prevalence, double sensitivity, double specificity)
Calculates the probability of having the disease if tested negative

### Main method including user input and display the results
Users should provide inputs for:
Prevalence of the disease (Prior probability, P(Disease))
Probability of testing positive given having the disease (Sensitivity, P(Test+|Disease+))
Probability of testing negative given not having the disease (Specificity, P(Test-|Disease-))
