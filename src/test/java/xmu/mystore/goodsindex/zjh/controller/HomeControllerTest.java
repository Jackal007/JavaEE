package xmu.mystore.goodsindex.zjh.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import xmu.mall.goodsindex.zjh.controller.GoodsIndexController;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

public class HomeControllerTest 
{
	@Test
	public void testHomePage() throws Exception
	{
		GoodsIndexController controller=new GoodsIndexController();
		MockMvc mockMvc=standaloneSetup(controller).build();
		
		mockMvc.perform(get("/"))
		.andExpect(view().name("index"));
	}
}
