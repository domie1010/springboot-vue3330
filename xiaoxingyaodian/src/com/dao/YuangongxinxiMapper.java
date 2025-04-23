package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Yuangongxinxi;

public interface YuangongxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Yuangongxinxi record);

    int insertSelective(Yuangongxinxi record);

    Yuangongxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Yuangongxinxi record);
	
    int updateByPrimaryKey(Yuangongxinxi record);
	public Yuangongxinxi quchongYuangongxinxi(Map<String, Object> gonghao);
	public List<Yuangongxinxi> getAll(Map<String, Object> map);
	public List<Yuangongxinxi> getsyyuangongxinxi1(Map<String, Object> map);
	public List<Yuangongxinxi> getsyyuangongxinxi3(Map<String, Object> map);
	public List<Yuangongxinxi> getsyyuangongxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Yuangongxinxi> getByPage(Map<String, Object> map);
	public List<Yuangongxinxi> select(Map<String, Object> map);
//	所有List
}

