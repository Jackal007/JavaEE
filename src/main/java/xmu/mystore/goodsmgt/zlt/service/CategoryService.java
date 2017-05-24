package xmu.mystore.goodsmgt.zlt.service;

import java.util.List;

import xmu.mystore.goodsmgt.zlt.model.Category;

public interface CategoryService {

	public boolean addCategory(Category category);
	
	public boolean modifyCategory(Category category);
	
	public boolean deleteCategory(Category category);

	public Category getACategory(Category category);
	
	public List<Category> getAllCategory();
	
	public List<Category> getShowCategory();
	
	public Category getUpperCategory(Category category);


}
