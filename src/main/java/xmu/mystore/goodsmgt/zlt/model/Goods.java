
package xmu.mystore.goodsmgt.zlt.model;

import java.io.Serializable;

public class Goods implements Serializable {

	private static final long serialVersionUID = -3379003021791391391L;
	private Long id; // 商品id
	private String name; // 商品名
	private String serial_code; // 商品编码
	private Double weight; // 商品重量
	private Integer stock_count; // 商品库存
	private Integer pre_sale_number; // 预售数量
	private Long store_id; // 商店id
	private Double mid_user_price; // 中介价格
	private Double market_price; // 市场价格
	private Double real_price; // 真实价格
	private Integer redeem_point; // 商品积分
	private Long category_id; // 品类id
	private Long brand_id; // 品牌id
	private Long stand_id; // 上下架id
	private String add_time; // 增加商品时间
	private String last_modified_time;// 最后修改商品信息时间
	private String description; // 商品描述
	private String image_path; // 商品图片
	private Boolean is_dividable; // 是否允许分单
	private String default_express; // 默认快递

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerial_code() {
		return serial_code;
	}

	public void setSerial_code(String serial_code) {
		this.serial_code = serial_code;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getStock_count() {
		return stock_count;
	}

	public void setStock_count(Integer stock_count) {
		this.stock_count = stock_count;
	}

	public Integer getPre_sale_number() {
		return pre_sale_number;
	}

	public void setPre_sale_number(Integer pre_sale_number) {
		this.pre_sale_number = pre_sale_number;
	}

	public Long getStore_id() {
		return store_id;
	}

	public void setStore_id(Long store_id) {
		this.store_id = store_id;
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

	public Integer getRedeem_point() {
		return redeem_point;
	}

	public void setRedeem_point(Integer redeem_point) {
		this.redeem_point = redeem_point;
	}

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	public Long getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(Long brand_id) {
		this.brand_id = brand_id;
	}

	public Long getStand_id() {
		return stand_id;
	}

	public void setStand_id(Long stand_id) {
		this.stand_id = stand_id;
	}

	public String getAdd_time() {
		return add_time;
	}

	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}

	public String getLast_modified_time() {
		return last_modified_time;
	}

	public void setLast_modified_time(String last_modified_time) {
		this.last_modified_time = last_modified_time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public Boolean getIs_dividable() {
		return is_dividable;
	}

	public void setIs_dividable(Boolean is_dividable) {
		this.is_dividable = is_dividable;
	}

	public String getDefault_express() {
		return default_express;
	}

	public void setDefault_express(String default_express) {
		this.default_express = default_express;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", serial_code=" + serial_code + ", weight=" + weight
				+ ", stock_count=" + stock_count + ", pre_sale_number=" + pre_sale_number + ", store_id=" + store_id
				+ ", mid_user_price=" + mid_user_price + ", market_price=" + market_price + ", real_price=" + real_price
				+ ", redeem_point=" + redeem_point + ", category_id=" + category_id + ", brand_id=" + brand_id
				+ ", stand_id=" + stand_id + ", add_time=" + add_time + ", last_modified_time=" + last_modified_time
				+ ", description=" + description + ", image_path=" + image_path + ", is_dividable=" + is_dividable
				+ ", default_express=" + default_express + "]";
	}

}
