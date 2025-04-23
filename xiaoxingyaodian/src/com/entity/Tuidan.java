package com.entity;

public class Tuidan {
    private Integer id;
	private String xiaoshoubianhao;	private String tuidanyuanyin;	private String tuidanshijian;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getXiaoshoubianhao() {
        return xiaoshoubianhao;
    }
    public void setXiaoshoubianhao(String xiaoshoubianhao) {
        this.xiaoshoubianhao = xiaoshoubianhao == null ? null : xiaoshoubianhao.trim();
    }	public String getTuidanyuanyin() {
        return tuidanyuanyin;
    }
    public void setTuidanyuanyin(String tuidanyuanyin) {
        this.tuidanyuanyin = tuidanyuanyin == null ? null : tuidanyuanyin.trim();
    }	public String getTuidanshijian() {
        return tuidanshijian;
    }
    public void setTuidanshijian(String tuidanshijian) {
        this.tuidanshijian = tuidanshijian == null ? null : tuidanshijian.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
