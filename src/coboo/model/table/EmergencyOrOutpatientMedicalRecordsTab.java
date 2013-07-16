 package coboo.model.table;

import coboo.impl.DocDriver.meta.*;

/**
 * 急诊病历
 * 
 * @author WangZhendong
 * 
 */
public class EmergencyOrOutpatientMedicalRecordsTab extends Table {
	Meta[] metas = { 
			new DepartmentsMeta(), // 科别
			new EmergencyMedicalDateMeta(), // 门（急）诊时间
			new EmergencyMedicalContentMeta() // 内容
	};
	private String Rpath="H/B";
    private String[] Keys={"EmergencyOrOutpatientMedicalRecordsTab"};
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