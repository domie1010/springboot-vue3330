package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Tuidan;

public interface TuidanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tuidan record);

    int insertSelective(Tuidan record);

    Tuidan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tuidan record);
	
    int updateByPrimaryKey(Tuidan record);
	public Tuidan quchongTuidan(Map<String, Object> xiaoshoubianhao);
	public List<Tuidan> getAll(Map<String, Object> map);
	public List<Tuidan> getsytuidan1(Map<String, Object> map);
	public List<Tuidan> getsytuidan3(Map<String, Object> map);
	public List<Tuidan> getsytuidan2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Tuidan> getByPage(Map<String, Object> map);
	public List<Tuidan> select(Map<String, Object> map);
//	所有List
}

