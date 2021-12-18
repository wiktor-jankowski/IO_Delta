package pl.put.poznan.transformer.logic;

import pl.put.poznan.transformer.model.Step;

//visitor Class for counting business value procedures
abstract public class VisitorForCounting {
    public abstract void count(Step step);
    public abstract void afterCounting();
}
