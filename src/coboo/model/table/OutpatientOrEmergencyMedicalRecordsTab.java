 package coboo.model.table;

import coboo.impl.DocDriver.meta.*;

/**
 * 门诊病历 H.A
 * 
 */
public class OutpatientOrEmergencyMedicalRecordsTab extends Table {

	Meta[] metas = { 
			new NameMeta(), // 姓名
			new SexMeta(), // 性别
			new BirthDateMeta(), // 出生年月日
			new PubEthnicMeta(), // 民族
			new MarriageStatueMeta(), // 婚否
			new WorkUnitOrAddressMeta(), // 工作单位（住址）
			new ProfessionalMeta(), // 职业
			new HistoryOfDrugAllergyMeta(), // 药物过敏史
			new DepartmentsMeta(), // 科别
			new OutpatientOrEmergencyMedicalDateMeta(), // 门（急）诊时间
			new MainComplaintsMeta(), // 主诉
			new PresentillnessMeta(), // 现病史
			new PastHistoryMeta(), // 既往史
			new PhysicalExaminationMeta(), // 体检
			new SecondaryExaminationResultsMeta(), // 辅助检查结果
			new InitialDiagnosisMeta(), // 初步诊断
			new MedicalAdviceMeta(), // 治疗意见
			new DoctorNameMeta() // 医生签名

	};
	private String Rpath="H/A";
    private String[] Keys={"OutpatientOrEmergencyMedicalRecordsTab"};
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