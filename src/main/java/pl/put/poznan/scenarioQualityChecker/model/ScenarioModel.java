package pl.put.poznan.scenarioQualityChecker.model;

import java.util.ArrayList;

import pl.put.poznan.scenarioQualityChecker.logic.VisitorForCounting;
import pl.put.poznan.scenarioQualityChecker.logic.VisitorForDisplaying;
import pl.put.poznan.scenarioQualityChecker.logic.DisplayingScenario;

/**
 * Class which implements scenario object read from .JSON file
 *
 * @author Radoslaw Dudek
 */

public class ScenarioModel {
    private String titleOfScenario;
    private ArrayList<String> actors;
    private ArrayList<String> systemActors;
    private ArrayList<Step> steps;

    public ScenarioModel() {
    }

    /**
     * Accept counting of every step of scenario for visitor
     *
     * @param visitor object visiting steps
     */
    public void acceptCounting(VisitorForCounting visitor) {
        for (Step step : steps) {
            step.acceptCounting(visitor);
        }
    }

    /**
     * Displays titleOfScenario
     * Accept counting of every every step of scenario
     *
     * @param visitor object visiting steps
     */
    public void acceptDisplaying(VisitorForDisplaying visitor) {
        if (visitor instanceof DisplayingScenario)
            ((DisplayingScenario) visitor).setScenarioText(this.titleOfScenario + "</br></br>");
        for (Step step : steps) {
            step.acceptDisplaying(visitor, "", 0);
        }
    }

    public String getTitleOfScenario() {
        return titleOfScenario;
    }

    public void setTitleOfScenario(String titleOfScenario) {
        this.titleOfScenario = titleOfScenario;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    public ArrayList<String> getSystemActors() {
        return systemActors;
    }

    public void setSystemActors(ArrayList<String> systemActors) {
        this.systemActors = systemActors;
    }

    public ArrayList<Step> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
    }
}
