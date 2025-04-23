package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.GonghuoshangxinxiMapper;
import com.entity.Gonghuoshangxinxi;
import com.server.GonghuoshangxinxiServer;
@Service
public class GonghuoshangxinxiServerImpi implements GonghuoshangxinxiServer {
   @Resource
   private GonghuoshangxinxiMapper gdao;
	@Override
	public int add(Gonghuoshangxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Gonghuoshangxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Gonghuoshangxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Gonghuoshangxinxi> getsygonghuoshangxinxi1(Map<String, Object> map) {
		return gdao.getsygonghuoshangxinxi1(map);
	}
	public List<Gonghuoshangxinxi> getsygonghuoshangxinxi2(Map<String, Object> map) {
		return gdao.getsygonghuoshangxinxi2(map);
	}
	public List<Gonghuoshangxinxi> getsygonghuoshangxinxi3(Map<String, Object> map) {
		return gdao.getsygonghuoshangxinxi3(map);
	}
	
	@Override
	public Gonghuoshangxinxi quchongGonghuoshangxinxi(Map<String, Object> account) {
		return gdao.quchongGonghuoshangxinxi(account);
	}

	@Override
	public List<Gonghuoshangxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Gonghuoshangxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Gonghuoshangxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

