package coboo.impl.DocDriver.meta;

/**
 * 审核 调配 核对 发药 sh,tp,hd,fy
 * 
 * @author WangZhendong
 * 
 */
// ============================== 审核 调配 核对 发药 =================================
public class AuditDeployCheckDispensingMeta extends Meta {
	public String metaname = " 审核 调配 核对 发药";
	String[] SIds = new String[] { "sh", "tp", "hd", "fy" };
	String[] SValues = new String[] { "", "", "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {
		String[] readValueList = humanReadValue.split("/");
		for (int i = 0; i < readValueList.length; i++) {
			String value = readValueList[i];
			if (value.equals("审核")) {
				SValues[0] = "true";
			} else if (value.equals("调配")) {
				SValues[1] = "true";
			} else if (value.equals("核对")) {
				SValues[2] = "true";
			} else if (value.equals("发药")) {
				SValues[3] = "true";
			}
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		HValue = "";
		if (storeValueList[0].equals("true")) {
			HValue += "审核/";
		}
		if (storeValueList[1].equals("true")) {
			HValue += "调配/";
		}
		if (storeValueList[2].equals("true")) {
			HValue += "核对/";
		}
		if (storeValueList[3].equals("true")) {
			HValue += "发药/";
		}
		top();
		return;
	}

	public AuditDeployCheckDispensingMeta() {
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