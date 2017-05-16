package com.xmu.sw.zjh.javaee.dao;

import org.springframework.stereotype.Component;

import com.xmu.sw.zjh.javaee.entity.Card;

@Component
public interface  ICardDao
{
	Card get(Integer id);
}
