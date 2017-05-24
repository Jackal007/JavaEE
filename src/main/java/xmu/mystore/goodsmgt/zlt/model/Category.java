package xmu.mystore.goodsmgt.zlt.model;

import java.io.Serializable;

public class Category implements Serializable {
	/**
	 * 商品品类
	 */
	private static final long serialVersionUID = 1L;
	private Long id; // 品类id
	private String name; // 品类名称
	private Long upper_category_id; // 上级品类id
	private Integer rank; // 品类等级
	private Integer priority; // 品类前台显示顺序
	private boolean type; // 品类状态（目前表示是否在前台显示）

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

	public Long getUpper_category_id() {
		return upper_category_id;
	}

	public void setUpper_category_id(Long upper_category_id) {
		this.upper_category_id = upper_category_id;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public static Long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", upper_category_id=" + upper_category_id + ", rank=" + rank
				+ ", priority=" + priority + ", type=" + type + "]";
	}

}
