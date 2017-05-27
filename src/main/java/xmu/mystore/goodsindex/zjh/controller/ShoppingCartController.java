package xmu.mystore.goodsindex.zjh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xmu.mystore.goodsindex.zjh.model.AjaxReturnResult;
import xmu.mystore.goodsindex.zjh.model.OrderInfo;
import xmu.mystore.goodsindex.zjh.model.ShoppingCart;
import xmu.mystore.goodsindex.zjh.service.IShoppingCartService;

@Controller
@RequestMapping(value="/cart")
public class ShoppingCartController {
	
	@Autowired
	@Qualifier("ShoppingCartService")
	private IShoppingCartService shoppingCartService;
	
	/**
	 * 跳转到购物车主页
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String cartIndex(Model model,HttpSession session)
	{
		Long userId=Long.valueOf(session.getAttribute("userId").toString());
		model.addAttribute("shoppingCartList",shoppingCartService.getShoppingCartListByUserId(userId));
		return "zjh/cartIndex";
	}
	
	/**
	 * 添加购物车
	 * @param shopppingCart
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public AjaxReturnResult addShoppingCart(
			@ModelAttribute ShoppingCart shopppingCart,
			Model model,
			HttpSession session)
	{
		//需要session
		shopppingCart.setUserId(Long.valueOf(session.getAttribute("userId").toString()));
		return shoppingCartService.add(shopppingCart);
	}
	
	/**
	 * 删除购物车
	 * @param shoppingCarts
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public AjaxReturnResult deleteShoppingCarts(
			@RequestBody List<ShoppingCart> shoppingCarts
			)
	{
		return shoppingCartService.delete(shoppingCarts);
	}
	
	/**
	 * 更新购物车
	 * @param shoppingCarts
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public AjaxReturnResult updateShoppingCarts(
			@RequestBody List<ShoppingCart> shoppingCarts
			)
	{
		return shoppingCartService.update(shoppingCarts);
	}
	
	/**
	 * 处理订单页面
	 * @param goodsId
	 * @param goodsNumber
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/order",method=RequestMethod.POST)
	public String turnToOrderPage(
			String[]goodsId,
			String[]goodsNumber,
			Model model)
	{
		List<OrderInfo> orderInforList=new ArrayList<OrderInfo>();
		if(goodsId.length==goodsNumber.length)
		{
			for(int i=0;i<goodsId.length;++i)
			{
				OrderInfo orderInfo=new OrderInfo();
				orderInfo.setGoodsId(Long.valueOf(goodsId[i]));
				orderInfo.setGoodsNumber(Long.valueOf(goodsNumber[i]));
				orderInforList.add(orderInfo);
			}
		}
		model.addAttribute("orderList",orderInforList);
		return "zjh/ordertest";
	}
}
