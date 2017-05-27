package xmu.mystore.goodsmgt.zlt.service.impls;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.goodsmgt.zlt.exception.MyException;
import xmu.mystore.goodsmgt.zlt.mapper.GoodsMapper;
import xmu.mystore.goodsmgt.zlt.mapper.StandMapper;
import xmu.mystore.goodsmgt.zlt.model.*;
import xmu.mystore.goodsmgt.zlt.service.BrandService;
import xmu.mystore.goodsmgt.zlt.service.CategoryService;
import xmu.mystore.goodsmgt.zlt.service.GoodsService;

@Service("GoodsService")
@Transactional
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;

	@Autowired
	private StandMapper standMapper;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private BrandService brandService;

	@Override
	public boolean addGoods(Goods goods) {
		// try {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		goods.setAdd_time(sdf.format(date));
		goods.setLast_modified_time(sdf.format(date));
		goodsMapper.add(goods);
		goods = goodsMapper.selectBySerialCode(goods);
		standMapper.add(goods);
		return true;
		// } catch (Exception e) {
		// System.out.println("addGoods:/n" + e.toString());
		// throw new MyException();
		// }
	}

	@Override
	public boolean deleteGoods(Goods goods) {
		try {
			goodsMapper.delete(goods);
			return true;
		} catch (Exception e) {
			System.out.println("deleteGoods:/n" + e.toString());
			throw new MyException();
		}
	}

	@Override
	public boolean modifyGoods(Goods goods) {
		try {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			goods.setLast_modified_time(sdf.format(date));
			goodsMapper.update(goods);
			return true;
		} catch (Exception e) {
			System.out.println("modifyGoods:/n" + e.toString());
			throw new MyException();
		}
	}

	@Override
	public Goods getAGoods(Goods goods) {
		try {
			return goodsMapper.select(goods);
		} catch (Exception e) {
			System.out.println("getAGoods:/n" + e.toString());
			throw new MyException();
		}
	}

	@Override
	public List<Goods> getAllGoods() {
		try {
			return goodsMapper.selectAll();
		} catch (Exception e) {
			System.out.println("getAllGoods:/n" + e.toString());
			throw new MyException();
		}
	}

	@Override
	public Category getCategory(Goods goods) {
		try {
			Category category = new Category();
			category.setId(goods.getCategory_id());
			category = categoryService.getACategory(category);
			return category;
		} catch (Exception e) {
			System.out.println("getCategory:/n" + e.toString());
			throw new MyException();
		}
	}

	@Override
	public Brand getBrand(Goods goods) {
		try {
			Brand brand = new Brand();
			brand.setId(goods.getBrand_id());
			brand = brandService.getABrand(brand);
			return brand;
		} catch (Exception e) {
			System.out.println("getBrand:/n" + e.toString());
			throw new MyException();
		}
	}
	
	@Override
	public Goods getGoodsBySerialCode(Goods goods) {
		try {
			return goodsMapper.selectBySerialCode(goods);
		} catch (Exception e) {
			System.out.println("getGoodsBySerialCode:/" + e.toString());
			throw new MyException();
		}
	}

	@Override
	public List<Goods> getGoodsByName(Goods goods) {
		try {
			return goodsMapper.selectByName(goods);
		} catch (Exception e) {
			System.out.println("getGoodsByName:/n" + e.toString());
			throw new MyException();
		}
	}

	@Override
	public List<Goods> getGoodsByBrand(long brandId) {
		try {
			Goods goods = new Goods();
			goods.setBrand_id(brandId);
			return goodsMapper.selectByBrand(goods);
		} catch (Exception e) {
			System.out.println("getGoodsByName:/" + e.toString());
			throw new MyException();
		}
	}

	@Override
	public List<Goods> getGoodsByPage(int pageNumber, int pageSize) {
		try {
			return goodsMapper.selectByPage(pageNumber, pageSize);
		} catch (Exception e) {
			System.out.println("getGoodsByPage:/n" + e.toString());
			throw new MyException();
		}
	}

	@Override
	public List<Goods> getGoodsByCategory(long categoryId) {
		try {
			Goods goods = new Goods();
			goods.setCategory_id(categoryId);
			return goodsMapper.selectByCategory(goods);
		} catch (Exception e) {
			System.out.println("getGoodsByCategory:/" + e.toString());
			throw new MyException();
		}
	}

	@Override
	public List<Goods> getGoodsByBrandAndCategory(long brandId, long categoryId) {
		try {
			Goods goods = new Goods();
			goods.setBrand_id(brandId);
			goods.setCategory_id(categoryId);
			return goodsMapper.selectByBrandAndCategory(goods);
		} catch (Exception e) {
			System.out.println("getGoodsByBrandAndCategory:/" + e.toString());
			throw new MyException();
		}
	}

	public List<Goods> standToGood(List<Stand> standList) {
		List<Goods> goodList = new ArrayList<Goods>();
		Iterator<Stand> it = standList.iterator();
		while (it.hasNext()) {
			Goods t = new Goods();
			t.setId(it.next().getGoods_id());
			t.setMarket_price(it.next().getMarket_price());
			t.setMid_user_price(it.next().getMid_user_price());
			t.setReal_price(it.next().getReal_price());
			t.setPre_sale_number(it.next().getPre_sale_count());
			goodList.add(t);
		}
		return goodList;
	}

	@Override
	public List<Goods> getGoodsBy(SelectParameters selects) 
	{
		return goodsMapper.selectBy(selects);
	}


}
