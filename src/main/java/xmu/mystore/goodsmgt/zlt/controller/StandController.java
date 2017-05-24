package xmu.mystore.goodsmgt.zlt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xmu.mystore.goodsmgt.zlt.model.Stand;
import xmu.mystore.goodsmgt.zlt.service.StandService;

@Controller
@RequestMapping(value = "Stand")
public class StandController {

	@RequestMapping(method = RequestMethod.GET)
	public String allStandPage(Model model) {
		List<Stand> standList = standService.getAllStand();
		model.addAttribute("standList", standList);
		return "/zlt/allStand";
	}

	@RequestMapping(value = "modifyStand", method = RequestMethod.GET)
	public String modifyStandPage(@ModelAttribute("stand") Stand stand, Model model) {
		// get this stand
		stand = standService.getAStand(stand);
		model.addAttribute("stand", stand);
		return "/zlt/modifyStand";
	}

	@RequestMapping(value = "modifyStand", method = RequestMethod.POST)
	public String modifyStand(@ModelAttribute("stand") Stand stand, Model model) {
		standService.modifyStand(stand);
		return "redirect:/Stand";
	}

	@Autowired
	private StandService standService;
}
