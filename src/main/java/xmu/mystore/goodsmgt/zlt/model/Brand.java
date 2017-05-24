package xmu.mystore.goodsmgt.zlt.model;

import java.io.Serializable;

public class Brand implements Serializable {
	/**
	 * 商品品牌
	 */
	private static final long serialVersionUID = 1L;
	private Long id; // 品牌id
	private String name; // 品牌名称
	private String website; // 品牌网址
	private String description; // 品牌描述
	private boolean type; // 是否在前台展示

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

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", website=" + website + ", description=" + description
				+ ", type=" + type + "]";
	}

}
