 package coboo.impl.DocDriver.meta;

/**
 * 训练方法 
 * cbxlff_syqj, cbxlff_tsxl, cbxlff_ctff, cbxlff_ll, cbxlff_shsy,cbxlff_qt
 * @author 任笑言
 */
public class TrainMethodsMeta extends Meta {
	public String metaname = "训练方法";
	String[] SIds = new String[] { "cbxlff_syqj:syqjxx", "cbxlff_tsxl:tsxl", "cbxlff_ctff:ctff",
			"cbxlff_ll:ll", "cbxlff_shsy:shsyxl", "cbxlff_qt:qt"  };
	String[] SValues = new String[] { "", "", "", "", "", "" };
	String HValue;

	/*
	 * (non-Javadoc)
	 * 
	 * @see coboo.model.table.metaData#humanReadToStore(java.lang.String)
	 */
	void con_hvalue2svalue(String humanReadValue) {
		String readValueList[] = new String[6];
		readValueList = humanReadValue.split("/");
		SValues[0] = readValueList[0];
		SValues[1] = readValueList[1];
		SValues[2] = readValueList[2];
		SValues[3] = readValueList[3];
		SValues[4] = readValueList[4];
		SValues[5] = readValueList[5];
		top();
		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see coboo.model.table.metaData#storeToHumanRead(java.lang.String[])
	 */
	void con_svalue2hvalue(String[] storeValueList) {
		HValue = "";
		if (storeValueList[0].equals("true")) {
			HValue += "使用器具训练/";
		}
		if (storeValueList[1].equals("true")) {
			HValue += "徒手训练/";
		}
		if (storeValueList[2].equals("true")) {
			HValue += "传统方法/";
		}
		if (storeValueList[3].equals("true")) {
			HValue += "理疗/";
		}
		if (storeValueList[4].equals("true")) {
			HValue += "社会适应训练/";
		}
		if (storeValueList[5].equals("true")) {
			HValue += "其他/";
		}
		top();
		return;
	}

	public TrainMethodsMeta() {
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