package xmu.mystore.goodsmgt.zlt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import xmu.mystore.goodsmgt.zlt.model.Goods;
import xmu.mystore.goodsmgt.zlt.model.SelectParameters;

@Component
public interface GoodsMapper {

	public void add(Goods goods);

	public void update(Goods goods);

	public void delete(Goods goods);

	public Goods select(Goods goods);

	public List<Goods> selectAll();
	
	public Goods selectBySerialCode(Goods goods);

	public List<Goods> selectByName(Goods goods);

	public List<Goods> selectByBrand(Goods goods);

	public List<Goods> selectByCategory(Goods goods);

	public List<Goods> selectByBrandAndCategory(Goods goods);

	public List<Goods> selectByPage(@Param("pageNumber") int pageNumber, @Param("pageSize") int pageSize);

	public List<Goods> selectBy(SelectParameters selects);
}
