 package coboo.impl.DocDriver.meta;

/**
 * 二类疫苗 "HR42_02_065_033", "cbjzbw_033","HR53_03_001_02_033", "cbyxrq_033",
 * "HR53_99_001_033","HR22_01_020_033", "cbbz_033", "HR42_02_065_034",
 * "cbjzbw_034","HR53_03_001_02_034", "cbyxrq_034",
 * "HR53_99_001_034","HR22_01_020_034", "cbbz_034", "HR42_02_065_035",
 * "cbjzbw_035","HR53_03_001_02_035", "cbyxrq_035",
 * "HR53_99_001_035","HR22_01_020_035", "cbbz_035"
 */
public class TypeIIVaccineMeta extends Meta {
	public String metaname = "二类疫苗";
	String[] SIds = new String[] { "elym7:cbelym_01", "elym10:cbelym_04",
			"elym13:HR42_02_065_033", "elym16:cbjzbw_033", "elym19:HR53_03_001_02_033",
			"elym22:cbyxrq_033", "elym25:HR53_99_001_033", "elym8:HR22_01_020_033", "elym11:cbbz_033",
			"elym14:cbelym_02", "elym17:cbelym_05", "elym20:HR42_02_065_034",
			"elym23:cbjzbw_034", "elym26:HR53_03_001_02_034", "elym3:cbyxrq_034", "elym6:cbelym_03", "elym9:HR42_02_065_035", "elym12:cbjzbw_035",
			"elym15:HR53_03_001_02_035", "elym18:cbyxrq_035", "elym21:HR53_99_001_035",
			"elym24:HR22_01_020_035", "elym27:cbbz_035" };
	String[] SValues = new String[] { "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", 
			"","","" };
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

	public TypeIIVaccineMeta() {
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
