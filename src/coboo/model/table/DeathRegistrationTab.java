 package coboo.model.table;

import coboo.impl.DocDriver.meta.*;
/**
 * 死亡登记表
 * @author Administrator
 *
 */
public class DeathRegistrationTab extends Table {

	Meta[] metas = { 
			new DocCodeMeta(),// 编号
			new DeadNameMeta(),// 死者姓名
			new HospitalizationIDMeta(),// 住院号
			new SexMeta(),// 性别
			new NationMeta(),// 民族
			new PersonIdMeta(),// 身份证号
			new WorkUnitMeta(),// 生前工作单位
			new ProfessionalMeta(),// 职业
			new MaritalStatusMeta(),// 婚姻状况
			new EducationMeta(),// 文化程度
			new FamiliesNameMeta(),// 死者家属姓名
			new FamiliesPhoneMeta(),// 家属联系电话
			new FamiliesAdressMeta(),// 家属地址
			new CensusRegisterAdressMeta(),// 户籍地址
			new DeadAdressMeta(),// 死者生前地址
			new DateOfBirthMeta(),// 出生日期
			new DeathDateMeta(),// 死亡日期
			new AgeOfDeathMeta(),// 死亡年龄
			new DeathSiteMeta(),// 死亡地点
			new CauseOfDeathMeta(),// 死亡原因
			new FillFormPersonMeta(),// 填表人
			new DataOfFillFormMeta(),// 填表日期
			new RemarkMeta() // 备注
	};
	private String Rpath="L/A";
	private String[] Keys={"isdeath"};
	private String[] Values={"true"};
	/**
	 * @return the metas
	 */
	public Meta[] getMetas() {
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
	/* (non-Javadoc)
	 * @see coboo.model.table.Table#save()
	 */
	@Override
	public void save() {
		// TODO Auto-generated method stub
		super.saveFile(this);
	}
	

}
