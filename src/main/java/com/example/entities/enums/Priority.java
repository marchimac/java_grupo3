package com.example.entities.enums;

public enum Priority {
    LOW("Low"), MEDIUM("Medium"), HIGH("High"), CRITICAL("Critical");

    private final String displayValue;

    private Priority(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
