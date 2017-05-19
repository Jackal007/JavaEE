package xmu.mystore.goodsindex.zjh.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xmu.mystore.goodsindex.zjh.model.SelectParameters;
import xmu.mystore.goodsindex.zjh.service.IGoodsIndexService;
import xmu.mystore.goodsmgt.zlt.model.Goods;
import xmu.mystore.goodsmgt.zlt.model.GoodsList;
import xmu.mystore.goodsmgt.zlt.service.outter.IGoodsMgtService;

@Controller
@RequestMapping(value="/")
public class GoodsIndexController 
{
	@Autowired
	@Qualifier("GoodsMgtService")
	private IGoodsMgtService goodsMgtService;
	
	@Autowired
	@Qualifier("GoodsIndexService")
	private IGoodsIndexService goodsIndexService;
	
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String home(Model model)
	{
		model.addAttribute("categoryList", goodsMgtService.getCategoryList());
		Map<String, String>array=goodsIndexService.getDefaultPageSizeNo();
		model.addAttribute("goodsList", goodsMgtService.getGoodsBy(array));
		return "zjh/index";
	}
	
	
	@RequestMapping(value="index/goodsDetail/{serialCode}",method=RequestMethod.GET)
	public String goodsDetail(
			@PathVariable String serialCode
			,Model model)
	{
		model.addAttribute("goods", goodsMgtService.getGoodsByGoodsCode(serialCode));
		return "zjh/goodsDetail";
	}
	
	@RequestMapping(value="index/choose",method=RequestMethod.GET)
	public String indexChooseTypeHome(
			@ModelAttribute("selectParameters")SelectParameters selectParameters,
			Model model)
	{
		model.addAttribute("categoryList", goodsMgtService.getCategoryList());
		Map<String, String>array=goodsIndexService.getDefaultPageSizeNo(selectParameters);
		model.addAttribute("goodsList", goodsMgtService.getGoodsBy(array));
		model.addAttribute("selects", selectParameters);
		return "zjh/index";
	}
	
	@RequestMapping(value="index/getGoodsListByAjax",method=RequestMethod.POST)
	@ResponseBody
	public List<Goods> getGoodsListByAjax(
			@ModelAttribute("selectParameters")SelectParameters selectParameters,
			Model model)
	{
		Map<String, String>array=goodsIndexService.turnSelectParamtersToMap(selectParameters);
		GoodsList goodsList=goodsMgtService.getGoodsBy(array);
		return goodsList.getGoodsList();
	}
	
	@RequestMapping(value="index/search",method=RequestMethod.POST)
	public String searchGoods(
			@ModelAttribute SelectParameters selectParameters,
			Model model)
	{
		model.addAttribute("categoryList", goodsMgtService.getCategoryList());
		model.addAttribute("brandList", goodsMgtService.getBrandList());
		Map<String, String>array=goodsIndexService.getDefaultPageSizeNo(selectParameters);
		model.addAttribute("goodsList", goodsMgtService.getGoodsBy(array));
		model.addAttribute("selects", selectParameters);
		return "zjh/search";
	}
	
	
	@RequestMapping(value="index/changeInSearchPage",method=RequestMethod.POST)
	public String changeInSearchPage(
			@ModelAttribute SelectParameters selectParameters,
			Model model)
	{
		model.addAttribute("categoryList", goodsMgtService.getCategoryList());
		model.addAttribute("brandList", goodsMgtService.getBrandList());
		Map<String, String>array=goodsIndexService.getDefaultPageSizeNo(selectParameters);
		model.addAttribute("goodsList", goodsMgtService.getGoodsBy(array));
		model.addAttribute("selects", selectParameters);
		return "zjh/search";
	}

}
