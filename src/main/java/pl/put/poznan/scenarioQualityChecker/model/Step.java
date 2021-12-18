package pl.put.poznan.scenarioQualityChecker.model;


import java.util.List;
import pl.put.poznan.scenarioQualityChecker.logic.VisitorForCounting;


//Basic implementation of steps of scenario

public class Step {
    private Integer numberOfStep;
    private String actor;
    private List<String> rule;
    private List<Step> subStep;
    private List<Integer> deepPath;

    public Step(Integer number,
            String act,
            List<String> rul,
            List<Step> sub,
            List<Integer> deep) {
        numberOfStep = number;
        actor = act;
        rule = rul;
        subStep = sub;
        deepPath = deep;
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

    public List<String> getContent() {
        return rule;
    }

    public void setContent(List<String> content) {
        this.rule = content;
    }

    public List<Step> getSubsteps() {
        return subStep;
    }

    public void setSubsteps(List<Step> substeps) {
        this.subStep = substeps;
    }

    public List<Integer> getReturnPath() {
        return deepPath;
    }

    public void setReturnPath(List<Integer> returnPath) {
        this.deepPath = returnPath;
    }
}
