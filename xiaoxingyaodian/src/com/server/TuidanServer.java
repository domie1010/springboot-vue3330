package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Tuidan;

public interface TuidanServer {

  public int add(Tuidan po);

  public int update(Tuidan po);
  
  
  
  public int delete(int id);

  public List<Tuidan> getAll(Map<String,Object> map);
  public List<Tuidan> getsytuidan1(Map<String,Object> map);
  public List<Tuidan> getsytuidan2(Map<String,Object> map);
  public List<Tuidan> getsytuidan3(Map<String,Object> map);
  public Tuidan quchongTuidan(Map<String, Object> acount);

  public Tuidan getById( int id);

  public List<Tuidan> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Tuidan> select(Map<String, Object> map);
}
//	所有List
