package com.example.booking.entity;

import javax.persistence.*;

@Entity
public class BookingRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private String ruleDescription;

    public BookingRule() {
    }

    public BookingRule(Long id, String ruleName, String ruleDescription) {
        this.id = id;
        this.ruleName = ruleName;
        this.ruleDescription = ruleDescription;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleDescription() {
        return ruleDescription;
    }

    public void setRuleDescription(String ruleDescription) {
        this.ruleDescription = ruleDescription;
    }
}

