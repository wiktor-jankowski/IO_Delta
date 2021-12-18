package pl.put.poznan.transformer.app;

import com.google.gson.JsonSyntaxException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.google.gson.JsonSyntaxException;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.JSONfileReader;
import pl.put.poznan.transformer.logic.JSONtoObject;
import pl.put.poznan.transformer.logic.VisitorForCounting;
import pl.put.poznan.transformer.logic.CountingKeyWords;
import pl.put.poznan.transformer.model.ScenarioModel;

import java.nio.file.Path;
import java.nio.file.Paths;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.transformer.rest"})
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