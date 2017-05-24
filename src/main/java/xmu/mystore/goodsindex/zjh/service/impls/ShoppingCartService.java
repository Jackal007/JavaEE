package xmu.mystore.goodsindex.zjh.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xmu.mystore.goodsindex.zjh.constant.RenderAjaxReturnResult;
import xmu.mystore.goodsindex.zjh.mapper.ShoppingCartMapper;
import xmu.mystore.goodsindex.zjh.model.AjaxReturnResult;
import xmu.mystore.goodsindex.zjh.model.ShoppingCart;
import xmu.mystore.goodsindex.zjh.service.IShoppingCartService;

@Service("ShoppingCartService")
public class ShoppingCartService implements IShoppingCartService
{
	@Autowired
	private ShoppingCartMapper shoppingCartMapper;
	
	public AjaxReturnResult add(ShoppingCart shopppingCart)
	{
		if(shoppingCartMapper.add(shopppingCart)>0)
		{
			return RenderAjaxReturnResult.renderSuccessResult("成功添加购物车!");
		}
		else
		{
			return RenderAjaxReturnResult.renderErrorResult("购物车添加失败,原因:数据库出错!");
		}
	}
}
