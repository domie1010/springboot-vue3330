package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.YuangongxinxiMapper;
import com.entity.Yuangongxinxi;
import com.server.YuangongxinxiServer;
@Service
public class YuangongxinxiServerImpi implements YuangongxinxiServer {
   @Resource
   private YuangongxinxiMapper gdao;
	@Override
	public int add(Yuangongxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Yuangongxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Yuangongxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Yuangongxinxi> getsyyuangongxinxi1(Map<String, Object> map) {
		return gdao.getsyyuangongxinxi1(map);
	}
	public List<Yuangongxinxi> getsyyuangongxinxi2(Map<String, Object> map) {
		return gdao.getsyyuangongxinxi2(map);
	}
	public List<Yuangongxinxi> getsyyuangongxinxi3(Map<String, Object> map) {
		return gdao.getsyyuangongxinxi3(map);
	}
	
	@Override
	public Yuangongxinxi quchongYuangongxinxi(Map<String, Object> account) {
		return gdao.quchongYuangongxinxi(account);
	}

	@Override
	public List<Yuangongxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Yuangongxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Yuangongxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

