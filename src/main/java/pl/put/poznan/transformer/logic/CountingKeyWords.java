package pl.put.poznan.transformer.logic;

import pl.put.poznan.transformer.model.Step;

import java.util.List;

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
            List<String> content = step.getContent();
            return content.get(0).equals("IF") || content.get(0).equals("FOR EACH") || content.get(0).equals("ELSE");
        }
}

