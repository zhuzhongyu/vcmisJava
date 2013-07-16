 package coboo.model.table;

import coboo.impl.DocDriver.meta.*;

/**
 * 会诊记录表 docPath = "H/F/"
 * 
 * @author WangZhendong
 * 
 */
public class ConsultationRecordTab extends Table {
	Meta[] metas = {
			new NameMeta(), // 姓名
			new DocCodeMeta(), // 编号
			new ConsultationReasonMeta(), // 会诊原因
			new ConsultationOpinionsMeta(), // 会诊意见
			new CMInstitutionsAndDrMeta(), // 会诊医生及其所在医疗机构
			new ResponsibilityDoctorMeta(), // 责任医生
			new ConsultationDateMeta() // 会诊日期
	};
	
	private String Rpath="H/F";
	 private String[] Keys={"ConsultationRecordTab"};
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