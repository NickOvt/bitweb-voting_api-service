package com.api.votingapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Choice {
    @NotBlank
    private String choice;

    public Choice(@JsonProperty("choice") String choice) {
        this.choice = choice;
    }

    public String getChoice() {
        return this.choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }
    
}
