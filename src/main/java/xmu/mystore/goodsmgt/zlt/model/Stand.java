package xmu.mystore.goodsmgt.zlt.model;

import java.io.Serializable;

public class Stand implements Serializable {
	/**
	 * 商品上下架类
	 */
	private static final long serialVersionUID = 5095130780097454246L;
	private Long id; // 上下架id
	private Long goods_id; // 商品id
	private Double mid_user_price; // 中介价格
	private Double market_price; // 市场价格
	private Double real_price; // 真实价格
	private String on_market_time; // 上架时间
	private String off_market_time; // 下架时间
	private Integer pre_sale_count; // 预售数量

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(Long goods_id) {
		this.goods_id = goods_id;
	}

	public Double getMid_user_price() {
		return mid_user_price;
	}

	public void setMid_user_price(Double mid_user_price) {
		this.mid_user_price = mid_user_price;
	}

	public Double getMarket_price() {
		return market_price;
	}

	public void setMarket_price(Double market_price) {
		this.market_price = market_price;
	}

	public Double getReal_price() {
		return real_price;
	}

	public void setReal_price(Double real_price) {
		this.real_price = real_price;
	}

	public String getOn_market_time() {
		return on_market_time;
	}

	public void setOn_market_time(String on_market_time) {
		this.on_market_time = on_market_time;
	}

	public String getOff_market_time() {
		return off_market_time;
	}

	public void setOff_market_time(String off_market_time) {
		this.off_market_time = off_market_time;
	}

	public Integer getPre_sale_count() {
		return pre_sale_count;
	}

	public void setPre_sale_count(Integer pre_sale_count) {
		this.pre_sale_count = pre_sale_count;
	}

	@Override
	public String toString() {
		return "Stand [id=" + id + ", goods_id=" + goods_id + ", mid_user_price=" + mid_user_price + ", market_price="
				+ market_price + ", real_price=" + real_price + ", on_market_time=" + on_market_time
				+ ", off_market_time=" + off_market_time + ", pre_sale_count=" + pre_sale_count + "]";
	}

}
