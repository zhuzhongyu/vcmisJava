 package coboo.impl.DocDriver.meta;

/**
 * 药物过敏史 对应字段
 * HR51_01_003_1,HR51_01_003_2,HR51_01_003_3,HR51_01_003_4,HR51_01_003_5
 * 
 * @author 任笑言
 */
public class DrugAllergyHistoryMeta extends Meta {

	public String metaname = "药物过敏史";
	String[] SIds = new String[] { "ylfy0:ywgm:HR51_01_003_1", "ywgms1:ywgm_1:HR51_01_003_2",
			"ywgms2:ywgm_2:HR51_01_003_3", "ywgms3:ywgm_3:HR51_01_003_4", "ywgms4:ywgm_4:HR51_01_003_5" };
	String[] SValues = new String[] { "", "", "", "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {

	}

	void con_svalue2hvalue(String[] storeValueList) {
	
	}

	public DrugAllergyHistoryMeta() {
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
