package xmu.mall.goodsindex.zjh.model;

import java.io.Serializable;

import xmu.mystore.goodsmgt.zlt.model.Goods;

public class ShoppingCart implements Serializable
{
	private static final long serialVersionUID = -2659997323610518314L;
	private Long id;
	private Long userId;
	private Long goodsId;
	private Integer goodsNumber;
	private Goods goods;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(Integer goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}	

}
