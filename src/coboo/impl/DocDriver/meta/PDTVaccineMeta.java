 package coboo.impl.DocDriver.meta;

/**
 * 百白破疫苗 
 * HR42_02_065_09, cbjzbw_09, HR53_03_001_02_09, cbyxrq_09,
 * HR53_99_001_09, HR22_01_020_09, cbbz_09, HR42_02_065_010,
 * cbjzbw_010, HR53_03_001_02_010, cbyxrq_010, HR53_99_001_010,
 * HR22_01_020_010, cbbz_010, HR42_02_065_011, cbjzbw_011,
 * HR53_03_001_02_011, cbyxrq_011, HR53_99_001_011, HR22_01_020_011,
 * cbbz_011, HR42_02_065_012, cbjzbw_012, HR53_03_001_02_012,
 * cbyxrq_012, HR53_99_001_012, HR22_01_020_012, cbbz_012
 */
public class PDTVaccineMeta extends Meta {
	public String metaname = "百白破疫苗";
	String[] SIds = new String[] { "jzrq9:HR42_02_065_09", "jzbw9:cbjzbw_09",
			"ymph9:HR53_03_001_02_09", "yxrq9:cbyxrq_09", "scqy9:HR53_99_001_09",
			"jzys9:HR22_01_020_09", "bz9:cbbz_09", 
			"jzrq10:HR42_02_065_010", "jzbw10:cbjzbw_010",
			"ymph10:HR53_03_001_02_010", "yxrq10:cbyxrq_010", "scqy10:HR53_99_001_010",
			"jzys10:HR22_01_020_010", "bz10:cbbz_010", 
			"jzrq11:HR42_02_065_011", "jzbw11:cbjzbw_011",
			"ymph11:HR53_03_001_02_011", "yxrq11:cbyxrq_011", "scqy11:HR53_99_001_011",
			"jzys11:HR22_01_020_011", "bz11:cbbz_011", 
			"jzrq12:HR42_02_065_012", "jzbw12:cbjzbw_012",
			"ymph12:HR53_03_001_02_012", "yxrq12:cbyxrq_012", "scqy12:HR53_99_001_012",
			"jzys12:HR22_01_020_012", "bz12:cbbz_012" };
	String[] SValues = new String[] { "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"" };
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

	public PDTVaccineMeta() {
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
