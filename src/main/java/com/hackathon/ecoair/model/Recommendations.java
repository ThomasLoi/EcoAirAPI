package com.hackathon.ecoair.model;

import java.util.List;

public class Recommendations {

    public Recommendations(List<Value> carbonCompensation, int possibleLoyaltyPoints, List<String> charityActivities) {
        this.carbonCompensation = carbonCompensation;
        this.possibleLoyaltyPoints = possibleLoyaltyPoints;
        this.charityActivities = charityActivities;
    }

    private List<Value> carbonCompensation;
    private int possibleLoyaltyPoints;
    private List<String> charityActivities;

    public List<Value> getCarbonCompensation() {
        return carbonCompensation;
    }

    public void setCarbonCompensation(List<Value> carbonCompensation) {
        this.carbonCompensation = carbonCompensation;
    }

    public int getPossibleLoyaltyPoints() {
        return possibleLoyaltyPoints;
    }

    public void setPossibleLoyaltyPoints(int possibleLoyaltyPoints) {
        this.possibleLoyaltyPoints = possibleLoyaltyPoints;
    }

    public List<String> getCharityActivities() {
        return charityActivities;
    }

    public void setCharityActivities(List<String> charityActivities) {
        this.charityActivities = charityActivities;
    }
}
