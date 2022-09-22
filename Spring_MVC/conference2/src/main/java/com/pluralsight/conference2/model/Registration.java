package com.pluralsight.conference2.model;

import javax.validation.constraints.NotEmpty;

public class Registration {

    @NotEmpty //validation annotation
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
