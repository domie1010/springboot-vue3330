package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Yuangong;

public interface YuangongMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Yuangong record);

    int insertSelective(Yuangong record);

    Yuangong selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Yuangong record);
	
    int updateByPrimaryKey(Yuangong record);
	public Yuangong quchongYuangong(Map<String, Object> gonghao);
	public List<Yuangong> getAll(Map<String, Object> map);
	public List<Yuangong> getsyyuangong1(Map<String, Object> map);
	public List<Yuangong> getsyyuangong3(Map<String, Object> map);
	public List<Yuangong> getsyyuangong2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Yuangong> getByPage(Map<String, Object> map);
	public List<Yuangong> select(Map<String, Object> map);
//	所有List
}

