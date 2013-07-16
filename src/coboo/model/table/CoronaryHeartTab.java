package coboo.model.table;
/**
 * 冠心病
 */
import coboo.impl.DocDriver.meta.*;

public class CoronaryHeartTab extends Table {
	Meta[] metas = { new PubEthnicMeta(), // 民族
			new PersonIdMeta(),// 身份证号
			new AddressMeta(),// 家庭住址
			new CulturalDegreeMeta(),// 文化程度
			new MaritalStatusMeta(),// 婚姻状况
			new ProfessionalMeta(),// 职业
			new CorMedicalHistoryMeta(),// 既往情况
			new CorClinical(),// 并发临床情况
			new CorAnginaFrequencyMeta(),// 心绞痛
			new CorExerciseIntensityMeta(),// 运动强度
			new HightMeta(),// 身高
			new WeightMeta(),// 体重
			new CorBMIMeta(),// BMI
			new WaistlineMeta(),// 腰围
			new HipMeta(),// 臀围
			new W_HMeta(),// 腰/臀
			new CorBloodPressureMeta(),// 冠心病--血压
			new BloodGlucoseTestMeta(),// 血糖测试
			new CorBloodLipidsMeta(),// 血脂
			new CorRenalMeta(),// 肾功能
			new CorECGMeta(),// ECG
			new CorFundusOculiMeta(),// 眼底
			new CorOtherMeta() // 其他
	};
	private String Rpath="E/C";
	private String[] Keys={"gxb"};
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
