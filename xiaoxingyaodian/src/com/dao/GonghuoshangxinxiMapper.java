package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Gonghuoshangxinxi;

public interface GonghuoshangxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Gonghuoshangxinxi record);

    int insertSelective(Gonghuoshangxinxi record);

    Gonghuoshangxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gonghuoshangxinxi record);
	
    int updateByPrimaryKey(Gonghuoshangxinxi record);
	public Gonghuoshangxinxi quchongGonghuoshangxinxi(Map<String, Object> gonghuoshang);
	public List<Gonghuoshangxinxi> getAll(Map<String, Object> map);
	public List<Gonghuoshangxinxi> getsygonghuoshangxinxi1(Map<String, Object> map);
	public List<Gonghuoshangxinxi> getsygonghuoshangxinxi3(Map<String, Object> map);
	public List<Gonghuoshangxinxi> getsygonghuoshangxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Gonghuoshangxinxi> getByPage(Map<String, Object> map);
	public List<Gonghuoshangxinxi> select(Map<String, Object> map);
//	所有List
}

