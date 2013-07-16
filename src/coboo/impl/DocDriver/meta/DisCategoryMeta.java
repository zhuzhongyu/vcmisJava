package coboo.impl.DocDriver.meta;

/**
 * 肢体残疾类别 对应字段 cbxldjlb_pt, cbxldjlb_jt, cbxldjlb_nt, cbxldjlb_jz,
 * cbxldjlb_rmhyz, cbxldjlb_ghjjb, cbxldjlb_js, cbxldjlb_tlyy, cbxldjlb_zl,
 * cbxldjlb_sl, cbxldjlb_qtcj, cbxldjlb_qt
 * 
 * @author 任笑言
 */
public class DisCategoryMeta extends Meta {
	public String metaname = "肢体残疾类别";
	String[] SIds = new String[] {"cbxldjlb_pt:pt", "cbxldjlb_jt:jt", "cbxldjlb_nt:nt",
			"cbxldjlb_jz:jz", "cbxldjlb_rmhyz:emhyz", "cbxldjlb_ghjjb:ggjjb", "cbxldjlb_qt:qt",
			"cbxldjlb_qtcj:hfbycj", "cbxldjlb_sl:sl", "cbxldjlb_zl:zl", "cbxldjlb_tlyy:tlyy",
			"cbxldjlb_js:js"};
	String[] SValues = new String[] { "", "", "", "", "", "", "", "", "", "",
			"", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {
		String readValueList[] = new String[12];
		readValueList = humanReadValue.split("/");
		SValues[0] = readValueList[0];
		SValues[1] = readValueList[1];
		SValues[2] = readValueList[2];
		SValues[3] = readValueList[3];
		SValues[4] = readValueList[4];
		SValues[5] = readValueList[5];
		SValues[6] = readValueList[6];
		SValues[7] = readValueList[7];
		SValues[8] = readValueList[8];
		SValues[9] = readValueList[9];
		SValues[10] = readValueList[10];
		SValues[11] = readValueList[11];
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		HValue = "";
		if (storeValueList[0].equals("true")) {
			HValue += "偏瘫/";
		}
		if (storeValueList[1].equals("true")) {
			HValue += "截瘫/";
		}
		if (storeValueList[2].equals("true")) {
			HValue += "脑瘫/";
		}
		if (storeValueList[3].equals("true")) {
			HValue += "截肢/";
		}
		if (storeValueList[4].equals("true")) {
			HValue += "儿麻后遗症/";
		}
		if (storeValueList[5].equals("true")) {
			HValue += "骨关节疾病/";
		}
		if (storeValueList[6].equals("true")) {
			HValue += "精神/";
		}
		if (storeValueList[7].equals("true")) {
			HValue += "听力语言/";
		}
		if (storeValueList[8].equals("true")) {
			HValue += "智力/";
		}
		if (storeValueList[9].equals("true")) {
			HValue += "视力/";
		}
		if (storeValueList[10].equals("true")) {
			HValue += "是否伴有其他残疾/";
		}
		if (storeValueList[11].equals("true")) {
			HValue += "其他/";
		}
		top();
		return;
	}

	public DisCategoryMeta() {
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
