package org.bqj.shopping.entity;

import java.sql.Timestamp;

public class Orders {
    private Integer ordersId;

    private String ordersNote;

    private Timestamp ordersCreateTime;

    private Timestamp ordersPayTime;

    private Integer ordersStatusId;

    private Integer customerId;

    public Integer getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    public String getOrdersNote() {
        return ordersNote;
    }

    public void setOrdersNote(String ordersNote) {
        this.ordersNote = ordersNote == null ? null : ordersNote.trim();
    }

    public Timestamp getOrdersCreateTime() {
        return ordersCreateTime;
    }

    public void setOrdersCreateTime(Timestamp ordersCreateTime) {
        this.ordersCreateTime = ordersCreateTime;
    }

    public Timestamp getOrdersPayTime() {
        return ordersPayTime;
    }

    public void setOrdersPayTime(Timestamp ordersPayTime) {
        this.ordersPayTime = ordersPayTime;
    }

    public Integer getOrdersStatusId() {
        return ordersStatusId;
    }

    public void setOrdersStatusId(Integer ordersStatusId) {
        this.ordersStatusId = ordersStatusId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}