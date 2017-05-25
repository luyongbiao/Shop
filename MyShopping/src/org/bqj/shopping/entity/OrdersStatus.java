package org.bqj.shopping.entity;

public class OrdersStatus {
    private Integer ordersStatusId;

    private String ordersStatusName;

    public Integer getOrdersStatusId() {
        return ordersStatusId;
    }

    public void setOrdersStatusId(Integer ordersStatusId) {
        this.ordersStatusId = ordersStatusId;
    }

    public String getOrdersStatusName() {
        return ordersStatusName;
    }

    public void setOrdersStatusName(String ordersStatusName) {
        this.ordersStatusName = ordersStatusName == null ? null : ordersStatusName.trim();
    }
}