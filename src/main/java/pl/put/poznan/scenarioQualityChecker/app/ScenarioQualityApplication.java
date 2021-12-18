package pl.put.poznan.scenarioQualityChecker.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.put.poznan.scenarioQualityChecker.logic.JSONfileReader;
import pl.put.poznan.scenarioQualityChecker.logic.JSONtoObject;
import pl.put.poznan.scenarioQualityChecker.logic.VisitorForCounting;
import pl.put.poznan.scenarioQualityChecker.logic.CountingKeyWords;
import pl.put.poznan.scenarioQualityChecker.model.ScenarioModel;
import pl.put.poznan.scenarioQualityChecker.model.Step;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.scenarioQualityChecker.rest"})
public class ScenarioQualityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScenarioQualityApplication.class, args);

        List<String> list = Arrays.asList("one");
        List<String> syslist = Arrays.asList("lol");
        List<String> stepList = Arrays.asList("IF",
                "W systemie znajduje się karta pacjenta");
        List<Step> chuj = null;
        List<Integer> chuj2 = null;



        Step step1 = null;
        step1.setStepNum(1);
        step1.setActor("one");
        step1.setContent(stepList);
        step1.setSubsteps(chuj);
        step1.setReturnPath(chuj2);


        List<Step> chuj3 = Arrays.asList(step1);

        ScenarioModel scenarioModel = null;
        scenarioModel.setTitle("test");
        scenarioModel.setActors(list);
        scenarioModel.setSysactors(syslist);
        scenarioModel.setSteps(chuj3);


        VisitorForCounting visitor = new CountingKeyWords();
        scenarioModel.acceptCounting(visitor);
        int result = ((CountingKeyWords) visitor).getStepsNumber();
        visitor.afterCounting();
        System.out.println(result);


    }
}