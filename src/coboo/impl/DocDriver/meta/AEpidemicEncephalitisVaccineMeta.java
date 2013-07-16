package coboo.impl.DocDriver.meta;

/**
 * A群流脑疫苗
 * HR42_02_065_020,cbjzbw_020,HR53_03_001_02_020,cbyxrq_020,HR53_99_001_020,HR22_01_020_020,cbbz_020,
 * R42_02_065_021,cbjzbw_021,HR53_03_001_02_021,cbyxrq_021,HR53_99_001_021,HR22_01_020_021,cbbz_021
 */
public class AEpidemicEncephalitisVaccineMeta extends Meta {
	public String metaname = "A群流脑疫苗 ";
	String[] SIds = new String[] {"jzrq20:HR42_02_065_020", "jzbw20:cbjzbw_020",
			"ymph20:HR53_03_001_02_020", "yxrq20:cbyxrq_020", "scqy20:HR53_99_001_020",
			"jzys20:HR22_01_020_020", "bz20:cbbz_020", "jzrq21:HR42_02_065_021", "jzbw21:cbjzbw_021",
			"ymph21:HR53_03_001_02_021", "yxrq21:cbyxrq_021", "scqy21:HR53_99_001_021",
			"jzys21:HR22_01_020_021", "bz21:cbbz_021"};
	String[] SValues = new String[] { "", "", "", "", "", "", "", "", "", "",
			"", "", "", "" };
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

	public AEpidemicEncephalitisVaccineMeta() {
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