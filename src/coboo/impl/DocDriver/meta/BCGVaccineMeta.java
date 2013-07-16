package coboo.impl.DocDriver.meta;

/**
 * 卡介苗
 * HR42_02_065_04,cbjzbw_04,HR53_03_001_02_04,cbyxrq_04,HR53_99_001_04,HR22_01_020_04,cbbz_04
 */
public class BCGVaccineMeta extends Meta {
	public String metaname = "卡介苗";
	String[] SIds = new String[] { "jzrq4:HR42_02_065_04", "jzbw4:cbjzbw_04",
			"ymph4:HR53_03_001_02_04", "yxrq4:cbyxrq_04", "scqy4:HR53_99_001_04",
			"jzys4:HR22_01_020_04", "bz4:cbbz_04" };
	String[] SValues = new String[] { "", "", "", "", "", "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {

		String[] readValueList = humanReadValue.split("/");
		for(int i=0;i<readValueList.length;i++){
			SValues[i] = readValueList[i];
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		for(int i=0;i<storeValueList.length;i++){
			HValue+=storeValueList[i];
			if(i<storeValueList.length-1){
				HValue+="/";
			}
		}
		
		top();
		return;
	}
	public BCGVaccineMeta() {
		top();
	}

	void top() {
		super.SIds = SIds;
		super.SValues = SValues;
		super.HValue = HValue;
		super.metaname = metaname;
	}

	/**
	 * @return the sValues
	 */
	public String[] getSValues() {
		return SValues;
	}

	/**
	 * @param sValues
	 *            the sValues to set
	 */
	public void setSValues(String[] sValues) {
		SValues = sValues;
		con_svalue2hvalue(SValues);
	}

	/**
	 * @return the hValue
	 */
	public String getHValue() {
	
		return HValue;
	}

	/**
	 * @param hValue
	 *            the hValue to set
	 */
	public void setHValue(String hValue) {
		HValue = hValue;
		con_hvalue2svalue(HValue);
	}

	/**
	 * @return the sIds
	 */
	public String[] getSIds() {
		return SIds;
	}

	public String getMetaName() {
		return metaname;
	}

	/**
	 * @param sIds the sIds to set
	 */
	public void setSIds(String[] sIds) {
		SIds = sIds;
	}
}