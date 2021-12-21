package pl.put.poznan.scenarioQualityChecker.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.scenarioQualityChecker.logic.*;
import pl.put.poznan.scenarioQualityChecker.model.ScenarioModel;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ScenarioQualityControler --- REST controller for application, process incoming requests
 *
 * @author Filip Kaczmarek
 * @author Dariusz Karolewski
 * @author Radek Dudek
 * @author Patryk Jedrzejewski
 * @author Wiktor Jankowski
 */
@CrossOrigin
@RestController
public class ScenarioQualityControler {

    /**
     * Count every step which start with Key Words
     *
     * @param scenarioModel object of Scenario
     * @return number of steps with Key Words
     */
    @PostMapping("/countKeyWords")
    public String countingKeyWords(@RequestBody ScenarioModel scenarioModel) {
        VisitorForCounting visitor = new CountingKeyWords();

        scenarioModel.acceptCounting(visitor);

        int result = ((CountingKeyWords) visitor).getStepsNumber();

        visitor.afterCounting();

        return String.valueOf(result);
    }

    /**
     * Count every step of Scenario
     *
     * @param scenarioModel object of Scenario
     * @return number of all steps
     */

    @PostMapping("/countAllSteps")
    public String countingAllSteps(@RequestBody ScenarioModel scenarioModel) {
        VisitorForCounting visitor = new CountingAllSteps();

        scenarioModel.acceptCounting(visitor);

        int result = ((CountingAllSteps) visitor).getStepsNumber();

        visitor.afterCounting();

        return String.valueOf(result);
    }

    /**
     * Count every step which doesn't have actors
     *
     * @param scenarioModel object of Scenario
     * @return number of all steps without actors
     */
    @PostMapping("/countStepsWithoutActor")
    public String countingStepsWithoutActor(@RequestBody ScenarioModel scenarioModel) {
        VisitorForCounting visitor = new CountingStepsWithoutActor();

        scenarioModel.acceptCounting(visitor);

        int result = ((CountingStepsWithoutActor) visitor).getStepsNumber();

        visitor.afterCounting();

        return String.valueOf(result);
    }

    /**
     * Display steps which doesn't have actors
     *
     * @param scenarioModel object of Scenario
     * @return text containing list of steps without actors
     */
    @PostMapping("/displayingStepsWithoutActor")
    public String displayingStepsWithoutActor(@RequestBody ScenarioModel scenarioModel) {
        VisitorForDisplaying visitor = new DisplayingStepsWithoutActors();
        scenarioModel.acceptDisplaying(visitor);

        return ((DisplayingStepsWithoutActors) visitor).getScenarioText();
    }


    /**
     * Displays all steps
     *
     * @param scenarioModel object of Scenario
     * @return text containing list of all steps
     */

    @PostMapping("/displayScenario")
    public String displayScenario(@RequestBody ScenarioModel scenarioModel) {
        VisitorForDisplaying visitor = new DisplayingScenario();

        scenarioModel.acceptDisplaying(visitor);

        return ((DisplayingScenario) visitor).getScenarioText();
    }

    /**
     * Displays scenario passed by .JSON to certain level of scenario
     *
     * @param scenarioModel object of Scenario
     * @param level         number of desired level
     * @return text containing list of steps defined by
     */
    @PostMapping("/displayDepthLevel/{level}")
    public String displayDepthLevel(@RequestBody ScenarioModel scenarioModel, @PathVariable Integer level) {
        VisitorForDisplaying visitor = new DisplayingDepthLevel(level);

        scenarioModel.acceptDisplaying(visitor);

        return ((DisplayingDepthLevel) visitor).getScenarioText();
    }


}


