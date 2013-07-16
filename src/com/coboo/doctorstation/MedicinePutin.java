package com.coboo.doctorstation;

/**
 * MedicinePutin entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class MedicinePutin implements java.io.Serializable {

	// Fields

	private Integer id;
	private String danhao;
	private String riqi;
	private String tiaoma;
	private String ypname;
	private String yptype;
	private String ypdw;
	private String ypgg;
	private String yppihao;
	private String ypyxq;
	private String ypscqy;
	private String yppzwh;
	private Integer nums;
	private Double inprice;
	private Double ypprice;
	private String czy;
	private String bgy;
	private String fhy;
	private Double mtotal;
	private String ypgroupname;
	private String ghdw;
	private String zcsb;
	private String zlzk;
	private String ysjl;
	private String ysy;
	private String memo;
	private Integer gjjbyw;
	private String spbianma;
	private String pym;
	private String ypindex;
	private String bsf;

	// Constructors

	/** default constructor */
	public MedicinePutin() {
	}

	/** minimal constructor */
	public MedicinePutin(String riqi, String tiaoma, String ypname,
			String yptype, String ypdw, String ypgg, String yppihao,
			String ypyxq, String ypscqy, String yppzwh, Integer nums,
			String czy, String bgy, String fhy, String ypgroupname,
			String ghdw, String zcsb, String zlzk, String ysjl, String ysy,
			String memo, String spbianma, String pym, String ypindex, String bsf) {
		this.riqi = riqi;
		this.tiaoma = tiaoma;
		this.ypname = ypname;
		this.yptype = yptype;
		this.ypdw = ypdw;
		this.ypgg = ypgg;
		this.yppihao = yppihao;
		this.ypyxq = ypyxq;
		this.ypscqy = ypscqy;
		this.yppzwh = yppzwh;
		this.nums = nums;
		this.czy = czy;
		this.bgy = bgy;
		this.fhy = fhy;
		this.ypgroupname = ypgroupname;
		this.ghdw = ghdw;
		this.zcsb = zcsb;
		this.zlzk = zlzk;
		this.ysjl = ysjl;
		this.ysy = ysy;
		this.memo = memo;
		this.spbianma = spbianma;
		this.pym = pym;
		this.ypindex = ypindex;
		this.bsf = bsf;
	}

	/** full constructor */
	public MedicinePutin(String danhao, String riqi, String tiaoma,
			String ypname, String yptype, String ypdw, String ypgg,
			String yppihao, String ypyxq, String ypscqy, String yppzwh,
			Integer nums, Double inprice, Double ypprice, String czy,
			String bgy, String fhy, Double mtotal, String ypgroupname,
			String ghdw, String zcsb, String zlzk, String ysjl, String ysy,
			String memo, Integer gjjbyw, String spbianma, String pym,
			String ypindex, String bsf) {
		this.danhao = danhao;
		this.riqi = riqi;
		this.tiaoma = tiaoma;
		this.ypname = ypname;
		this.yptype = yptype;
		this.ypdw = ypdw;
		this.ypgg = ypgg;
		this.yppihao = yppihao;
		this.ypyxq = ypyxq;
		this.ypscqy = ypscqy;
		this.yppzwh = yppzwh;
		this.nums = nums;
		this.inprice = inprice;
		this.ypprice = ypprice;
		this.czy = czy;
		this.bgy = bgy;
		this.fhy = fhy;
		this.mtotal = mtotal;
		this.ypgroupname = ypgroupname;
		this.ghdw = ghdw;
		this.zcsb = zcsb;
		this.zlzk = zlzk;
		this.ysjl = ysjl;
		this.ysy = ysy;
		this.memo = memo;
		this.gjjbyw = gjjbyw;
		this.spbianma = spbianma;
		this.pym = pym;
		this.ypindex = ypindex;
		this.bsf = bsf;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDanhao() {
		return this.danhao;
	}

	public void setDanhao(String danhao) {
		this.danhao = danhao;
	}

	public String getRiqi() {
		return this.riqi;
	}

	public void setRiqi(String riqi) {
		this.riqi = riqi;
	}

	public String getTiaoma() {
		return this.tiaoma;
	}

	public void setTiaoma(String tiaoma) {
		this.tiaoma = tiaoma;
	}

	public String getYpname() {
		return this.ypname;
	}

	public void setYpname(String ypname) {
		this.ypname = ypname;
	}

	public String getYptype() {
		return this.yptype;
	}

	public void setYptype(String yptype) {
		this.yptype = yptype;
	}

	public String getYpdw() {
		return this.ypdw;
	}

	public void setYpdw(String ypdw) {
		this.ypdw = ypdw;
	}

	public String getYpgg() {
		return this.ypgg;
	}

	public void setYpgg(String ypgg) {
		this.ypgg = ypgg;
	}

	public String getYppihao() {
		return this.yppihao;
	}

	public void setYppihao(String yppihao) {
		this.yppihao = yppihao;
	}

	public String getYpyxq() {
		return this.ypyxq;
	}

	public void setYpyxq(String ypyxq) {
		this.ypyxq = ypyxq;
	}

	public String getYpscqy() {
		return this.ypscqy;
	}

	public void setYpscqy(String ypscqy) {
		this.ypscqy = ypscqy;
	}

	public String getYppzwh() {
		return this.yppzwh;
	}

	public void setYppzwh(String yppzwh) {
		this.yppzwh = yppzwh;
	}

	public Integer getNums() {
		return this.nums;
	}

	public void setNums(Integer nums) {
		this.nums = nums;
	}

	public Double getInprice() {
		return this.inprice;
	}

	public void setInprice(Double inprice) {
		this.inprice = inprice;
	}

	public Double getYpprice() {
		return this.ypprice;
	}

	public void setYpprice(Double ypprice) {
		this.ypprice = ypprice;
	}

	public String getCzy() {
		return this.czy;
	}

	public void setCzy(String czy) {
		this.czy = czy;
	}

	public String getBgy() {
		return this.bgy;
	}

	public void setBgy(String bgy) {
		this.bgy = bgy;
	}

	public String getFhy() {
		return this.fhy;
	}

	public void setFhy(String fhy) {
		this.fhy = fhy;
	}

	public Double getMtotal() {
		return this.mtotal;
	}

	public void setMtotal(Double mtotal) {
		this.mtotal = mtotal;
	}

	public String getYpgroupname() {
		return this.ypgroupname;
	}

	public void setYpgroupname(String ypgroupname) {
		this.ypgroupname = ypgroupname;
	}

	public String getGhdw() {
		return this.ghdw;
	}

	public void setGhdw(String ghdw) {
		this.ghdw = ghdw;
	}

	public String getZcsb() {
		return this.zcsb;
	}

	public void setZcsb(String zcsb) {
		this.zcsb = zcsb;
	}

	public String getZlzk() {
		return this.zlzk;
	}

	public void setZlzk(String zlzk) {
		this.zlzk = zlzk;
	}

	public String getYsjl() {
		return this.ysjl;
	}

	public void setYsjl(String ysjl) {
		this.ysjl = ysjl;
	}

	public String getYsy() {
		return this.ysy;
	}

	public void setYsy(String ysy) {
		this.ysy = ysy;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Integer getGjjbyw() {
		return this.gjjbyw;
	}

	public void setGjjbyw(Integer gjjbyw) {
		this.gjjbyw = gjjbyw;
	}

	public String getSpbianma() {
		return this.spbianma;
	}

	public void setSpbianma(String spbianma) {
		this.spbianma = spbianma;
	}

	public String getPym() {
		return this.pym;
	}

	public void setPym(String pym) {
		this.pym = pym;
	}

	public String getYpindex() {
		return this.ypindex;
	}

	public void setYpindex(String ypindex) {
		this.ypindex = ypindex;
	}

	public String getBsf() {
		return this.bsf;
	}

	public void setBsf(String bsf) {
		this.bsf = bsf;
	}

}