package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Xiaoshouxinxi;

public interface XiaoshouxinxiServer {

  public int add(Xiaoshouxinxi po);

  public int update(Xiaoshouxinxi po);
  
  
  
  public int delete(int id);

  public List<Xiaoshouxinxi> getAll(Map<String,Object> map);
  public List<Xiaoshouxinxi> getsyxiaoshouxinxi1(Map<String,Object> map);
  public List<Xiaoshouxinxi> getsyxiaoshouxinxi2(Map<String,Object> map);
  public List<Xiaoshouxinxi> getsyxiaoshouxinxi3(Map<String,Object> map);
  public Xiaoshouxinxi quchongXiaoshouxinxi(Map<String, Object> acount);

  public Xiaoshouxinxi getById( int id);

  public List<Xiaoshouxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Xiaoshouxinxi> select(Map<String, Object> map);
}
//	所有List
