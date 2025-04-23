package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Xiaoshouxinxi;

public interface XiaoshouxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Xiaoshouxinxi record);

    int insertSelective(Xiaoshouxinxi record);

    Xiaoshouxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Xiaoshouxinxi record);
	
    int updateByPrimaryKey(Xiaoshouxinxi record);
	public Xiaoshouxinxi quchongXiaoshouxinxi(Map<String, Object> xiaoshoubianhao);
	public List<Xiaoshouxinxi> getAll(Map<String, Object> map);
	public List<Xiaoshouxinxi> getsyxiaoshouxinxi1(Map<String, Object> map);
	public List<Xiaoshouxinxi> getsyxiaoshouxinxi3(Map<String, Object> map);
	public List<Xiaoshouxinxi> getsyxiaoshouxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Xiaoshouxinxi> getByPage(Map<String, Object> map);
	public List<Xiaoshouxinxi> select(Map<String, Object> map);
//	所有List
}

