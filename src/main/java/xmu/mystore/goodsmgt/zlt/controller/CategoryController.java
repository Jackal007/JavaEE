package xmu.mystore.goodsmgt.zlt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xmu.mystore.goodsmgt.zlt.model.Category;
import xmu.mystore.goodsmgt.zlt.service.CategoryService;

@Controller
@RequestMapping(value = "Category")
public class CategoryController {

	@RequestMapping(method = RequestMethod.GET)
	public String allCategoryPage(Model model) {
		List<Category> categoryList = categoryService.getAllCategory();
		model.addAttribute("categoryList", categoryList);
		return "/zlt/allCategory";
	}

	@RequestMapping(value = "addCategory", method = RequestMethod.GET)
	public String addCategoryPage(Model model) {
		List<Category> categoryList = categoryService.getShowCategory();
		model.addAttribute("categoryList", categoryList);
		return "/zlt/addCategory";
	}

	@RequestMapping(value = "addCategory", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category, Model model) {
		categoryService.addCategory(category);
		return "redirect:/Category";
	}

	@RequestMapping(value = "modifyCategory", method = RequestMethod.GET)
	public String modifyCategoryPage(@ModelAttribute("category") Category category, Model model) {
		// find this category
		category = categoryService.getACategory(category);
		model.addAttribute("category", category);
		// find upper category
		category = categoryService.getUpperCategory(category);
		model.addAttribute("upperCategory", category);
		List<Category> categoryList = categoryService.getShowCategory();
		model.addAttribute("categoryList", categoryList);
		return "/zlt/modifyCategory";
	}

	@RequestMapping(value = "modifyCategory", method = RequestMethod.POST)
	public String modifyCategory(@ModelAttribute("category") Category category, Model model) {
		categoryService.modifyCategory(category);
		return "redirect:/Category";
	}

	@RequestMapping(value = "deleteCategory", method = RequestMethod.POST)
	public String deleteCategory(@ModelAttribute("category") Category category, Model model) {
		categoryService.deleteCategory(category);
		return "redirect:/Category";
	}

	@Autowired
	private CategoryService categoryService;
}
