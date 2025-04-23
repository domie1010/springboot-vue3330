package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.CaigouxinxiMapper;
import com.entity.Caigouxinxi;
import com.server.CaigouxinxiServer;
@Service
public class CaigouxinxiServerImpi implements CaigouxinxiServer {
   @Resource
   private CaigouxinxiMapper gdao;
	@Override
	public int add(Caigouxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Caigouxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Caigouxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Caigouxinxi> getsycaigouxinxi1(Map<String, Object> map) {
		return gdao.getsycaigouxinxi1(map);
	}
	public List<Caigouxinxi> getsycaigouxinxi2(Map<String, Object> map) {
		return gdao.getsycaigouxinxi2(map);
	}
	public List<Caigouxinxi> getsycaigouxinxi3(Map<String, Object> map) {
		return gdao.getsycaigouxinxi3(map);
	}
	
	@Override
	public Caigouxinxi quchongCaigouxinxi(Map<String, Object> account) {
		return gdao.quchongCaigouxinxi(account);
	}

	@Override
	public List<Caigouxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Caigouxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Caigouxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

