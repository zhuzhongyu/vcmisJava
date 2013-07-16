 package coboo.model.table;

import coboo.impl.DocDriver.meta.*;

/**
 * 重性精神病患者登记表
 */
public class SevereMentalPatientsRegistTab extends Table {

	Meta[] metas = {
			new NameMeta(), // 姓名
			new DocCodeMeta(), // 编号
			new GuardianMeta(), // 监护人
			new RelationWithPatientMeta(),// 与患者关系
			new GuardianAdressMeta(), // 监护人住址
			new GuardianPhoneMeta(), // 监护人电话
			new CommunityPhoneMeta(), // 居委会电话
			new FirstOnsetTimeMeta(), // 初次发作时间
			new PreviousMainDiseaseMeta(),// 既往主要症状
			new PreviousTreatmentMeta(), // 既往治疗情况
			new RecentDiagnosisMeta(),// 最近诊断情况
			new LastTreatmentMeta(), // 最近一次治疗效果
			new EventsMeta(), // 患者对家庭社会的影响事件
			new LockSituationMeta(), // 关锁情况
			new FillFormDateMeta(), // 填表日期
			new InformedConsentMeta(),//知情同意3
			new EconomicConditionsMeta(),//经济状况1
			new SpecialistDoctorAdviceMeta(),//专科医生意见1
			new DoctorNameMeta4() // 医生签字
	};
	private String Rpath="G/C/A";
	private String[] Keys={"jsbgl"};
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