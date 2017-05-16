package com.xmu.sw.zjh.javaee.entity;

import java.io.Serializable;

public class Card implements Serializable
{
	private static final long serialVersionUID = -1602869510945935769L;
	private Integer id;
	private String code;
	private Person person;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
