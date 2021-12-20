package pl.put.poznan.scenarioQualityChecker.logic;

import pl.put.poznan.scenarioQualityChecker.model.Step;

/**
 * VisitorForCounting --- program which apply Visitor Pattern, designed to count steps of scenario
 *
 * @author Radoslaw Dudek
 * @author Filip Kaczmarek
 * @author Wiktor Jankowski
 */
abstract public class VisitorForCounting {
    public abstract void count(Step step);

    public abstract void afterCounting();
}
