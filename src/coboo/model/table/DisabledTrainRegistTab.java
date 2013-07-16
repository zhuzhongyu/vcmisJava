 package coboo.model.table;

import coboo.impl.DocDriver.meta.*;

/**
 * 肢残训练登记表
 * 
 * @author 任笑言
 */
public class DisabledTrainRegistTab extends Table {
	Meta[] metas = { 
			new DocCodeMeta(), // 编号
			new NameMeta(), // 姓名
			new SexMeta(), // 性别
			new PubEthnicMeta(), // 民族
			new BirthDateMeta(),// 出生日期
			new PersonIdMeta(),// 身份证号
			new AddressMeta(),// 家庭住址
			new CulturalDegreeMeta(),// 文化程度
			new MaritalStatusMeta(),// 婚姻状况
			new ProfessionMeta(),// 职业
			new GuardianMeta(),// 监护人
			new DisRelationMeta(),// 与残疾人关系
			new PhoneMeta(),// 联系电话
			new DisCategoryMeta(),// 肢体残疾类别
			new LimbsDateMeta(),// 肢体时间
			new DisCauseMeta(),// 致残原因
			new GetwellCaseMeta(),// 既往医疗，康复情况
			new ExplainCaseMeta() // 需要说明的情况
	};
	private String Rpath="G/B/A";
	 private String[] Keys={"DisabledTrainRegistTab"};
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
