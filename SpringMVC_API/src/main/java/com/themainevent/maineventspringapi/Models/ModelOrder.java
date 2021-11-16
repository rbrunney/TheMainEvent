package com.themainevent.maineventspringapi.Models;

public class ModelOrder {

    private int customerId;
    private boolean confirmed;
    private boolean paidDeposit;
    private boolean completedJob;
    private boolean paidInFull;

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
