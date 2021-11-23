package com.themainevent.maineventspringapi.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "Order Details")
public class ModelOrderDetails {

    @Id
    private String id;
    private String dateOfEvent;
    private String timeOfEvent;
    private String locationOfEvent;
    private int numberOfGuests;
    private float totalCostOfEvent;
    private ArrayList<ModelMenuItem> menuItems;

    public ModelOrderDetails() {

    }

    public ModelOrderDetails(String dateOfEvent, String timeOfEvent, String locationOfEvent, int numberOfGuests, float totalCostOfEvent, ArrayList<ModelMenuItem> menuItems) {
        this.dateOfEvent = dateOfEvent;
        this.timeOfEvent = timeOfEvent;
        this.locationOfEvent = locationOfEvent;
        this.numberOfGuests = numberOfGuests;
        this.totalCostOfEvent = totalCostOfEvent;
        this.menuItems = menuItems;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
