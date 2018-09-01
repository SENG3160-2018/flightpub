package com.flightpub.base.model;

import javax.persistence.*;

/**
 * TicketClass
 *
 * Entity object mapped to Destination DB table
 */
@Entity
@Table(name = "TicketType")
public class TicketType {
    private String ticketCode;
    private String name;
    private boolean transferrable;
    private boolean refundable;
    private boolean exchangeable;
    private boolean frequentFlyerPoints;

    @Id
    @Column(name = "TicketCode")
    public String getTicketCode() {
        return ticketCode;
    }
    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Transferrable")
    public boolean isTransferrable() {
        return transferrable;
    }
    public void setTransferrable(boolean transferrable) {
        this.transferrable = transferrable;
    }

    @Basic
    @Column(name = "Refundable")
    public boolean isRefundable() {
        return refundable;
    }
    public void setRefundable(boolean refundable) {
        this.refundable = refundable;
    }

    @Basic
    @Column(name = "Exchangeable")
    public boolean isExchangeable() {
        return exchangeable;
    }
    public void setExchangeable(boolean exchangeable) {
        this.exchangeable = exchangeable;
    }

    @Basic
    @Column(name = "FrequentFlyerPoints")
    public boolean isFrequentFlyerPoints() {
        return frequentFlyerPoints;
    }
    public void setFrequentFlyerPoints(boolean frequentFlyerPoints) {
        this.frequentFlyerPoints = frequentFlyerPoints;
    }
}
