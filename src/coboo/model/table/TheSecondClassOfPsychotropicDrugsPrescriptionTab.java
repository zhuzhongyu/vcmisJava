 package coboo.model.table;

import coboo.impl.DocDriver.meta.*;

/**
 * 第二类精神药品处方笺--门(急)诊病历 H/D/2009122912005.xml
 * 
 * @author WangZhendong
 * 
 */
public class TheSecondClassOfPsychotropicDrugsPrescriptionTab extends Table {
	Meta[] metas = {
			new FeesCategoryMeta(), // 费别
			new PrescriptionIDMeta(), // 处方/ID号
			new NameMeta(), // 姓名
			new SexMeta(), // 性别
			new AgeMeta(),// 年龄
			new DepartmentsMeta(), // 科别
			new SickroomMeta(), // 病房
			new BedIDMeta(), // 床号
			new DiagnosisMeta(),// 诊断
			new HospitalizationIDMeta(),// 门诊号/住院号
			new ContentRMeta(),// 内容R
			new DoctorMeta(), // 医师
			new PrescriptionDateMeta(), // 处方时间
			new AuditDeployCheckDispensingMeta(), // 审核
			new MedicineExpensesMeta() // 药费
	};
	private String Rpath="H/D";
    private String[] Keys={"TheSecondClassOfPsychotropicDrugsPrescriptionTab"};
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