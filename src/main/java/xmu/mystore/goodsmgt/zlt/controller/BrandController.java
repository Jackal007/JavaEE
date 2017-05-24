package xmu.mystore.goodsmgt.zlt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xmu.mystore.goodsmgt.zlt.model.Brand;
import xmu.mystore.goodsmgt.zlt.service.BrandService;

@Controller
@RequestMapping(value = "Brand")
public class BrandController {

	@RequestMapping(method = RequestMethod.GET)
	public String allBrandPage(Model model) {
		List<Brand> brandList = brandService.getAllBrand();
		model.addAttribute("brandList", brandList);
		return "/zlt/allBrand";
	}

	@RequestMapping(value = "addBrand", method = RequestMethod.GET)
	public String addBrandPage(Model model) {
		return "/zlt/addBrand";
	}

	@RequestMapping(value = "addBrand", method = RequestMethod.POST)
	public String addBrand(@ModelAttribute("brand") Brand brand, Model model) {
		brandService.addBrand(brand);
		return "redirect:/Brand";
	}

	@RequestMapping(value = "modifyBrand", method = RequestMethod.GET)
	public String modifyBrandPage(@ModelAttribute("brand") Brand brand, Model model) {
		brand = brandService.getABrand(brand);
		model.addAttribute("brand", brand);
		return "/zlt/modifyBrand";
	}

	@RequestMapping(value = "modifyBrand", method = RequestMethod.POST)
	public String modifyBrand(@ModelAttribute("brand") Brand brand, Model model) {
		brandService.modifyBrand(brand);
		return "redirect:/Brand";
	}

	@RequestMapping(value = "deleteBrand", method = RequestMethod.POST)
	public String deleteBrand(@ModelAttribute("brand") Brand brand, Model model) {
		brandService.deleteBrand(brand);
		return "redirect:/Brand";
	}

	@Autowired
	private BrandService brandService;
}
