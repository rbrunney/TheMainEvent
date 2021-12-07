package com.themainevent.maineventspringapi.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "Order Details")
public class ModelOrderDetails {

    @Id
    private String _id;
    private String customerID;
    private boolean isAccepted;
    private String typeOfEvent;
    private String dateOfEvent;
    private String locationOfEvent;
    private int numberOfGuests;
    private float totalCostOfEvent;
    private String menuItems;

    public ModelOrderDetails() {

    }

    public ModelOrderDetails(String _id, String customerID, boolean isAccepted, String typeOfEvent, String dateOfEvent, String locationOfEvent, int numberOfGuests, float totalCostOfEvent, String menuItems) {
        this._id = _id;
        this.customerID = customerID;
        this.isAccepted = isAccepted;
        this.typeOfEvent = typeOfEvent;
        this.dateOfEvent = dateOfEvent;
        this.locationOfEvent = locationOfEvent;
        this.numberOfGuests = numberOfGuests;
        this.totalCostOfEvent = totalCostOfEvent;
        this.menuItems = menuItems;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public String getTypeOfEvent() {
        return typeOfEvent;
    }

    public void setTypeOfEvent(String typeOfEvent) {
        this.typeOfEvent = typeOfEvent;
    }

    public String getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(String dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
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

    public String getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(String menuItems) {
        this.menuItems = menuItems;
    }
}
