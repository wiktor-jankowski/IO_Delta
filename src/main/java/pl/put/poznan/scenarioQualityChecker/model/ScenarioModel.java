package pl.put.poznan.scenarioQualityChecker.model;

import java.util.ArrayList;
import java.util.List;
import pl.put.poznan.scenarioQualityChecker.logic.VisitorForCounting;



public class ScenarioModel {
    private String titleOfScenario;
    private ArrayList<String> actors;
    private ArrayList<String> systemActors;
    private ArrayList<Step> steps;

    public ScenarioModel(String title, ArrayList<String> act, ArrayList<String> syst, ArrayList<Step> step) {
        titleOfScenario = title;
        actors = act;
        systemActors = syst;
        steps = step;
    }

    public ScenarioModel() {
    }

    public void acceptCounting(VisitorForCounting visitor)
    {
        for(Step step : steps)
        {
            step.acceptCounting(visitor);
        }
    }

    public String getTitle() {
        return titleOfScenario;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public ArrayList<String> getSysactors() {
        return systemActors;
    }

    public ArrayList<Step> getSteps() {
        return steps;
    }

    public void setTitle(String title) {
        this.titleOfScenario = title;
    }

    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    public void setSysactors(ArrayList<String> sysactors) {
        this.systemActors = sysactors;
    }

    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
    }
}
