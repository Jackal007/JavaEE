package xmu.mystore.goodsindex.zjh.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xmu.mystore.goodsindex.zjh.model.AjaxReturnResult;
import xmu.mystore.goodsindex.zjh.model.ShoppingCart;
import xmu.mystore.goodsindex.zjh.service.IShoppingCartService;

@Controller
@RequestMapping(value="/cart")
public class ShoppingCartController {
	
	@Autowired
	@Qualifier("ShoppingCartService")
	private IShoppingCartService shoppingCartService;
	
	@RequestMapping(value="/addShoppingCart",method=RequestMethod.POST)
	@ResponseBody
	public AjaxReturnResult addShoppingCart(
			@ModelAttribute("cart")ShoppingCart shopppingCart,
			Model model,
			HttpSession session)
	{
		//理论上这里需要session
		shopppingCart.setUserId((Long)(session.getAttribute("userId")));
		return shoppingCartService.add(shopppingCart);
	}
}
