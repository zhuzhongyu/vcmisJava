 package coboo.model.table;

import coboo.impl.DocDriver.meta.*;

/**
 * 肢残训练计划表
 * 
 * @author 任笑言
 */
public class DisabledTrainPlanTab extends Table {

	Meta[] metas = { 
			new DocCodeMeta(), // 编号
			new NameMeta(),// 姓名
			new SexMeta(),// 性别
			new PubEthnicMeta(),// 民族
			new BirthDateMeta(),// 出生日期
			new PersonIdMeta(),// 身份证号
			new AddressMeta(),// 家庭住址
			new CulturalDegreeMeta(),// 文化程度
			new MaritalStatusMeta(),// 婚姻状况
			new ProfessionMeta(),// 职业
			new GuardianMeta(),// 监护人
			new DisRelationMeta(),// 与残疾人关系
			new PhoneMeta(),// 联系电话
			new RealizationExpectedMeta(),// 康复目标
			new GuidanceMaterialsMeta(),// 训练指导材料
			new TrainPlaceMeta(),// 训练场所
			new TrainMethodsMeta(),// 训练方法
			new InstructorNameMeta(),// 康复指导员姓名
			new InstructorChildNameMeta(),// 康复员姓名
			new PlanDateMeta() // 制定计划日期

	};
	private String Rpath="G/B/C";
	 private String[] Keys={"DisabledTrainPlanTab"};
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
