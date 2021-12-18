package pl.put.poznan.scenarioQualityChecker.logic;

import pl.put.poznan.scenarioQualityChecker.model.Step;

//visitor Class for counting business value procedures
abstract public class VisitorForCounting {
    public abstract void count(Step step);
    public abstract void afterCounting();
}
