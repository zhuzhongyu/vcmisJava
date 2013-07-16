 package coboo.impl.DocDriver.meta;

/**
 * 妊娠期患病情况
 * 
 * @author Administrator
 * HR51_01_020_1, HR51_01_020_2
 */
public class PrevalenceOfPregnancyMeta extends Meta {
	public String metaname = "妊娠期患病情况";
	String[] SIds = new String[] { "xm10", "xm11" };
	String[] SValues = new String[] { "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {
		String readValueList[] = new String[2];
		readValueList = humanReadValue.split("/");

		// 横线上填写的其他支付方式
		if (!readValueList[0].equals("")) {
			SValues[0] = readValueList[0];
		} else {
			SValues[0] = "";
		}

		// 第一个格
		if (readValueList[1].equals("糖尿病")) {
			SValues[1] = "1";
		} else if (readValueList[1].equals("妊娠期高血压")) {
			SValues[1] = "2";
		} else if (readValueList[1].equals("其他")) {
			SValues[1] = "3";
		} else {
			SValues[1] = "";
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		String str1 = "";

		// 第一个格
		if (storeValueList[1].equals("1")) {
			str1 = "糖尿病";
		} else if (storeValueList[1].equals("2")) {
			str1 = "妊娠期高血压";
		} else if (storeValueList[1].equals("3")) {
			str1 = "其他";
		} else {
			str1 = "";
		}

		HValue = storeValueList[0] + "/" + str1;
		top();
		return;
	}

	public PrevalenceOfPregnancyMeta() {
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
