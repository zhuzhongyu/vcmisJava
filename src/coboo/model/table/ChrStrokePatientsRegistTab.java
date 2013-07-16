package coboo.model.table;

import coboo.impl.DocDriver.meta.*;

/**
 * 脑卒中患者精神状态登记表
 * 
 * @author 任笑言
 * 
 */
public class ChrStrokePatientsRegistTab extends Table {
	SexMeta				sexMeta					= new SexMeta();
	 DisRelationMeta DisRelationMeta=new DisRelationMeta();
	Meta[] metas = { 
			new DocCodeMeta(), // 编号
			new NameMeta(),// 姓名
			sexMeta,// 性别
			new EthnicMeta(),// 民族
			new BirthDateMeta(),// 出生日期
			new PersonIdMeta(),// 身份证号
			new AddressMeta(),// 家庭住址
			new CulturalDegreeMeta(),// 文化程度
			new MaritalStatusMeta(),// 婚姻状况
			new ProfessionalMeta(),// 职业
			new GuardianMeta(),// 监护人
			DisRelationMeta,// 与残疾人关系
			new PhoneMeta(),// 联系电话
			new TestScaleMeta() // 测试评分表

	};
	private String Rpath="E/D";	
	private String[] Keys={"nzz"};
	private String[] Values={"true"};
	/**
	 * @return the keys
	 */
	public String[] getKeys() {
		return Keys;
	}
	/**
	 * @param keys the keys to set
	 */
	public void setKeys(String[] keys) {
		Keys = keys;
	}
	/**
	 * @return the values
	 */
	public String[] getValues() {
		return Values;
	}
	/**
	 * @param values the values to set
	 */
	public void setValues(String[] values) {
		Values = values;
	}
	/**
	 * @return the metas
	 */
	public Meta[] getMetas() {
		sexMeta.setSIds( new String[] { "xb1" });
		return metas;
	}
	/**
	 * @param metas the metas to set
	 */
	public void setMetas(Meta[] metas) {
		this.metas = metas;
	}
	/**
	 * @return the rpath
	 */
	public String getRpath() {
		return Rpath;
	}
	/**
	 * @param rpath the rpath to set
	 */
	public void setRpath(String rpath) {
		Rpath = rpath;
	}
	/* (non-Javadoc)
	 * @see coboo.model.table.Table#save()
	 */
	@Override
	public void save() {
		// TODO Auto-generated method stub
		super.saveFile(this);
	}

	
	
	
}
