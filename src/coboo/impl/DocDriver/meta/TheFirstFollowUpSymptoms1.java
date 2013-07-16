package coboo.impl.DocDriver.meta;

/**
 * 第一次随访--症状 cbtjbzz01, cbtjbzz02, cbtjbzz03, cbtjbzz04, cbtjbzz05, cbtjbzz06,
 * cbtjbzz07, cbtjbzz08
 * 
 * @author rp/rxy
 */
public class TheFirstFollowUpSymptoms1 extends Meta {
	String metaname = " 第一次随访--症状";
	String[] SIds = new String[] { "zz1:cbtjbzz01", "zz2:cbtjbzz02", "zz3:cbtjbzz03",
			"zz4:cbtjbzz04", "zz5:cbtjbzz05", "zz6:cbtjbzz06", "zz7:cbtjbzz07", "zz8:cbtjbzz08" };
	String[] SValues = new String[] { "", "", "", "", "", "", "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {
		String readValueList[] = new String[8];
		readValueList = humanReadValue.split("/");
		for (int i = 0; i < readValueList.length; i++) {

			if (readValueList[i].equals("无症状")) {
				SValues[i] = "1";
			} else if (readValueList[i].equals("多饮")) {
				SValues[i] = "2";
			} else if (readValueList[i].equals("多食")) {
				SValues[i] = "3";
			} else if (readValueList[i].equals("多尿")) {
				SValues[i] = "4";
			} else if (readValueList[i].equals("视力模糊")) {
				SValues[i] = "5";
			} else if (readValueList[i].equals("感染")) {
				SValues[i] = "6";
			} else if (readValueList[i].equals("手脚麻木")) {
				SValues[i] = "7";
			} else if (readValueList[i].equals("下肢浮肿")) {
				SValues[i] = "8";
			}

		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		for (int i = 0; i < storeValueList.length; i++) {
			HValue = "";
			if(storeValueList[i].equals("1")){
				HValue += "无症状/";
			}else if(storeValueList[i].equals("2")){
				HValue += "多饮/";
			}else if(storeValueList[i].equals("3")){
				HValue += "多食/";
			}else if(storeValueList[i].equals("4")){
				HValue += "多尿/";
			}else if(storeValueList[i].equals("5")){
				HValue += "视力模糊/";
			}else if(storeValueList[i].equals("6")){
				HValue += "感染/";
			}else if(storeValueList[i].equals("7")){
				HValue += "手脚麻木";
			}else if(storeValueList[i].equals("8")){
				HValue += "下肢浮肿/";
			}
			
		}
		top();
		return;
	}

	public TheFirstFollowUpSymptoms1() {
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