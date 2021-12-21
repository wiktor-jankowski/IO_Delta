package pl.put.poznan.scenarioQualityChecker.logic;

import pl.put.poznan.scenarioQualityChecker.model.Step;

/**
 * CountingKeyWords  --- program to return number of all steps (sub-steps also) which doesn't have Actor
 *
 * @author Wiktor Jankowski
 */
public class CountingStepsWithoutActor extends VisitorForCounting {
    private int stepsNumber = 0;

    public int getStepsNumber() {
        return stepsNumber;
    }

    /**
     * Count every step which doesn't have Actor
     * Iterates through steps when invoked by AcceptCounting - method from Step class
     *
     * @param step visited step
     */
    public void count(Step step) {
        if (!isActor(step))
            stepsNumber++;
    }


    /**
     * Reset stepsNumber after successful counting
     */
    public void afterCounting() {
        stepsNumber = 0;
    }


    /**
     * Method check if list of Actors is empty
     *
     * @param step visited step
     * @return true if any Actor is present and false otherwise
     */
    private boolean isActor(Step step) {
        if (!step.getActor().equals(""))
            return true;

        return false;
    }
}
