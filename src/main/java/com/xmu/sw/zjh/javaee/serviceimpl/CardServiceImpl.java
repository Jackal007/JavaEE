package com.xmu.sw.zjh.javaee.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xmu.sw.zjh.javaee.dao.ICardDao;
import com.xmu.sw.zjh.javaee.entity.Card;
import com.xmu.sw.zjh.javaee.service.ICardService;

@Service("cardService")
@Transactional
public class CardServiceImpl implements ICardService
{
	@Autowired
	private ICardDao cardDao;
	
	public Card getCardById(int id)
	{
		return this.cardDao.get(id);
	}
}
