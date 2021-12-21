package pl.put.poznan.scenarioQualityChecker.model;


import java.util.ArrayList;

import pl.put.poznan.scenarioQualityChecker.logic.VisitorForCounting;
import pl.put.poznan.scenarioQualityChecker.logic.VisitorForDisplaying;


/**
 * Class which implements step object of scenario
 *
 * @author Radosław Dudek
 */
public class Step {
    private Integer numberOfStep;
    private String actor;
    private ArrayList<String> rule;
    private ArrayList<Step> subStep;
    private ArrayList<Integer> deepPath;

    public Step() {
    }

    /**
     * Accept counting of every step of scenario for visitor
     *
     * @param visitor object visiting steps
     */
    public void acceptCounting(VisitorForCounting visitor) {
        visitor.count(this);
        if (!this.subStep.isEmpty())
            for (Step step : subStep)
                step.acceptCounting(visitor);
    }

    /**
     * Accept displaying of every step of scenario for visitor
     *
     * @param visitor object visiting steps
     */
    public void acceptDisplaying(VisitorForDisplaying visitor, String num, int level) {
        num += this.numberOfStep + ".";
        visitor.display(this, num, level);
        if (!this.subStep.isEmpty()) {
            level++;
            for (Step step : subStep)
                step.acceptDisplaying(visitor, num, level);
        }
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
