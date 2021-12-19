package pl.put.poznan.scenarioQualityChecker.logic;


import pl.put.poznan.scenarioQualityChecker.model.Step;

public class DisplayingDepthLevel extends VisitorForDisplaying {
    private String scenarioText = "";
    private int desiredLevel = 0;

    public DisplayingDepthLevel(int desiredLevel) { this.desiredLevel = desiredLevel; }

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

    @Override
    public void display(Step step, String parentNum, int level)
    {
        if(level < desiredLevel) {
            for (int i = 0; i < level; i++)
                scenarioText += "- - ";
            scenarioText += parentNum + " ";
            for (int i = 0; i < step.getRule().size(); i++)
                scenarioText += step.getRule().get(i) + " ";
            scenarioText += "</br>";
        }
    }

    @Override
    public void afterDisplaying()
    {
        scenarioText = "";
        desiredLevel = 0;
    }
}