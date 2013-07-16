 package coboo.impl.DocDriver.meta;

/**
 * 现存主要健康问题--血管疾病 
 * "cbxgjb", "cbxgjb1", "cbxgjb2", "cbxgjb3"
 */
public class VascularDiseaseMeta extends Meta {
	public String metaname = "现存主要健康问题--血管疾病";
	String[] SIds = new String[] { "xgjb:cbxgjb", "xgjb1:cbxgjb1", "xgjb2:cbxgjb2", "xgjb3:cbxgjb3" };
	String[] SValues = new String[] { "", "", "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {

		boolean healthFlag = false; // 判断是否健康
		int num = -1; // 保存健康标志在第几个空
		boolean ortherFlag = false; // 判断是否有其他

		String[] readValueList = new String[4];
		readValueList = humanReadValue.split("/");

		for (int i = 0; i < readValueList.length; i++) {

			if (readValueList[i].equals("1")) {
				healthFlag = true;
				num = i;
			}
			if (readValueList[i].equals("4")) {
				ortherFlag = true;
			}
		}

		if (healthFlag) {

			for (int i = 0; i < readValueList.length; i++) {
				if (i == num) {
					SValues[i] = readValueList[i];
				} else {
					SValues[i] = "";
				}
			}
		} else {

			for (int i = 0; i < readValueList.length; i++) {
				SValues[i] = readValueList[i];
			}

			if (!ortherFlag) {
				SValues[0] = "";
			}
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {

		HValue = "";
		for (int i = 0; i < storeValueList.length; i++) {

			if (i < (storeValueList.length - 1)) {
				HValue += storeValueList[i] + "/";
			} else {
				HValue += storeValueList[i];
			}
		}
		top();
		return;
	}

	public VascularDiseaseMeta() {
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