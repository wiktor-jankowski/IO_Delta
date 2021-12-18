package pl.put.poznan.scenarioQualityChecker.model;


import java.util.ArrayList;
import pl.put.poznan.scenarioQualityChecker.logic.VisitorForCounting;


//Basic implementation of steps of scenario

public class Step {
    private Integer numberOfStep;
    private String actor;
    private ArrayList<String> rule;
    private ArrayList<Step> subStep;
    private ArrayList<Integer> deepPath;

    public Step() {}

    public void acceptCounting(VisitorForCounting visitor)
    {
        visitor.count(this);
        if(!this.subStep.isEmpty())
            for(Step step : subStep)
                step.acceptCounting(visitor);
    }

    public Integer getNumberOfStep() {
        return numberOfStep;
    }

    public void setNumberOfStep(Integer numberOfStep) {
        this.numberOfStep = numberOfStep;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public ArrayList<String> getRule() {
        return rule;
    }

    public void setRule(ArrayList<String> rule) {
        this.rule = rule;
    }

    public ArrayList<Step> getSubStep() {
        return subStep;
    }

    public void setSubStep(ArrayList<Step> subStep) {
        this.subStep = subStep;
    }

    public ArrayList<Integer> getDeepPath() {
        return deepPath;
    }

    public void setDeepPath(ArrayList<Integer> deepPath) {
        this.deepPath = deepPath;
    }
}
