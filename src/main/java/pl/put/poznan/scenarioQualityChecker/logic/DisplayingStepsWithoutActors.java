package pl.put.poznan.scenarioQualityChecker.logic;

import pl.put.poznan.scenarioQualityChecker.model.Step;

public class DisplayingStepsWithoutActors extends VisitorForDisplaying{
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
        if(!isActor(step)) {
            for(int i=0; i<level; i++)
                scenarioText += "- - ";
            scenarioText += parentNum + " ";
            for(int i=0; i < step.getRule().size(); i++)
                scenarioText += step.getRule().get(i) + " ";
            scenarioText += "</br>";
        }
    }


    @Override
    public void afterDisplaying() {
        scenarioText = "";
    }

    private boolean isActor(Step step) {
        if(!step.getActor().equals(""))
            return true;

        return false;
    }

}
