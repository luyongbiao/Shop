package org.bqj.shopping.entity;

import java.sql.Timestamp;

public class Goods {
    private Integer goodsId;

    private String goodsName;

    private Double goodsPrice;

    private Integer goodsStock;
    
    private String goodsDesc;

    private Timestamp goodsShelfTime;
    
    private Long goodsHits;
    
    private Long goodsSales;
    
    private String goodsPic;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsDesc() {
		return goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	public Integer getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(Integer goodsStock) {
        this.goodsStock = goodsStock;
    }

    public Timestamp getGoodsShelfTime() {
        return goodsShelfTime;
    }

    public void setGoodsShelfTime(Timestamp goodsShelfTime) {
        this.goodsShelfTime = goodsShelfTime;
    }

	public Long getGoodsHits() {
		return goodsHits;
	}

	public void setGoodsHits(Long goodsHits) {
		this.goodsHits = goodsHits;
	}

	public Long getGoodsSales() {
		return goodsSales;
	}

	public void setGoodsSales(Long goodsSales) {
		this.goodsSales = goodsSales;
	}
	
    public String getGoodsPic() {
		return goodsPic;
	}

	public void setGoodsPic(String goodsPic) {
		this.goodsPic = goodsPic;
	} 
}