package coboo.model.table;

import coboo.impl.DocDriver.meta.*;

/**
 * 接诊记录表2
 * 
 * @author WangZhendong
 * 
 */

public class AcceptionRec2Tab extends Table {
	Meta[] metas = {

	new NameMeta(), // 姓名
			new DocCodeMeta(),// 编号
			new AttendersSubjectiveDataMeta(),// 就诊者的主观资料
			new AttendersObjectiveDataMeta(),// 就诊者的客观资料
			new AssessmentMeta(),// 评估
			new DisposalPlanMeta(),// 处置计划
			new HCDoctorNameMeta(), // 医生签字
			new AcceptsDateMeta(), // 接诊日期
	};
	private String Rpath="H/C";
    private String[] Keys={"AcceptionRec2Tab"};
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