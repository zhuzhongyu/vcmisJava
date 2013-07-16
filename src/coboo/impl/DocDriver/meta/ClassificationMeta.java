package coboo.impl.DocDriver.meta;

/**
 * 分类 cbccsffl
 * 
 * @author rxy
 */
public class ClassificationMeta extends Meta {
	String metaname = "分类";
	String[] SIds = new String[] { "ccsf01:fl:cbywblfy_02", "ccsf02:fl1"};
	String[] SValues = new String[] { "", ""};
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {

		if (humanReadValue.equals("稳定")) {
			SValues[0] = "1";
		} else if (humanReadValue.equals("基本稳定")) {
			SValues[0] = "2";
		} else if (humanReadValue.equals("不稳定")) {
			SValues[0] = "3";
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		if (storeValueList[0].equals("1")) {
			HValue = "稳定";
		} else if (storeValueList[0].equals("2")) {
			HValue = "基本稳定";
		} else if (storeValueList[0].equals("3")) {
			HValue = "不稳定";
		}
		top();
		return;
	}

	public ClassificationMeta() {
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