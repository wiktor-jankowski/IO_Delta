package pl.put.poznan.scenarioQualityChecker.logic;

import pl.put.poznan.scenarioQualityChecker.model.Step;

public class CountingStepsWithoutActor extends VisitorForCounting {
    private int stepsNumber = 0;

    public int getStepsNumber() {
        return stepsNumber;
    }

    public void count(Step step)
    {
        if(!isActor(step))
            stepsNumber++;
    }

    public void afterCounting()
    {
        stepsNumber = 0;
    }

    private boolean isActor(Step step) {
        if(!step.getActor().equals(""))
            return true;

        return false;
    }
}
