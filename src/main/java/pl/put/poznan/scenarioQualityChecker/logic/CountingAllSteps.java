package pl.put.poznan.scenarioQualityChecker.logic;

import pl.put.poznan.scenarioQualityChecker.model.Step;

public class CountingAllSteps extends VisitorForCounting{
    private int stepsNumber = 0;

    public int getStepsNumber() {
        return stepsNumber;
    }

    public void count(Step step)
    {
        stepsNumber++;
    }

    public void afterCounting()
    {
        stepsNumber = 0;
    }
}