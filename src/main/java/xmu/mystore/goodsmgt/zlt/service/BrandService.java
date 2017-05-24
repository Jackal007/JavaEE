package xmu.mystore.goodsmgt.zlt.service;

import java.util.List;

import xmu.mystore.goodsmgt.zlt.model.Brand;

public interface BrandService {

	public boolean addBrand(Brand brand);

	public boolean deleteBrand(Brand brand);

	public boolean modifyBrand(Brand brand);

	public Brand getABrand(Brand brand);
	
	public List<Brand> getAllBrand();

	public List<Brand> getShowBrand();

}
