package pl.put.poznan.scenarioQualityChecker.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.put.poznan.scenarioQualityChecker.logic.JSONfileReader;
import pl.put.poznan.scenarioQualityChecker.logic.JSONtoObject;
import pl.put.poznan.scenarioQualityChecker.logic.VisitorForCounting;
import pl.put.poznan.scenarioQualityChecker.logic.CountingKeyWords;
import pl.put.poznan.scenarioQualityChecker.model.ScenarioModel;
import pl.put.poznan.scenarioQualityChecker.model.Step;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.scenarioQualityChecker.rest"})
public class ScenarioQualityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScenarioQualityApplication.class, args);

        ArrayList<String> list = new ArrayList<String>();
        list.add("One");
        ArrayList<String> syslist = new ArrayList<>();
        syslist.add("Sys");
        ArrayList<String> stepList = new ArrayList<>();
        stepList.add("IF");
        stepList.add( "W systemie znajduje się karta pacjenta");
        ArrayList<Step> chuj = new ArrayList<Step>();
        ArrayList<Integer> chuj2 = new ArrayList<Integer>();



        Step step1 = new Step();
        step1.setStepNum(1);
        step1.setActor("one");
        step1.setContent(stepList);
        step1.setSubsteps(chuj);
        step1.setReturnPath(chuj2);


        ArrayList<Step> chuj3 = new ArrayList<>();
        chuj3.add(step1);

        ScenarioModel scenarioModel = new ScenarioModel();
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