package com.hackathon.ecoair.model;

import java.util.List;

public class Badges {
    private List<String> badges;

    public Badges(List<String> badges) {
        this.badges = badges;
    }

    public List<String> getBadges() {
        return badges;
    }

    public void setBadges(List<String> badges) {
        this.badges = badges;
    }
}
