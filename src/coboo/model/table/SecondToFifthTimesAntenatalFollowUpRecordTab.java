 package coboo.model.table;

import coboo.impl.DocDriver.meta.*;

/**
 * 第二到第五次产前随访记录表
 * 
 */
public class SecondToFifthTimesAntenatalFollowUpRecordTab extends Table {

	Meta[] metas = { 
			new NameMeta(), // 姓名
			new DocCodeMeta(), // 编号
			new SecondTimesDataMeta(),// 第二次随访日期
			new SecondTimesFetalMeta(),//第二次随访__胎位
			new SecondTimesPregnantCycleMeta(),// 第二次随访孕周
			new SecondTimesMainTellingMeta(),// 第二次随访主诉
			new SecondTimesWeightMeta(),// 第二次随访体重
			new SecondTimesPalaceBottomHeightMeta(),// 第二次随访宫底高度
			new SecondTimesGTTSMeta(),// 第二次随访腹围
			new SecondTimesFetalHeartRateMeta(),// 第二次随访胎心率
			new SecondTimesBloodPressureMeta(),// 第二次随访血压
			new SecondTimesHemoglobinValueMeta(),// 第二次随访血红蛋白值
			new SecondTimesUrinaryProteinMeta(),// 第二次随访尿蛋白
			new SecondTimesOtherCheckMeta(),// 第二次随访其他检查
			new SecondTimesClassificationMeta(),// 第二次随访分类
			new SecondTimesGuidanceMeta(),// 第二次随访指导
			new SecondTimesReferralMeta(),// 第二次随访转诊
			new SecondTimesNextFollowUpDataMeta(),// 第二次随访下次随访日期
			new SecondTimesDoctorNameMeta(),// 第二次随访随访医生签名

			new ThirdTimesFetalMeta(),//第三次随访__胎位
			new ThirdTimesDataMeta(),// 第三次随访日期
			new ThirdTimesPregnantCycleMeta(),// 第三次随访孕周
			new ThirdTimesMainTellingMeta(),// 第三次随访主诉
			new ThirdTimesWeightMeta(),// 第三次随访体重
			new ThirdTimesPalaceBottomHeightMeta(),// 第三次随访宫底高度
			new ThirdTimesGTTSMeta(),// 第三次随访腹围
			new ThirdTimesFetalHeartRateMeta(),// 第三次随访胎心率
			new ThirdTimesBloodPressureMeta(),// 第三次随访血压
			new ThirdTimesHemoglobinValueMeta(),// 第三次随访血红蛋白值
			new ThirdTimesUrinaryProteinMeta(),// 第三次随访尿蛋白
			new ThirdTimesOtherCheckMeta(),// 第三次随访其他检查
			new ThirdTimesClassificationMeta(),// 第三次随访分类
			new ThirdTimesGuidanceMeta(),// 第三次随访指导
			new ThirdTimesNextFollowUpDataMeta(),// 第三次随访下次随访日期
			new ThirdTimesDoctorNameMeta(),// 第三次随访随访医生签名

			new FourthTimesFetalMeta(),//第四次随访__胎位
			new FourthTimesDataMeta(),// 第四次随访日期
			new FourthTimesPregnantCycleMeta(),// 第四次随访孕周
			new FourthTimesMainTellingMeta(),// 第四次随访主诉
			new FourthTimesWeightMeta(),// 第四次随访体重
			new FourthTimesPalaceBottomHeightMeta(),// 第四次随访宫底高度
			new FourthTimesGTTSMeta(),// 第四次随访腹围
			new FourthTimesFetalHeartRateMeta(),// 第四次随访胎心率
			new FourthTimesBloodPressureMeta(),// 第四次随访血压
			new FourthTimesHemoglobinValueMeta(),// 第四次随访血红蛋白值
			new FourthTimesUrinaryProteinMeta(),// 第四次随访尿蛋白
			new FourthTimesOtherCheckMeta(),// 第四次随访其他检查
			new FourthTimesClassificationMeta(),// 第四次随访分类
			new FourthTimesGuidanceMeta(),// 第四次随访指导
			new FourthTimesReferralMeta(),// 第四次随访转诊
			new FourthTimesNextFollowUpDataMeta(),// 第四次随访下次随访日期
			new FourthTimesDoctorNameMeta(),// 第四次随访随访医生签名

			new FifthTimesFetalMeta(),//第五次随访__胎位
			new FifthTimesDataMeta(),// 第五次随访日期
			new FifthTimesPregnantCycleMeta(),// 第五次随访孕周
			new FifthTimesMainTellingMeta(),// 第五次随访主诉
			new FifthTimesWeightMeta(),// 第五次随访体重
			new FifthTimesPalaceBottomHeightMeta(),// 第五次随访宫底高度
			new FifthTimesGTTSMeta(),// 第五次随访腹围
			new FifthTimesFetalHeartRateMeta(),// 第五次随访胎心率
			new FifthTimesBloodPressureMeta(),// 第五次随访血压
			new FifthTimesHemoglobinValueMeta(),// 第五次随访血红蛋白值
			new FifthTimesUrinaryProteinMeta(),// 第五次随访尿蛋白
			new FifthTimesOtherCheckMeta(),// 第五次随访其他检查
			new FifthTimesClassificationMeta(),// 第五次随访分类
			new FifthTimesGuidanceMeta(),// 第五次随访指导
			new FifthTimesReferralMeta(),// 第五次随访转诊
			new PostpartumFollowUpDataMeta(),// 第五次随访下次随访日期
			new FifthTimesDoctorNameMeta() // 第五次随访随访医生签名

	};

	private String Rpath="C/E/B";
    private String[] Keys={"prenatalfollowup2","prenatalfollowup3","prenatalfollowup4","prenatalfollowup5"};
    private String[] Values={"true","true","true","true"};


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