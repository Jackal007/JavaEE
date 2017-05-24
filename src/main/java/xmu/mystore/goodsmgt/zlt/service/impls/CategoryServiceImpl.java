package xmu.mystore.goodsmgt.zlt.service.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.goodsmgt.zlt.exception.MyException;
import xmu.mystore.goodsmgt.zlt.mapper.CategoryMapper;
import xmu.mystore.goodsmgt.zlt.model.Category;
import xmu.mystore.goodsmgt.zlt.service.CategoryService;

@Service("CategoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public boolean addCategory(Category category) {
		try {
			categoryMapper.add(category);
			return true;
		} catch (Exception e) {
			System.out.println("addCategory:/" + e.toString());
			throw new MyException();
		}
	}

	@Override
	public boolean deleteCategory(Category category) {
		try {
			categoryMapper.delete(category);
			return true;
		} catch (Exception e) {
			System.out.println("deleteCategory:/n" + e.toString());
			throw new MyException();
		}
	}

	@Override
	public boolean modifyCategory(Category category) {
		try {
			categoryMapper.update(category);
			return true;
		} catch (Exception e) {
			System.out.println("modifyCategory:/n" + e.toString());
			throw new MyException();
		}
	}

	@Override
	public Category getACategory(Category category) {
		try {
			return categoryMapper.select(category);
		} catch (Exception e) {
			System.out.println("getACategory:/n" + e.toString());
			throw new MyException();
		}
	}

	@Override
	public List<Category> getAllCategory() {
		try {
			return categoryMapper.selectAll(false);
		} catch (Exception e) {
			System.out.println("getAllCategory:/" + e.toString());
			throw new MyException();
		}
	}

	@Override
	public List<Category> getShowCategory() {
		try {
			return categoryMapper.selectAll(true);
		} catch (Exception e) {
			System.out.println("getShowCategory:/" + e.toString());
			throw new MyException();
		}
	}

	@Override
	public Category getUpperCategory(Category category) {
		try {
			Category upperCategory = new Category();
			upperCategory.setId(category.getUpper_category_id());
			return categoryMapper.select(upperCategory);
		} catch (Exception e) {
			System.out.println("getUpperCategory:/" + e.toString());
			throw new MyException();
		}
	}
}
