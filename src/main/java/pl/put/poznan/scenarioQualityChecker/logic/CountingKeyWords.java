package pl.put.poznan.scenarioQualityChecker.logic;

import pl.put.poznan.scenarioQualityChecker.model.Step;

import java.util.ArrayList;

public class CountingKeyWords extends VisitorForCounting{
        private int stepsNumber = 0;

        public int getStepsNumber() { return stepsNumber; }


        public void count(Step step)
        {
            if(isKeyword(step))
                stepsNumber++;
        }


        public void afterCounting()
        {
            stepsNumber = 0;
        }


        private static boolean isKeyword(Step step)
        {
            ArrayList<String> content = step.getRule();
            return content.get(0).equals("IF") || content.get(0).equals("FOR EACH") || content.get(0).equals("ELSE");
        }
}

