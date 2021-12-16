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



    // getters and setters section
    public Integer getStepNum() {
        return numberOfStep;
    }

    public void setStepNum(Integer stepNum) {
        this.numberOfStep = stepNum;
    }

    public String getActor() { return actor; }

    public void setActor(String actor) { this.actor = actor; }

    public List<String> getContent() {
        return rule;
    }

    public void setContent(List<String> content) {
        this.rule = content;
    }

    public List<Step> getSubsteps() {
        return subStep;
    }

    public void setSubsteps(List<Step> substeps) {
        this.subStep = substeps;
    }

    public List<Integer> getReturnPath() {
        return deepPath;
    }

    public void setReturnPath(List<Integer> returnPath) {
        this.deepPath = returnPath;
    }
}
