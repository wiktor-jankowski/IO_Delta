package pl.put.poznan.scenarioQualityChecker.logic;

import pl.put.poznan.scenarioQualityChecker.model.Step;

/**
 * DisplayingStepsWithoutActors  --- program to show steps (sub-steps also) which doesn't have Actor
 *
 * @author Wiktor Jankowski
 */
public class DisplayingStepsWithoutActors extends VisitorForDisplaying {
    private String scenarioText = ""; // displayed text after reading .JSON

    public String getScenarioText() {
        return scenarioText;
    }

    public void setScenarioText(String scenarioText) {
        this.scenarioText = scenarioText;
    }

    /**
     * Displays steps of scenario passed by .JSON which doesn't have actors
     * Iterates through steps when invoked by AcceptDisplaying - method from Step class
     *
     * @param step      visited step
     * @param parentNum number of higher step (parent step)
     * @param level     current level of scenario, controls displaying sub steps with right incision
     */
    @Override
    public void display(Step step, String parentNum, int level) {
        if (!isActor(step)) {
            for (int i = 0; i < level; i++)
                scenarioText += "- - ";
            scenarioText += parentNum + " ";
            for (int i = 0; i < step.getRule().size(); i++)
                scenarioText += step.getRule().get(i) + " ";
            scenarioText += "</br>";
        }
    }

    /**
     * Reset scenarioText after success displaying
     */
    @Override
    public void afterDisplaying() {
        scenarioText = "";
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
