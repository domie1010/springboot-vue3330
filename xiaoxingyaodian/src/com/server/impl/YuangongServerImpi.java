package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.YuangongMapper;
import com.entity.Yuangong;
import com.server.YuangongServer;
@Service
public class YuangongServerImpi implements YuangongServer {
   @Resource
   private YuangongMapper gdao;
	@Override
	public int add(Yuangong po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Yuangong po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Yuangong> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Yuangong> getsyyuangong1(Map<String, Object> map) {
		return gdao.getsyyuangong1(map);
	}
	public List<Yuangong> getsyyuangong2(Map<String, Object> map) {
		return gdao.getsyyuangong2(map);
	}
	public List<Yuangong> getsyyuangong3(Map<String, Object> map) {
		return gdao.getsyyuangong3(map);
	}
	
	@Override
	public Yuangong quchongYuangong(Map<String, Object> account) {
		return gdao.quchongYuangong(account);
	}

	@Override
	public List<Yuangong> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Yuangong> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Yuangong getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

