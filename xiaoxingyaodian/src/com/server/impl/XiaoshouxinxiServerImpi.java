package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.XiaoshouxinxiMapper;
import com.entity.Xiaoshouxinxi;
import com.server.XiaoshouxinxiServer;
@Service
public class XiaoshouxinxiServerImpi implements XiaoshouxinxiServer {
   @Resource
   private XiaoshouxinxiMapper gdao;
	@Override
	public int add(Xiaoshouxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Xiaoshouxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Xiaoshouxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Xiaoshouxinxi> getsyxiaoshouxinxi1(Map<String, Object> map) {
		return gdao.getsyxiaoshouxinxi1(map);
	}
	public List<Xiaoshouxinxi> getsyxiaoshouxinxi2(Map<String, Object> map) {
		return gdao.getsyxiaoshouxinxi2(map);
	}
	public List<Xiaoshouxinxi> getsyxiaoshouxinxi3(Map<String, Object> map) {
		return gdao.getsyxiaoshouxinxi3(map);
	}
	
	@Override
	public Xiaoshouxinxi quchongXiaoshouxinxi(Map<String, Object> account) {
		return gdao.quchongXiaoshouxinxi(account);
	}

	@Override
	public List<Xiaoshouxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Xiaoshouxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Xiaoshouxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

