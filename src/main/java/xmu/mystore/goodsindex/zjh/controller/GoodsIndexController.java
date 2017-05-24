package xmu.mystore.goodsindex.zjh.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xmu.mystore.goodsmgt.zlt.model.SelectParameters;
import xmu.mystore.goodsindex.zjh.constant.ProgramConstant;
import xmu.mystore.goodsmgt.zlt.model.Goods;
import xmu.mystore.goodsmgt.zlt.service.GoodsMgtService;

@Controller
@RequestMapping(value="/")
public class GoodsIndexController 
{
	@Autowired
	@Qualifier("GoodsMgtService")
	private GoodsMgtService goodsMgtService;

	private Logger logger=Logger.getLogger("GoodsIndexController");
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String home(Model model,HttpSession session)
	{
		session.setAttribute("userId", 1);
		model.addAttribute("categoryList", goodsMgtService.getCategoryList());
		SelectParameters select=new SelectParameters();
		select.initialPage(ProgramConstant.INDEX_INITIAL_PAGE, ProgramConstant.INDEX_PIGE_SIZE);
		model.addAttribute("goodsList", goodsMgtService.getGoodsBy(select));
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
			@ModelAttribute("selects")SelectParameters selectParameters,
			Model model)
	{
		model.addAttribute("categoryList", goodsMgtService.getCategoryList());
		selectParameters.initialPage(ProgramConstant.INDEX_INITIAL_PAGE, ProgramConstant.INDEX_PIGE_SIZE);
		model.addAttribute("goodsList", goodsMgtService.getGoodsBy(selectParameters));
		return "zjh/index";
	}
	
	@RequestMapping(value="index/getGoodsListByAjax",method=RequestMethod.POST)
	@ResponseBody
	public List<Goods> getGoodsListByAjax(
			@ModelAttribute("selects")SelectParameters selectParameters,
			Model model)
	{
		List<Goods> goodsList=goodsMgtService.getGoodsBy(selectParameters);
		return goodsList;
	}
	
	@RequestMapping(value="index/search",method=RequestMethod.POST)
	public String searchGoods(
			@ModelAttribute("selects") SelectParameters selectParameters,
			Model model)
	{
		model.addAttribute("categoryList", goodsMgtService.getCategoryList());
		model.addAttribute("brandList", goodsMgtService.getBrandList());
		selectParameters.initialPage(ProgramConstant.INDEX_INITIAL_PAGE, ProgramConstant.INDEX_PIGE_SIZE);
		model.addAttribute("goodsList", goodsMgtService.getGoodsBy(selectParameters));
		return "zjh/search";
	}
	
	
	@RequestMapping(value="index/changeInSearchPage",method=RequestMethod.POST)
	public String changeInSearchPage(
			@ModelAttribute("selects") SelectParameters selectParameters,
			Model model)
	{
		model.addAttribute("categoryList", goodsMgtService.getCategoryList());
		model.addAttribute("brandList", goodsMgtService.getBrandList());
		selectParameters.initialPage(ProgramConstant.INDEX_INITIAL_PAGE, ProgramConstant.INDEX_PIGE_SIZE);
		model.addAttribute("goodsList", goodsMgtService.getGoodsBy(selectParameters));
		return "zjh/search";
	}

}
