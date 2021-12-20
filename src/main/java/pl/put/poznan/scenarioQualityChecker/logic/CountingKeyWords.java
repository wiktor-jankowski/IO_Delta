package pl.put.poznan.scenarioQualityChecker.logic;

import pl.put.poznan.scenarioQualityChecker.model.Step;

import java.util.ArrayList;

/**
 * CountingKeyWords  --- program to return number of all steps (sub-steps also) which started with "IF", "FOR EACH" or "ELSE"
 *
 * @author Radek Dudek
 */

public class CountingKeyWords extends VisitorForCounting {
    private int stepsNumber = 0;

    public int getStepsNumber() {
        return stepsNumber;
    }


    /**
     * Count every step which start with Key Words
     * Iterates through steps when invoked by AcceptCounting - method from Step class
     *
     * @param step visited step
     */

    public void count(Step step) {
        if (isKeyword(step))
            stepsNumber++;
    }

    /**
     * Reset stepsNumber after successful counting
     */
    public void afterCounting() {
        stepsNumber = 0;
    }

    /**
     * Method check if one of Key Words is present
     *
     * @param step visited step
     * @return true if Key Word present and false otherwise
     */
    private static boolean isKeyword(Step step) {
        ArrayList<String> content = step.getRule();
        return content.get(0).equals("IF") || content.get(0).equals("FOR EACH") || content.get(0).equals("ELSE");
    }
}

