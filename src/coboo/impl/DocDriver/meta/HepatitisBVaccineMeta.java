 package coboo.impl.DocDriver.meta;

/**
 * 乙肝疫苗
 * HR42_02_065_01,cbjzbw_01,HR53_03_001_02_01,cbyxrq_01,HR53_99_001_01,HR22_01_020_01,cbbz_01,
 * HR42_02_065_02,cbjzbw_02,HR53_03_001_02_02,cbyxrq_02,HR53_99_001_02,HR22_01_020_02,cbbz_02,
 * HR42_02_065_03,cbjzbw_03,HR53_03_001_02_03,cbyxrq_03,HR53_99_001_03,HR22_01_020_03,cbbz_03
 */
public class HepatitisBVaccineMeta extends Meta {
	public String metaname = "乙肝疫苗";
	String[] SIds = new String[] {"jzrq1:HR42_02_065_01", "jzbw1:cbjzbw_01",
			"ymph1:HR53_03_001_02_01", "yxrq1:cbyxrq_01", "scqy1:HR53_99_001_01",
			"jzys1:HR22_01_020_01", "bz1:cbbz_01", "jzrq2:HR42_02_065_02", "jzbw2:cbjzbw_02",
			"ymph2:HR53_03_001_02_02", "yxrq2:cbyxrq_02", "scqy2:HR53_99_001_02",
			"jzys2:HR22_01_020_02", "bz2:cbbz_02", "jzrq3:HR42_02_065_03", "jzbw3:cbjzbw_03",
			"ymph3:HR53_03_001_02_03", "yxrq3:cbyxrq_03", "scqy3:HR53_99_001_03",
			"jzys3:HR22_01_020_03", "bz3:cbbz_03"  };
	String[] SValues = new String[] { "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "" };
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

	public HepatitisBVaccineMeta() {
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