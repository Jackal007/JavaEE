package xmu.mystore.goodsmgt.zlt.service.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.goodsmgt.zlt.exception.MyException;
import xmu.mystore.goodsmgt.zlt.mapper.BrandMapper;
import xmu.mystore.goodsmgt.zlt.model.Brand;
import xmu.mystore.goodsmgt.zlt.service.BrandService;

@Service("BrandService")
@Transactional
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandMapper brandService;

	@Override
	public boolean addBrand(Brand brand) {
		try {
			if (brand.getName() == null) {
				brand.setName("empty");
			}
			String website = brand.getWebsite();
			website = website.replace("http://", "");
			brand.setWebsite("http://" + website);
			brandService.add(brand);
		} catch (Exception e) {
			System.out.println("addBrand:/n" + e.toString());
			throw new MyException();
		}
		return true;
	}

	@Override
	public boolean deleteBrand(Brand brand) {
		try {
			brandService.delete(brand);
		} catch (Exception e) {
			System.out.println("deleteBrand:/" + e.toString());
			throw new MyException();
		}
		return true;
	}

	@Override
	public boolean modifyBrand(Brand brand) {
		try {
			if (brand.getName() == null) {
				brand.setName("empty");
			}
			String website = brand.getWebsite();
			website = website.replace("http://", "");
			brand.setWebsite("http://" + website);
			brandService.update(brand);
		} catch (Exception e) {
			System.out.println("modifyBrand:/" + e.toString());
			throw new MyException();
		}
		return true;
	}

	@Override
	public Brand getABrand(Brand brand) {
		try {
			return brandService.select(brand);
		} catch (Exception e) {
			System.out.println("getABrand:/n" + e.toString());
			throw new MyException();
		}
	}

	@Override
	public List<Brand> getShowBrand() {
		try {
			return brandService.selectAll(true);
		} catch (Exception e) {
			System.out.println("getAllBrand:/" + e.toString());
			throw new MyException();
		}
	}

	@Override
	public List<Brand> getAllBrand() {
		try {
			return brandService.selectAll(false);
		} catch (Exception e) {
			System.out.println("getAllBrand:/n" + e.toString());
			throw new MyException();
		}
	}

}
