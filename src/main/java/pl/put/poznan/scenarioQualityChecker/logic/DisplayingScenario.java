package pl.put.poznan.scenarioQualityChecker.logic;

import pl.put.poznan.scenarioQualityChecker.model.Step;

public class DisplayingScenario extends VisitorForDisplaying {
    private String scenarioText = "";

    public String getScenarioText() {
        return scenarioText;
    }

    public void setScenarioText(String scenarioText) {
        this.scenarioText = scenarioText;
    }

    @Override
    public void display(Step step, String parentNum, int level)
    {
        for(int i=0; i<level; i++)
            scenarioText = scenarioText + "- - ";
        scenarioText = scenarioText + parentNum + " ";
        for(int i=0; i < step.getRule().size(); i++)
            scenarioText = scenarioText + step.getRule().get(i) + " ";
        scenarioText = scenarioText + "</br>";
    }


    @Override
    public void afterDisplaying() {
        scenarioText = "";
    }
}