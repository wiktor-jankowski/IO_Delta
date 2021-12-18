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

    public Step(Integer number,
            String act,
            ArrayList<String> rul,
            ArrayList<Step> sub,
            ArrayList<Integer> deep) {
        numberOfStep = number;
        actor = act;
        rule = rul;
        subStep = sub;
        deepPath = deep;
    }

    public Step() {
    }

    public void acceptCounting(VisitorForCounting visitor)
    {
        visitor.count(this);
        if(!this.subStep.isEmpty())
            for(Step step : subStep)
                step.acceptCounting(visitor);
    }

    // getters and setters section
    public Integer getStepNum() {
        return numberOfStep;
    }

    public void setStepNum(Integer stepNum) {
        this.numberOfStep = stepNum;
    }

    public String getActor() { return actor; }

    public void setActor(String actor) { this.actor = actor; }

    public ArrayList<String> getContent() {
        return rule;
    }

    public void setContent(ArrayList<String> content) {
        this.rule = content;
    }

    public ArrayList<Step> getSubsteps() {
        return subStep;
    }

    public void setSubsteps(ArrayList<Step> substeps) {
        this.subStep = substeps;
    }

    public ArrayList<Integer> getReturnPath() {
        return deepPath;
    }

    public void setReturnPath(ArrayList<Integer> returnPath) {
        this.deepPath = returnPath;
    }
}
