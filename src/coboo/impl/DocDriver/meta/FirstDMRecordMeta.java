package coboo.impl.DocDriver.meta;

public class FirstDMRecordMeta extends Meta {
	public String metaname = "第1次糖尿病随访";
	String[] SIds = new String[] { "HR42_02_057_1", "HR52_01_036_1",
			"cbtjbzz01", "cbtjbzz02", "cbtjbzz03", "cbtjbzz04", "cbtjbzz05",
			"cbtjbzz06", "cbtjbzz07", "cbtjbzz08", "cbtjbzz09", "cbxy01",
			"HR51_02_173_11", "HR51_02_173_1", "HR51_02_173_110",
			"HR51_02_021_1", "HR51_02_199_1", "HR51_01_108_01",
			"HR51_01_108_02", "HR51_01_111_01", "HR51_01_111_02",
			"HR51_01_184_01", "HR51_01_182_01", "HR51_01_184_02",
			"HR51_01_182_02", "HR51_01_194_01", "HR51_01_194_02",
			"HR54_02_013_01_1", "HR55_01_035_1", "HR51_03_092_1",
			"HR51_03_094_1", "HR42_02_009_1", "cbqt5", "HR51_01_179_1", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" };
	String[] SValues = new String[] { "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {
		SValues[0] = humanReadValue;
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		HValue = storeValueList[0];
		top();
		return;
	}

	public FirstDMRecordMeta() {
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
