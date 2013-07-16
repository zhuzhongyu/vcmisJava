package com.coboo.doctorstation;
import com.datebase.*;

/**
 * MedicineSellout entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class MedicineSellout implements java.io.Serializable {

	// Fields

	private Integer id;
	private Community community;
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
	private Double ypprice;
	private Double mtotal;
	private Integer thnums;
	private String ypgroupname;
	private Integer gjjbyw;
	private String paytype;
	private String xsname;
	private String syname;
	private String spbianma;
	private String pym;
	private String ypindex;
	private String bsf;

	// Constructors

	/** default constructor */
	public MedicineSellout() {
	}

	/** minimal constructor */
	public MedicineSellout(Community community, String riqi, String tiaoma,
			String ypname, String yptype, String ypdw, String ypgg,
			String yppihao, String ypyxq, String ypscqy, String yppzwh,
			String ypgroupname, String paytype, String xsname, String syname,
			String spbianma, String pym, String ypindex, String bsf) {
		this.community = community;
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
		this.ypgroupname = ypgroupname;
		this.paytype = paytype;
		this.xsname = xsname;
		this.syname = syname;
		this.spbianma = spbianma;
		this.pym = pym;
		this.ypindex = ypindex;
		this.bsf = bsf;
	}

	/** full constructor */
	public MedicineSellout(Community community, String danhao, String riqi,
			String tiaoma, String ypname, String yptype, String ypdw,
			String ypgg, String yppihao, String ypyxq, String ypscqy,
			String yppzwh, Integer nums, Double ypprice, Double mtotal,
			Integer thnums, String ypgroupname, Integer gjjbyw, String paytype,
			String xsname, String syname, String spbianma, String pym,
			String ypindex, String bsf) {
		this.community = community;
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
		this.ypprice = ypprice;
		this.mtotal = mtotal;
		this.thnums = thnums;
		this.ypgroupname = ypgroupname;
		this.gjjbyw = gjjbyw;
		this.paytype = paytype;
		this.xsname = xsname;
		this.syname = syname;
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

	public Community getCommunity() {
		return this.community;
	}

	public void setCommunity(Community community) {
		this.community = community;
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

	public Double getYpprice() {
		return this.ypprice;
	}

	public void setYpprice(Double ypprice) {
		this.ypprice = ypprice;
	}

	public Double getMtotal() {
		return this.mtotal;
	}

	public void setMtotal(Double mtotal) {
		this.mtotal = mtotal;
	}

	public Integer getThnums() {
		return this.thnums;
	}

	public void setThnums(Integer thnums) {
		this.thnums = thnums;
	}

	public String getYpgroupname() {
		return this.ypgroupname;
	}

	public void setYpgroupname(String ypgroupname) {
		this.ypgroupname = ypgroupname;
	}

	public Integer getGjjbyw() {
		return this.gjjbyw;
	}

	public void setGjjbyw(Integer gjjbyw) {
		this.gjjbyw = gjjbyw;
	}

	public String getPaytype() {
		return this.paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	public String getXsname() {
		return this.xsname;
	}

	public void setXsname(String xsname) {
		this.xsname = xsname;
	}

	public String getSyname() {
		return this.syname;
	}

	public void setSyname(String syname) {
		this.syname = syname;
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