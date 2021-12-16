package pl.put.poznan.transformer.model;

import java.util.List;

public class ScenarioModel {
    private String titleOfScenario;
    private List<String> actors;
    private List<String> systemActors;
    private List<Step> steps;

    public ScenarioModel() { }

    public String getTitle() {
        return titleOfScenario;
    }

    public List<String> getActors() {
        return actors;
    }

    public List<String> getSysactors() {
        return systemActors;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setTitle(String title) {
        this.titleOfScenario = title;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public void setSysactors(List<String> sysactors) {
        this.systemActors = sysactors;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }
}
