 package coboo.model.table;

import coboo.impl.DocDriver.meta.*;
/**
 * 残疾人训练记录表
 * @author 任笑言
 */
public class DisabledTrainRecordTab extends Table {
	
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
			new FirstRecordDateMeta(),// 第一次记录日期
			new FirstRecordMeta(),// 第一次记录
			new FirstRecordNameMeta(),// 第一次签字
			new SecondRecordDateMeta(),// 第2次记录日期
			new SecondRecordMeta(),// 第2次记录
			new SecondRecordNameMeta(),// 第2次签字
			new ThirdRecordDateMeta(),// 第3次记录日期
			new ThirdRecordMeta(),// 第3次记录
			new ThirdRecordNameMeta(),// 第3次签字
			new ForthRecordDateMeta(),// 第4次记录日期
			new ForthRecordMeta(),// 第4次记录
			new ForthRecordNameMeta(),// 第4次签字
			new FifthRecordDateMeta(),// 第5次记录日期
			new FifthRecordMeta(),// 第5次记录
			new FifthRecordNameMeta(),// 第5次签字
			new SixthRecordDateMeta(),// 第6次记录日期
			new SixthRecordMeta(),// 第6次记录
			new SixthRecordNameMeta()// 第6次签字
	};
	private String Rpath="G/B/D";
	 private String[] Keys={"DisabledTrainRecordTab"};
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
