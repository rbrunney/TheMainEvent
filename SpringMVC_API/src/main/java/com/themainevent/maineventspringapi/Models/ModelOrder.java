package com.themainevent.maineventspringapi.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Orders")
public class ModelOrder {

    @Id
    private String _id;
    private int customerId;
    private int orderId;
    private float cost;
    private boolean confirmed;
    private boolean paidDeposit;
    private boolean completedJob;
    private boolean paidInFull;

    public ModelOrder() {

    }

    public ModelOrder(int customerId, int orderId, float cost, boolean confirmed, boolean paidDeposit, boolean completedJob, boolean paidInFull) {
        this.customerId = customerId;
        this.orderId = orderId;
        this.cost = cost;
        this.confirmed = confirmed;
        this.paidDeposit = paidDeposit;
        this.completedJob = completedJob;
        this.paidInFull = paidInFull;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public boolean isPaidDeposit() {
        return paidDeposit;
    }

    public void setPaidDeposit(boolean paidDeposit) {
        this.paidDeposit = paidDeposit;
    }

    public boolean isCompletedJob() {
        return completedJob;
    }

    public void setCompletedJob(boolean completedJob) {
        this.completedJob = completedJob;
    }

    public boolean isPaidInFull() {
        return paidInFull;
    }

    public void setPaidInFull(boolean paidInFull) {
        this.paidInFull = paidInFull;
    }
}
