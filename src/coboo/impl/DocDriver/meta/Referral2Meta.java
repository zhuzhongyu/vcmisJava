package coboo.impl.DocDriver.meta;
/**
 * 精神病访视--转诊 HR52_02_027_01,HR52_02_027_02,HR52_02_027_03
 * @author Administrator
 *
 */
public class Referral2Meta extends Meta{
	String metaname = "精神病访视--转诊";
	String[] SIds = new String[] { "sfzz01", "sfzz02:HR52_02_027_01", "sfzz03" };
	String[] SValues = new String[] { "", "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {
		String[] readValueList = new String[3];
		readValueList = humanReadValue.split("/");
		if (readValueList[0].equals("否")) {
			SValues[0] = "1";
			SValues[1] = "";
			SValues[2] = "";
		} else if(readValueList[0].equals("是")){
			SValues[0] = "2";
			SValues[1] = readValueList[1];
			SValues[2] = readValueList[2];
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		if (storeValueList[0].equals("1")) {
			HValue = "否/";
		}else if(storeValueList[0].equals("2")){
			HValue = "是/" + storeValueList[1] + "/"
			+ storeValueList[2];
		}
		top();
		return;
	}

	public Referral2Meta() {
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
