package com.entity;

public class Gonghuoshangxinxi {
    private Integer id;
	private String gonghuoshang;	private String lianxishouji;	private String dizhi;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getGonghuoshang() {
        return gonghuoshang;
    }
    public void setGonghuoshang(String gonghuoshang) {
        this.gonghuoshang = gonghuoshang == null ? null : gonghuoshang.trim();
    }	public String getLianxishouji() {
        return lianxishouji;
    }
    public void setLianxishouji(String lianxishouji) {
        this.lianxishouji = lianxishouji == null ? null : lianxishouji.trim();
    }	public String getDizhi() {
        return dizhi;
    }
    public void setDizhi(String dizhi) {
        this.dizhi = dizhi == null ? null : dizhi.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
