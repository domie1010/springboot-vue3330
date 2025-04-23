package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Yuangongxinxi;

public interface YuangongxinxiServer {

  public int add(Yuangongxinxi po);

  public int update(Yuangongxinxi po);
  
  
  
  public int delete(int id);

  public List<Yuangongxinxi> getAll(Map<String,Object> map);
  public List<Yuangongxinxi> getsyyuangongxinxi1(Map<String,Object> map);
  public List<Yuangongxinxi> getsyyuangongxinxi2(Map<String,Object> map);
  public List<Yuangongxinxi> getsyyuangongxinxi3(Map<String,Object> map);
  public Yuangongxinxi quchongYuangongxinxi(Map<String, Object> acount);

  public Yuangongxinxi getById( int id);

  public List<Yuangongxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Yuangongxinxi> select(Map<String, Object> map);
}
//	所有List
