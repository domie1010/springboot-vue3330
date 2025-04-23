package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Caigouxinxi;

public interface CaigouxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Caigouxinxi record);

    int insertSelective(Caigouxinxi record);

    Caigouxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Caigouxinxi record);
	
    int updateByPrimaryKey(Caigouxinxi record);
	public Caigouxinxi quchongCaigouxinxi(Map<String, Object> caigoubianhao);
	public List<Caigouxinxi> getAll(Map<String, Object> map);
	public List<Caigouxinxi> getsycaigouxinxi1(Map<String, Object> map);
	public List<Caigouxinxi> getsycaigouxinxi3(Map<String, Object> map);
	public List<Caigouxinxi> getsycaigouxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Caigouxinxi> getByPage(Map<String, Object> map);
	public List<Caigouxinxi> select(Map<String, Object> map);
//	所有List
}

