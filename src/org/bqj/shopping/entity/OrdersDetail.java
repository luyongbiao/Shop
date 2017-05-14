package org.bqj.shopping.entity;

public class OrdersDetail {
    private Integer ordersdetailId;

    private Integer ordersId;

    private Integer goodsId;

    private Integer goodsCount;

    private Double totalPrice;

    public Integer getOrdersdetailId() {
        return ordersdetailId;
    }

    public void setOrdersdetailId(Integer ordersdetailId) {
        this.ordersdetailId = ordersdetailId;
    }

    public Integer getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}