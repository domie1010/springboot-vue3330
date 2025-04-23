package com.entity;

public class Yuangong {
    private Integer id;
	private String gonghao;	private String mima;	private String xingming;	private String xingbie;	private String lianxishouji;	private String dizhi;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getGonghao() {
        return gonghao;
    }
    public void setGonghao(String gonghao) {
        this.gonghao = gonghao == null ? null : gonghao.trim();
    }	public String getMima() {
        return mima;
    }
    public void setMima(String mima) {
        this.mima = mima == null ? null : mima.trim();
    }	public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
        this.xingming = xingming == null ? null : xingming.trim();
    }	public String getXingbie() {
        return xingbie;
    }
    public void setXingbie(String xingbie) {
        this.xingbie = xingbie == null ? null : xingbie.trim();
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
