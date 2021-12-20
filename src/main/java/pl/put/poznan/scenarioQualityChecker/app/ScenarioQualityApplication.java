package pl.put.poznan.scenarioQualityChecker.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.scenarioQualityChecker.rest"})
public class ScenarioQualityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScenarioQualityApplication.class, args);
    }
}
