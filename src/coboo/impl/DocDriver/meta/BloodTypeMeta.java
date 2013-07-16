package coboo.impl.DocDriver.meta;

/**
 * 血型 对应字段 HR51_03_003,HR51_03_004
 * 
 * @author 任笑言
 */
public class BloodTypeMeta extends Meta {

	public String metaname = "血型";
	String[] SIds = new String[] { "xx:HR51_03_003", "rhyx:rhyxRH:HR51_03_004" };
	String[] SValues = new String[] { "", "" };
	String HValue;

	// ===================================================================

	// ===========================================================

	void con_hvalue2svalue(String humanReadValue) {
		if(SValues.length==1){
			SValues[0]=HValue;
		}
		String part1 = humanReadValue.substring(0,
				humanReadValue.indexOf("/") + 1);
		String part2 = humanReadValue
				.substring(humanReadValue.indexOf("/") + 1);
		if (part1.substring(0, 2).equals("A型"))
			SValues[0] = "1";
		if (part1.substring(0, 1).equalsIgnoreCase("B"))
			SValues[0] = "2";
		if (part1.substring(0, 1).equalsIgnoreCase("O"))
			SValues[0] = "3";
		if (part1.substring(0, 2).equalsIgnoreCase("AB"))
			SValues[0] = "4";
		if (part1.substring(0, 2).equals("不详"))
			SValues[0] = "5";
		if (part2.substring(humanReadValue.indexOf(":"),
				humanReadValue.indexOf(":") + 1).equals("否"))
			SValues[1] = "1";
		if (part2.substring(humanReadValue.indexOf(':'),
				humanReadValue.indexOf(":") + 1).equals("是"))
			SValues[1] = "2";
		if (part2.substring(humanReadValue.indexOf(':'),
				humanReadValue.indexOf(":") + 1).equals("不"))
			SValues[1] = "3";
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		if(storeValueList.length==1){
			HValue=storeValueList[0];
		}else{
		if (SValues[0].equals("1"))
			HValue = "A型";
		if (SValues[0].equals("2"))
			HValue = "B型";
		if (SValues[0].equals("3"))
			HValue = "O型";
		if (SValues[0].equals("4"))
			HValue = "AB型";
		if (SValues[0].equals("5"))
			HValue = "不详";
		HValue = HValue + '/';
		if (SValues[1].equals("1"))
			HValue = HValue + "RH阴性:否";
		if (SValues[1].equals("2"))
			HValue = HValue + "RH阴性:是";
		if (SValues[1].equals("3"))
			HValue = HValue + "RH阴性:不详";
		}
		top();
		return;
	}

	public BloodTypeMeta() {
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
