package pl.put.poznan.transformer.model;


import java.util.List;

//Basic implementetion of steps of scenario

public class Step {
    private Integer numberOfStep;
    private String actor;
    private List<String> rule;
    private List<Step> subStep;
    private List<Integer> deepPath;

    public Step() { }

}
