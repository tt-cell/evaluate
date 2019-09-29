package com.evaluate.demo.entity;

public class Target {
    private int targets_id;
    private float targets_weight;
    private int father_targets_id;
    private String targets_name;
    private String url;

    public float getTargets_weight() {
        return targets_weight;
    }

    public void setTargets_weight(float targets_weight) {
        this.targets_weight = targets_weight;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTargets_id() {
        return targets_id;
    }

    public void setTargets_id(int targets_id) {
        this.targets_id = targets_id;
    }

    public String getTargets_name() {
        return targets_name;
    }

    public void setTargets_name(String targets_name) {
        this.targets_name = targets_name;
    }

    public int getFather_targets_id() {
        return father_targets_id;
    }

    public void setFather_targets_id(int father_targets_id) {
        this.father_targets_id = father_targets_id;
    }
}

