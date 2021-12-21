package pl.put.poznan.scenarioQualityChecker.logic;

import pl.put.poznan.scenarioQualityChecker.model.Step;

/**
 * CountingAllSteps  --- program to return number of all steps (sub-steps also)
 *
 * @author Filip Kaczmarek
 */

public class CountingAllSteps extends VisitorForCounting {
    private int stepsNumber = 0;

    public int getStepsNumber() {
        return stepsNumber;
    }

    /**
     * Count every step
     * Iterates through steps when invoked by AcceptCounting - method from Step class
     *
     * @param step visited step
     */
    public void count(Step step) {
        stepsNumber++;
    }

    /**
     * Reset stepsNumber after successful counting
     */

    public void afterCounting() {
        stepsNumber = 0;
    }
}
