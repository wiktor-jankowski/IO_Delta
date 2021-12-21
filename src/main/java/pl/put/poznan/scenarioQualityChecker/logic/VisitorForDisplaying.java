package pl.put.poznan.scenarioQualityChecker.logic;

import pl.put.poznan.scenarioQualityChecker.model.Step;


/**
 * VisitorForDisplaying --- program which apply Visitor Pattern, designed to display steps of scenario
 *
 * @author Radosław Dudek
 * @author Patryk Jedrzejewski
 * @author Dariusz Karolewski
 */
public abstract class VisitorForDisplaying {
    public abstract void display(Step step, String parentNum, int level);

    public abstract void afterDisplaying();
}
