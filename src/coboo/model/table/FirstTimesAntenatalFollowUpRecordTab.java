 package coboo.model.table;

import coboo.impl.DocDriver.meta.*;
/**
 * 第一次产前随访记录表
 * @author ghy
 *
 */
public class FirstTimesAntenatalFollowUpRecordTab extends Table {
	ReferralMeta ReferralMeta=new ReferralMeta();
	Meta[] metas = {
			new NameMeta(),					//姓名
			new DocCodeMeta(),				//编号
			new WriteDataMeta(),			//填表日期
			new WritePregnantCycleMeta(),	//填表孕周
			
			new PregnantWomanAgeMeta(),		//孕妇年龄
			new PersonalHistoryMeta(),//个人史
			new FiveHepatitisBMeta(),//乙型肝炎五项
			new HealthGuidanceMeta(),//保健指导
			
			new BloodTypeMeta(),//血型
			new BSonographyCheckResultsMeta(),//B超
			new FastingGlucose1(),//血糖
			new HusbandNameMeta(),			//丈夫姓名
			new HusbandAgeMeta(),			//丈夫年龄
			new HusbandPhoneMeta(),			//丈夫电话
			new PregnantTimeMeta(),			//孕次
			new ProductionTimesMeta(),		//产次
			new LastMenstrualMeta(),		//末次月经
			new ScheduledBrithMeta(),		//预产期
			new WCEADiseaseHistoryMeta(),		//既往史
			new FamilyMedicalHistoryMeta(),	//家族史
			new WomenSurgeryHistoryMeta(),	//妇科手术史
			new ScheduledBrithHistoryMeta(),//孕产史
			new HeightMeta(),				//身高
			new WeightMeta(),				//体重
			new PhysiqueIndexesMeta(),		//体质指数
			new WABloodPressureMeta(),		//血压
			new AuscultationHeartMeta(),	//听诊--心脏
			new AuscultationLungMeta(),		//听诊--肺部
			new WCEAVulvaeCheckMeta(),			//妇科检查--外阴
			new WCEAVaginalCheckMeta(),			//妇科检查--阴道
			new WCEACervicalCheckMeta(),		//妇科检查--宫颈
			new WCEAUterineCheckMeta(),			//妇科检查--子宫
			new WCEAAdnexitisCheckMeta(),		//妇科检查--附件
			new RoutineBloodCheckMeta(),	//辅助检查--血常规
			new RoutineUrineCheckMeta(),	//辅助检查--尿常规
			new LiverFunctionCheckMeta(),	//辅助检查--肝功能
			new RenalCheckMeta(),			//辅助检查--肾功能
			new VaginalSecretionsMeta(),	//辅助检查--阴道分泌物
			new SyphilisSerumCheckMeta(),	//辅助检查--梅毒血清抗体检测
			new HivAntibodyCheckMeta(),		//辅助检查--HIV抗体检测
			new OverallAssessmentMeta(),	//总体评估
			ReferralMeta,				//转诊
			new NextFollowupTimeMeta(),		//下次随访日期
			new FollowupDoctorNameMeta()	//随访医生签名
	};
	private String Rpath="C/E/A";
    private String[] Keys={"prenatalfollowup1"};
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
