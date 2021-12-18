package pl.put.poznan.scenarioQualityChecker.app;


import com.google.gson.JsonSyntaxException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.google.gson.JsonSyntaxException;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.scenarioQualityChecker.logic.JSONfileReader;
import pl.put.poznan.scenarioQualityChecker.logic.JSONtoObject;
import pl.put.poznan.scenarioQualityChecker.logic.VisitorForCounting;
import pl.put.poznan.scenarioQualityChecker.logic.CountingKeyWords;
import pl.put.poznan.scenarioQualityChecker.model.ScenarioModel;

import java.nio.file.Path;
import java.nio.file.Paths;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.scenarioQualityChecker.rest"})
public class TextTransformerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TextTransformerApplication.class, args);



        String JSONfile = new JSONfileReader().toString("b");

        if (JSONfile == "{}" || JSONfile == "")
            System.out.println("\n Error \n");
        else {
            ScenarioModel scenario;
            scenario = JSONtoObject.getObject(JSONfile);

            VisitorForCounting visitor = new CountingKeyWords();
            scenario.acceptCounting(visitor);
            int result = ((CountingKeyWords) visitor).getStepsNumber();
            visitor.afterCounting();
            System.out.println(result);
        }
    }
}