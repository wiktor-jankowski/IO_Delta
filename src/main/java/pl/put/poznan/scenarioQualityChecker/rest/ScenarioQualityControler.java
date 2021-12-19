package pl.put.poznan.scenarioQualityChecker.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.scenarioQualityChecker.logic.*;
import pl.put.poznan.scenarioQualityChecker.model.ScenarioModel;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin
@RestController
public class ScenarioQualityControler {

    @PostMapping("/countAllSteps")
    public String countingAllSteps(@RequestBody ScenarioModel scenarioModel){
        VisitorForCounting visitor = new CountingAllSteps();

        scenarioModel.acceptCounting(visitor);

        int result = ((CountingAllSteps) visitor).getStepsNumber();

        visitor.afterCounting();

        return String.valueOf(result);
    }

    @PostMapping("/countKeyWords")
    public String countingKeyWords(@RequestBody ScenarioModel scenarioModel){
        VisitorForCounting visitor = new CountingKeyWords();

        scenarioModel.acceptCounting(visitor);

        int result = ((CountingKeyWords) visitor).getStepsNumber();

        visitor.afterCounting();

        return String.valueOf(result);
    }


    @PostMapping("/displayScenario")
    public String displayScenario(@RequestBody ScenarioModel scenarioModel){
        VisitorForDisplaying visitor = new DisplayingScenario();

        scenarioModel.acceptDisplaying(visitor);

        return ((DisplayingScenario) visitor).getScenarioText();
    }
    @PostMapping("/displayDepthLevel/{level}")
    public String displayDepthLevel(@RequestBody ScenarioModel scenarioModel, @PathVariable Integer level){
        VisitorForDisplaying visitor = new DisplayingDepthLevel(level);

        scenarioModel.acceptDisplaying(visitor);

        return ((DisplayingDepthLevel) visitor).getScenarioText();
    }
    @PostMapping("/countStepsWithoutActor")
    public String countingStepsWithoutActor(@RequestBody ScenarioModel scenarioModel){
        VisitorForCounting visitor = new CountingStepsWithoutActor();

        scenarioModel.acceptCounting(visitor);

        int result = ((CountingStepsWithoutActor) visitor).getStepsNumber();

        visitor.afterCounting();

        return String.valueOf(result);
    }

    @PostMapping("/displayingStepsWithoutActor")
    public String displayingStepsWithoutActor(@RequestBody ScenarioModel scenarioModel){
        VisitorForDisplaying visitor = new DisplayingStepsWithoutActors();
        scenarioModel.acceptDisplaying(visitor);

        return ((DisplayingStepsWithoutActors) visitor).getScenarioText();
    }

}
