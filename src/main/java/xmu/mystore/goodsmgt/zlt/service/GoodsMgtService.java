package xmu.mystore.goodsmgt.zlt.service;

import java.util.List;
import xmu.mystore.goodsmgt.zlt.model.*;

public interface GoodsMgtService {

	/* 根据商品ID查找商品 */
	public Goods getGoodsByGoodsId(Long id);
	
	/* 根据商品编号查找商品 */
	public Goods getGoodsByGoodsCode(String serial_code);

	/* 根据商品名称查找商品（可以尝试下模糊查询） */
	public List<Goods> getGoodsByGoodsName(String goods_name);

	/*
	 * 根据传进来的参数先判断参数是哪些，最多5个
	 * （第几页（no）、页尺寸（size）、品牌id(brand_id)、 品类id(category_id)、
	 * 和一个排序方法（按销量(pre_sale_number)或真实价格(real_price)排序） 0表示降序排序，1表示升序排序； 
	 * 至少为2个（一个为第几页，一个为页尺寸）； 
	 * 如果参数为品牌表示要返回该品牌下的所有商品，
	 * 如果为品类表示返回该品类下的所有商品，
	 * 如果参数为一个以上，自行选择链接查询！！ 
	 * 注意返回的商品都是已上架商品
	 */
	public List<Goods> getGoodsBy(SelectParameters selects);

	/* 返回所有可以显示到前台的商品品类，注意按前台显示顺序从小到大排序 */
	public List<Category> getCategoryList();

	/* 返回所有可以显示到前台的商品品牌 */
	public List<Brand> getBrandList();

	/* 返回一个符合条件且已上架的上架信息（主要是为了查询商品价格） */
	public Stand getGoodsPrice(Long goods_id);

}
