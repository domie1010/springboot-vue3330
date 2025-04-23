package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Gonghuoshangxinxi;

public interface GonghuoshangxinxiServer {

  public int add(Gonghuoshangxinxi po);

  public int update(Gonghuoshangxinxi po);
  
  
  
  public int delete(int id);

  public List<Gonghuoshangxinxi> getAll(Map<String,Object> map);
  public List<Gonghuoshangxinxi> getsygonghuoshangxinxi1(Map<String,Object> map);
  public List<Gonghuoshangxinxi> getsygonghuoshangxinxi2(Map<String,Object> map);
  public List<Gonghuoshangxinxi> getsygonghuoshangxinxi3(Map<String,Object> map);
  public Gonghuoshangxinxi quchongGonghuoshangxinxi(Map<String, Object> acount);

  public Gonghuoshangxinxi getById( int id);

  public List<Gonghuoshangxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Gonghuoshangxinxi> select(Map<String, Object> map);
}
//	所有List
