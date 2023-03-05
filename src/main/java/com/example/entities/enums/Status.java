package com.example.entities.enums;

public enum Status {
    PENDING("Pending"), IN_PROGRESS("In progress"), COMPLETED("Completed"), CANCELED("Canceled");

    private final String displayValue;

    private Status(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
