 package coboo.model.table;

import coboo.impl.DocDriver.meta.*;

/**
 * 重性精神病患者随访记录表
 */
public class SevereMentalPatientsFollowUpRecordTab extends Table {

	Meta[] metas = { new NameMeta(), // 姓名
			new DocCodeMeta(), // 编号
			new FollowUpDateMeta(), // 随访日期
			new PreviousMainDisease2Meta(), // 目前主要症状
			new SelfKnowledgeForceMeta(), // 自知力
			new MorpheusConditionMeta(), // 睡眠情况
			new DietConditionMeta(), // 饮食情况
			new PersonalSelfCareMeta(), // 社会功能情况--个人生活自理
			new GCBHouseworkMeta(), // 社会功能情况--家务劳动
			new ProductiveWorkMeta(), // 社会功能情况--生产劳动及工作
			new AbilityToLearnMeta(), // 社会功能情况--学习能力
			new SocialInterpersonalMeta(), // 社会功能情况--社会人际交往
			new EventsMeta(), // 患病对家庭社会的影响事件
			new LaboratoryExaminationMeta(),// 实验室检查
			new DrugDependenceMeta(), // 药物依赖性
			new DrugAdverseReactionsMeta(),// 药物不良反应
			new LastTreatmentMeta(), // 治疗效果
			new ClassificationMeta(), // 此次随访分类
			new Referral2Meta(), // 是否转诊
			new DrugSituationMeta(), // 用药情况
			new RehabilitationMeta(), // 康复措施
			new GCBNextFollowUpDateMeta(), // 下次随访日期
			
			new LockSituationMeta(),//关锁情况
			new HospitalizationsSituationMeta(),//住院情况2
			new RiskMeta(),//危险性1

			new DoctorNameMeta3() // 随访医生签名
	};
	private String Rpath="G/C/B";
	private String[] Keys={"psychiatricvisit"};
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