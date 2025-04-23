package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Caigouxinxi;

public interface CaigouxinxiServer {

  public int add(Caigouxinxi po);

  public int update(Caigouxinxi po);
  
  
  
  public int delete(int id);

  public List<Caigouxinxi> getAll(Map<String,Object> map);
  public List<Caigouxinxi> getsycaigouxinxi1(Map<String,Object> map);
  public List<Caigouxinxi> getsycaigouxinxi2(Map<String,Object> map);
  public List<Caigouxinxi> getsycaigouxinxi3(Map<String,Object> map);
  public Caigouxinxi quchongCaigouxinxi(Map<String, Object> acount);

  public Caigouxinxi getById( int id);

  public List<Caigouxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Caigouxinxi> select(Map<String, Object> map);
}
//	所有List
