package pl.put.poznan.scenarioQualityChecker.logic;

import pl.put.poznan.scenarioQualityChecker.model.Step;

/**
 * DisplayingScenario --- program to show all steps of scenario
 *
 * @author Patryk Jędrzejewski
 */
public class DisplayingScenario extends VisitorForDisplaying {
    private String scenarioText = ""; // displayed text after reading .JSON

    public String getScenarioText() {
        return scenarioText;
    }

    public void setScenarioText(String scenarioText) {
        this.scenarioText = scenarioText;
    }


    /**
     * Displays full scenario passed by .JSON file
     * Iterates through steps when invoked by AcceptDisplaying - method from Step class
     *
     * @param step      visited step
     * @param parentNum number of higher step (parent step)
     * @param level     current level of scenario, controls displaying substeps with right incision
     */
    @Override
    public void display(Step step, String parentNum, int level) {
        for (int i = 0; i < level; i++)
            scenarioText += "- - ";
        scenarioText += parentNum + " ";
        for (int i = 0; i < step.getRule().size(); i++)
            scenarioText += step.getRule().get(i) + " ";
        scenarioText += "</br>";
    }

    /**
     * Reset scenarioText after success displaying
     */
    @Override
    public void afterDisplaying() {
        scenarioText = "";
    }
}
