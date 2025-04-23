package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TuidanMapper;
import com.entity.Tuidan;
import com.server.TuidanServer;
@Service
public class TuidanServerImpi implements TuidanServer {
   @Resource
   private TuidanMapper gdao;
	@Override
	public int add(Tuidan po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Tuidan po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Tuidan> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Tuidan> getsytuidan1(Map<String, Object> map) {
		return gdao.getsytuidan1(map);
	}
	public List<Tuidan> getsytuidan2(Map<String, Object> map) {
		return gdao.getsytuidan2(map);
	}
	public List<Tuidan> getsytuidan3(Map<String, Object> map) {
		return gdao.getsytuidan3(map);
	}
	
	@Override
	public Tuidan quchongTuidan(Map<String, Object> account) {
		return gdao.quchongTuidan(account);
	}

	@Override
	public List<Tuidan> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Tuidan> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Tuidan getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

