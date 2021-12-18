package pl.put.poznan.scenarioQualityChecker.logic;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import pl.put.poznan.scenarioQualityChecker.model.ScenarioModel;

/**
 * JSONtoObject class parses JSON to Scenario object.
 *
 */
public class JSONtoObject
{

    public static ScenarioModel getObject(String scenarioJSON)
    {
        Gson gson = new Gson();
        return gson.fromJson(scenarioJSON, ScenarioModel.class);
    }
}