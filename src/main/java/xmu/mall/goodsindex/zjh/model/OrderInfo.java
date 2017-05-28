package xmu.mall.goodsindex.zjh.model;

import java.io.Serializable;
/**
 * 订单详细信息类，
 * 这个类不需要不需要存在
 * @author ZengJieHang
 *
 */
public class OrderInfo implements Serializable
{
	private static final long serialVersionUID = 4863655349043595947L;
	
	private Long goodsId;
	private Long goodsNumber;
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Long getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(Long goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
}
