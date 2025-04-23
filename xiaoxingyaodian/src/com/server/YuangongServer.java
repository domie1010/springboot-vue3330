package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Yuangong;

public interface YuangongServer {

  public int add(Yuangong po);

  public int update(Yuangong po);
  
  
  
  public int delete(int id);

  public List<Yuangong> getAll(Map<String,Object> map);
  public List<Yuangong> getsyyuangong1(Map<String,Object> map);
  public List<Yuangong> getsyyuangong2(Map<String,Object> map);
  public List<Yuangong> getsyyuangong3(Map<String,Object> map);
  public Yuangong quchongYuangong(Map<String, Object> acount);

  public Yuangong getById( int id);

  public List<Yuangong> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Yuangong> select(Map<String, Object> map);
}
//	所有List
