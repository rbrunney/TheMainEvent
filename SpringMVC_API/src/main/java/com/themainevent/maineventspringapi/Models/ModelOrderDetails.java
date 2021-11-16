package com.themainevent.maineventspringapi.Models;

import java.util.ArrayList;

public class ModelOrderDetails {

    private String dateOfEvent;
    private String timeOfEvent;
    private String locationOfEvent;
    private int numberOfGuests;
    private float totalCostOfEvent;
    private ArrayList<ModelMenuItem> menuItems = new ArrayList<ModelMenuItem>();

    public String getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(String dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public String getTimeOfEvent() {
        return timeOfEvent;
    }

    public void setTimeOfEvent(String timeOfEvent) {
        this.timeOfEvent = timeOfEvent;
    }

    public String getLocationOfEvent() {
        return locationOfEvent;
    }

    public void setLocationOfEvent(String locationOfEvent) {
        this.locationOfEvent = locationOfEvent;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public float getTotalCostOfEvent() {
        return totalCostOfEvent;
    }

    public void setTotalCostOfEvent(float totalCostOfEvent) {
        this.totalCostOfEvent = totalCostOfEvent;
    }

    public ArrayList<ModelMenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(ArrayList<ModelMenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
