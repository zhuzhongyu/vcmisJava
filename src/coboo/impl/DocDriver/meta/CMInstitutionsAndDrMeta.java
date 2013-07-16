package coboo.impl.DocDriver.meta;

/**
 * 会诊医生及其所在医疗机构
 * 
 * @author WangZhendong
 * 
 * 
 * -----------------------------------------------------------------------------------------------
 * |医疗机构名称 | 会诊医生签字：医生1 | 会诊医生签字：医生2 |会诊医生签字：医生3
 * -----------------------------------------------------------------------------------------------
 * 医疗机构1 |HR2_01_011_01 |cbhzjlb_ysqz1 |cbhzjlb_ysqz2 |cbhzjlb_ysqz3
 * -----------------------------------------------------------------------------------------------
 * 医疗机构2 |HR2_01_011_02 |cbhzjlb_ysqz4 |cbhzjlb_ysqz5 |cbhzjlb_ysqz6
 * -----------------------------------------------------------------------------------------------
 * 医疗机构3 |HR2_01_011_03 |cbhzjlb_ysqz7 |cbhzjlb_ysqz8 |cbhzjlb_ysqz9
 * -----------------------------------------------------------------------------------------------
 * 医疗机构4 |HR2_01_011_04 |cbhzjlb_ysqz10 |cbhzjlb_ysqz11 |cbhzjlb_ysqz12
 * -----------------------------------------------------------------------------------------------
 * 医疗机构5 |HR2_01_011_05 |cbhzjlb_ysqz13 |cbhzjlb_ysqz14 |cbhzjlb_ysqz15
 * -----------------------------------------------------------------------------------------------
 */
// ============================== 会诊医生及其所在医疗机构 =================================
public class CMInstitutionsAndDrMeta extends Meta {
	public String metaname = "会诊医生及其所在医疗机构";
	String[] SIds = new String[] { "HR2_01_011_01", "cbhzjlb_ysqz1",
			"cbhzjlb_ysqz2", "cbhzjlb_ysqz3", "HR2_01_011_02", "cbhzjlb_ysqz4",
			"cbhzjlb_ysqz5", "cbhzjlb_ysqz6", "HR2_01_011_03", "cbhzjlb_ysqz7",
			"cbhzjlb_ysqz8", "cbhzjlb_ysqz9", "HR2_01_011_04",
			"cbhzjlb_ysqz10", "cbhzjlb_ysqz11", "cbhzjlb_ysqz12",
			"HR2_01_011_05", "cbhzjlb_ysqz13", "cbhzjlb_ysqz14",
			"cbhzjlb_ysqz15" };
	String[] SValues = new String[] { "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "" };
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
	public CMInstitutionsAndDrMeta() {
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