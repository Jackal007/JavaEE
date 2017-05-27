package xmu.mystore.goodsmgt.zlt.service.impls;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xmu.mystore.goodsmgt.zlt.exception.MyException;
import xmu.mystore.goodsmgt.zlt.mapper.StandMapper;
import xmu.mystore.goodsmgt.zlt.model.*;
import xmu.mystore.goodsmgt.zlt.service.StandService;

@Service("StandService")
@Transactional
public class StandServiceImpl implements StandService {
	@Autowired
	private StandMapper standMapper;

	@Override
	public boolean modifyStand(Stand stand) {
		try {
			standMapper.update(stand);
			return true;
		} catch (Exception e) {
			System.out.println("modifyStand:/n" + e.toString());
			throw new MyException();
		}
	}

	@Override
	public List<Stand> getAllStand() {
		try {
			return standMapper.selectAll();
		} catch (Exception e) {
			System.out.println("getAllStand:/n" + e.toString());
			throw new MyException();
		}
	}

	@Override
	public Stand getAStand(Stand stand) {
		try {
			return standMapper.select(stand);
		} catch (Exception e) {
			System.out.println("getAStand:/n" + e.toString());
			throw new MyException();
		}
	}

	private Stand GoodsToStand(Goods goods) {
		Stand stand = new Stand();
		stand.setGoods_id(goods.getId());
		stand.setMarket_price(goods.getMarket_price());
		stand.setMid_user_price(goods.getMid_user_price());
		stand.setPre_sale_count(goods.getPre_sale_number());
		stand.setReal_price(goods.getReal_price());
		return stand;
	}

	private Goods StandToGoods(Stand stand) {
		Goods goods = new Goods();
		goods.setStand_id(stand.getId());
		goods.setMarket_price(stand.getMarket_price());
		goods.setMid_user_price(stand.getMid_user_price());
		goods.setPre_sale_number(stand.getPre_sale_count());
		goods.setReal_price(stand.getReal_price());
		return goods;
	}

	@SuppressWarnings({ "deprecation" })
	private boolean isOnMarket(Stand stand) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date on = simpleDateFormat.parse(stand.getOn_market_time());
			Date off = simpleDateFormat.parse(stand.getOff_market_time());
			Date now = new Date();
			if (now.getDate() >= on.getDate() && now.getDate() <= off.getDate()) {
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
}
