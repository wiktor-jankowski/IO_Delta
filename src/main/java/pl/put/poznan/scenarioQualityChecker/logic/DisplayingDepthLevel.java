package pl.put.poznan.scenarioQualityChecker.logic;


import pl.put.poznan.scenarioQualityChecker.model.Step;

/**
 * DisplayingDepthLevel --- program shows steps and substeps of scenario
 * to certain scenario level defined by desiredLevel
 *
 * @author Dariusz Karolewski
 */

public class DisplayingDepthLevel extends VisitorForDisplaying {
    private String scenarioText = ""; // displayed text after reading .JSON to certain level
    private int desiredLevel = 0; // define to which level scenario will be displayed

    public DisplayingDepthLevel(int desiredLevel) {
        this.desiredLevel = desiredLevel;
    }

    public String getScenarioText() {
        return scenarioText;
    }

    public void setScenarioText(String scenarioText) {
        this.scenarioText = scenarioText;
    }

    public int getDesiredLevel() {
        return desiredLevel;
    }

    public void setDesiredLevel(int desiredLevel) {
        this.desiredLevel = desiredLevel;
    }


    /**
     * Displays scenario passed by .JSON to certain level of scenario defined as desiredLevel
     * Level of scenario is defined by nesting of subSteps, e.g.
     * original steps of scenario - level 1
     * sub steps of original steps - level 2
     * sub steps of sub steps - level 3
     * Iterates through steps when invoked by AcceptDisplaying - method from Step class
     *
     * @param step      visited step
     * @param parentNum number of higher step (parent step)
     * @param level     current level of scenario, controls displaying sub steps with right incision
     */
    @Override
    public void display(Step step, String parentNum, int level) {
        if (level < desiredLevel) {
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
        desiredLevel = 0;
    }
}
