package com.xmu.sw.zjh.javaee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xmu.sw.zjh.javaee.entity.Card;
import com.xmu.sw.zjh.javaee.service.ICardService;

@Controller
@RequestMapping(value="/")
public class HomeController 
{
	@Autowired
	@Qualifier("cardService")
	private ICardService cardSerive;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home()
	{
		return "home";
	}

	@RequestMapping(value="home",method=RequestMethod.GET)
	public String toHome(Model model)
	{
		Card card=cardSerive.getCardById(1);
		System.out.println(card.getId());
		System.out.println(card.getCode());
		System.out.println(card.getPerson().getId());
		System.out.println(card.getPerson().getName());
		model.addAttribute("city","xiamen");
		return "anotherHome";
	}
}
