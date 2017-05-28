package xmu.mall.goodsindex.zjh.service.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xmu.mall.goodsindex.zjh.constant.RenderAjaxReturnResult;
import xmu.mall.goodsindex.zjh.mapper.ShoppingCartMapper;
import xmu.mall.goodsindex.zjh.model.AjaxReturnResult;
import xmu.mall.goodsindex.zjh.model.ShoppingCart;
import xmu.mall.goodsindex.zjh.service.IShoppingCartService;

@Service("ShoppingCartService")
public class ShoppingCartService implements IShoppingCartService
{
	@Autowired
	private ShoppingCartMapper shoppingCartMapper;
	
	/**
	 * 通过用户id查找购物车列表
	 * @param userId
	 * @return
	 */
	public List<ShoppingCart> getShoppingCartListByUserId(Long userId)
	{
		return shoppingCartMapper.getShoppingCartListByUserId(userId);
	}
	
	/**
	 * 通过商品id和用户id查找购物车
	 * 用于确定某商品是否被加入购物车
	 * @param goodsId
	 * @param userId
	 * @return
	 */
	public ShoppingCart selectCartByGoodsIdAndUserId(Long goodsId,Long userId)
	{
		ShoppingCart shoppingCart=new ShoppingCart();
		shoppingCart.setGoodsId(goodsId);
		shoppingCart.setUserId(userId);
		return shoppingCartMapper.selectCartByGoodsIdAndUserId(shoppingCart);
	}
	
	/**
	 * 添加购物车
	 * @param shopppingCart
	 * @return
	 */
	public AjaxReturnResult add(ShoppingCart shopppingCart)
	{
		//判断商品是否已被加入购物车
		//如果已经加入，则只增加商品数量
		//如果没有加入，则插入购物车
		ShoppingCart isCartExist=shoppingCartMapper.selectCartByGoodsIdAndUserId(shopppingCart);
		if(isCartExist==null)
		{
			//商品未被加入
			if(shoppingCartMapper.add(shopppingCart)>0)
			{
				return RenderAjaxReturnResult.renderSuccessResult("成功添加购物车!");
			}
			else
			{
				return RenderAjaxReturnResult.renderErrorResult("购物车添加失败,原因:数据库出错!");
			}
		}
		else
		{
			//商品已加入
			shopppingCart.setId(isCartExist.getId());
			if(shoppingCartMapper.addGoodsNumber(shopppingCart)>0)
			{
				return RenderAjaxReturnResult.renderSuccessResult("成功修改购物车数量!");
			}
			else
			{
				return RenderAjaxReturnResult.renderErrorResult("购物车修改失败,原因:数据库出错!");
			}
		}
	}
	
	/**
	 * 更新购物车
	 * @param shoppingCarts
	 * @return
	 */
	public AjaxReturnResult update(List<ShoppingCart> shoppingCarts)
	{
		boolean success=true;
		
		//遍历更新
		for(ShoppingCart shoppingCart:shoppingCarts)
		{
			if(shoppingCartMapper.update(shoppingCart)>0)
			{
				continue;
			}
			else
			{
				success=false;
				break;
			}
		}
		
		if(success)
		{
			return RenderAjaxReturnResult.renderSuccessResult("修改成功!");
		}
		else
		{
			return RenderAjaxReturnResult.renderErrorResult("修改失败!");
		}
	}
	
	/**
	 * 删除购物车
	 * @param shoppingCarts
	 * @return
	 */
	public AjaxReturnResult delete(List<ShoppingCart> shoppingCarts)
	{
		boolean success=true;
		//遍历删除
		for(ShoppingCart shoppingCart:shoppingCarts)
		{
			if(shoppingCartMapper.delete(shoppingCart)>0)
			{
				continue;
			}
			else
			{
				success=false;
				break;
			}
		}
		
		if(success)
		{
			return RenderAjaxReturnResult.renderSuccessResult("删除成功!");
		}
		else
		{
			return RenderAjaxReturnResult.renderErrorResult("删除失败!");
		}
	}	
}
