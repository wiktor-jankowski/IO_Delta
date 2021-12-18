package pl.put.poznan.scenarioQualityChecker.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.scenarioQualityChecker.logic.CountingKeyWords;
import pl.put.poznan.scenarioQualityChecker.logic.VisitorForCounting;
import pl.put.poznan.scenarioQualityChecker.model.ScenarioModel;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin
@RestController
public class ScenarioQualityControler {

    @PostMapping("/countKeyWords")
    public String countingKeyWords(@RequestBody ScenarioModel scenarioModel){
        VisitorForCounting visitor = new CountingKeyWords();
        scenarioModel.acceptCounting(visitor);
        int result = ((CountingKeyWords) visitor).getStepsNumber();
        visitor.afterCounting();
        return String.valueOf(result);
    }
}


