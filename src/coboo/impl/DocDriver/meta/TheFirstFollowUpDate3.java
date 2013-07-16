 package coboo.impl.DocDriver.meta;

/**
 * 第一次随访--方式 
 * HR52_01_036_1
 * @author rp
 */
public class TheFirstFollowUpDate3 extends Meta {
	public String metaname = "第三次随访--方式";
	String[] SIds = new String[] { "sfrq3:HR42_02_057_3" };
	String[] SValues = new String[] { "" };
	String HValue;

	
	void con_hvalue2svalue(String humanReadValue) {
		SValues[0] = publicFunction(humanReadValue, "1", "2", "3", "门诊", "家庭",
				"电话");
		top();
		return;
	}
	
	void con_svalue2hvalue(String[] storeValueList) {
		HValue = publicFunction(storeValueList[0], "门诊", "家庭", "电话", "1", "2",
				"3");
		top();
		return;
	}
	
	/**
	 * 公共函数(三个选择时)
	 * @param humanReadValue
	 * @param r1
	 * @param r2
	 * @return String temp
	 */
	public String publicFunction(String humanReadValue, 
			String r1, String r2, String r3,
			String c1, String c2, String c3){
		String temp = "";
		if(humanReadValue.equals(c1))
			temp = r1;
		if(humanReadValue.equals(c2))
			temp = r2;
		if(humanReadValue.equals(c3))
			temp = r3;
		return temp;
	}

	public TheFirstFollowUpDate3() {
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