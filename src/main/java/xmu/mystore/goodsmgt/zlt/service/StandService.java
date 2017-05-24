package xmu.mystore.goodsmgt.zlt.service;

import java.util.List;

import xmu.mystore.goodsmgt.zlt.model.Stand;

public interface StandService {

	public boolean modifyStand(Stand stand);

	public Stand getAStand(Stand stand);

	public List<Stand> getAllStand();

}
