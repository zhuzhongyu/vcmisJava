package coboo.impl.DocDriver.meta;
/**
 * 第一次产前随访记录表--既往史
 * @author rxy
 *
 */
public class WCEADiseaseHistoryMeta extends Meta {
	public String metaname = "第一次产前随访记录表--既往史";
	String[] SIds = new String[] {"jws:HR51_01_006_01", "jws1:HR51_01_006_02", "jws2:HR51_01_006_03",
			"jws3:HR51_01_006_04", "jws4:HR51_01_006_05", "jws5:HR51_01_006_06",
			"jws6:HR51_01_006_07", "jws7:HR51_01_006_08" };
	String[] SValues = new String[] { "", "", "", "", "", "", "", "" };
	String HValue;

	@Override
	void con_hvalue2svalue(String humanReadValue) {
		String readValueList[] = new String[8];
		readValueList = humanReadValue.split("/");
		if (readValueList[1].equals("无")) {
			SValues[0] = "";
			SValues[1] = "1";
			SValues[2] = "";
			SValues[3] = "";
			SValues[4] = "";
			SValues[5] = "";
			SValues[6] = "";
			SValues[7] = "";

		} else {
			SValues[0] = readValueList[0];

			if (readValueList[1].equals("心脏病")) {
				SValues[1] = "2";
			} else if (readValueList[1].equals("肾脏疾病")) {
				SValues[1] = "3";
			} else if (readValueList[1].equals("肝脏疾病")) {
				SValues[1] = "4";
			} else if (readValueList[1].equals("高血压")) {
				SValues[1] = "5";
			} else if (readValueList[1].equals("贫血")) {
				SValues[1] = "6";
			} else if (readValueList[1].equals("糖尿病")) {
				SValues[1] = "7";
			} else if (readValueList[1].equals("其他")) {
				SValues[1] = "8";
			}

			if (readValueList[2].equals("心脏病")) {
				SValues[2] = "2";
			} else if (readValueList[2].equals("肾脏疾病")) {
				SValues[2] = "3";
			} else if (readValueList[2].equals("肝脏疾病")) {
				SValues[2] = "4";
			} else if (readValueList[2].equals("高血压")) {
				SValues[2] = "5";
			} else if (readValueList[2].equals("贫血")) {
				SValues[2] = "6";
			} else if (readValueList[2].equals("糖尿病")) {
				SValues[2] = "7";
			} else if (readValueList[2].equals("其他")) {
				SValues[2] = "8";
			}

			if (readValueList[3].equals("心脏病")) {
				SValues[3] = "2";
			} else if (readValueList[3].equals("肾脏疾病")) {
				SValues[3] = "3";
			} else if (readValueList[3].equals("肝脏疾病")) {
				SValues[3] = "4";
			} else if (readValueList[3].equals("高血压")) {
				SValues[3] = "5";
			} else if (readValueList[3].equals("贫血")) {
				SValues[3] = "6";
			} else if (readValueList[3].equals("糖尿病")) {
				SValues[3] = "7";
			} else if (readValueList[3].equals("其他")) {
				SValues[3] = "8";
			}

			if (readValueList[4].equals("心脏病")) {
				SValues[4] = "2";
			} else if (readValueList[4].equals("肾脏疾病")) {
				SValues[4] = "3";
			} else if (readValueList[4].equals("肝脏疾病")) {
				SValues[4] = "4";
			} else if (readValueList[4].equals("高血压")) {
				SValues[4] = "5";
			} else if (readValueList[4].equals("贫血")) {
				SValues[4] = "6";
			} else if (readValueList[4].equals("糖尿病")) {
				SValues[4] = "7";
			} else if (readValueList[4].equals("其他")) {
				SValues[4] = "8";
			}

			if (readValueList[5].equals("心脏病")) {
				SValues[5] = "2";
			} else if (readValueList[5].equals("肾脏疾病")) {
				SValues[5] = "3";
			} else if (readValueList[5].equals("肝脏疾病")) {
				SValues[5] = "4";
			} else if (readValueList[5].equals("高血压")) {
				SValues[5] = "5";
			} else if (readValueList[5].equals("贫血")) {
				SValues[5] = "6";
			} else if (readValueList[5].equals("糖尿病")) {
				SValues[5] = "7";
			} else if (readValueList[5].equals("其他")) {
				SValues[5] = "8";
			}

			if (readValueList[6].equals("心脏病")) {
				SValues[6] = "2";
			} else if (readValueList[6].equals("肾脏疾病")) {
				SValues[6] = "3";
			} else if (readValueList[6].equals("肝脏疾病")) {
				SValues[6] = "4";
			} else if (readValueList[6].equals("高血压")) {
				SValues[6] = "5";
			} else if (readValueList[6].equals("贫血")) {
				SValues[6] = "6";
			} else if (readValueList[6].equals("糖尿病")) {
				SValues[6] = "7";
			} else if (readValueList[6].equals("其他")) {
				SValues[6] = "8";
			}

			if (readValueList[7].equals("心脏病")) {
				SValues[7] = "2";
			} else if (readValueList[7].equals("肾脏疾病")) {
				SValues[7] = "3";
			} else if (readValueList[7].equals("肝脏疾病")) {
				SValues[7] = "4";
			} else if (readValueList[7].equals("高血压")) {
				SValues[7] = "5";
			} else if (readValueList[7].equals("贫血")) {
				SValues[7] = "6";
			} else if (readValueList[7].equals("糖尿病")) {
				SValues[7] = "7";
			} else if (readValueList[7].equals("其他")) {
				SValues[7] = "8";
			}

			if (readValueList[8].equals("心脏病")) {
				SValues[8] = "2";
			} else if (readValueList[8].equals("肾脏疾病")) {
				SValues[8] = "3";
			} else if (readValueList[8].equals("肝脏疾病")) {
				SValues[8] = "4";
			} else if (readValueList[8].equals("高血压")) {
				SValues[8] = "5";
			} else if (readValueList[8].equals("贫血")) {
				SValues[8] = "6";
			} else if (readValueList[8].equals("糖尿病")) {
				SValues[8] = "7";
			} else if (readValueList[8].equals("其他")) {
				SValues[8] = "8";
			}
		}
		top();
		return;

	}

	@Override
	void con_svalue2hvalue(String[] storeValueList) {
		if (storeValueList[1].equals("1")) {
			HValue = "无";
		} else {
			
			HValue = storeValueList[0]+"/";
			
			if(storeValueList[1].equals("2")){
				HValue += "心脏病/";
			}else if(storeValueList[1].equals("3")){
				HValue += "肾脏疾病/";
			}else if(storeValueList[1].equals("4")){
				HValue += "肝脏疾病/";
			}else if(storeValueList[1].equals("5")){
				HValue += "高血压/";
			}else if(storeValueList[1].equals("6")){
				HValue += "贫血/";
			}else if(storeValueList[1].equals("7")){
				HValue += "糖尿病/";
			}else if(storeValueList[1].equals("8")){
				HValue += "其他/";
			}
			
			if(storeValueList[2].equals("2")){
				HValue += "心脏病/";
			}else if(storeValueList[2].equals("3")){
				HValue += "肾脏疾病/";
			}else if(storeValueList[2].equals("4")){
				HValue += "肝脏疾病/";
			}else if(storeValueList[2].equals("5")){
				HValue += "高血压/";
			}else if(storeValueList[2].equals("6")){
				HValue += "贫血/";
			}else if(storeValueList[2].equals("7")){
				HValue += "糖尿病/";
			}else if(storeValueList[2].equals("8")){
				HValue += "其他/";
			}
			
			if(storeValueList[3].equals("2")){
				HValue += "心脏病/";
			}else if(storeValueList[3].equals("3")){
				HValue += "肾脏疾病/";
			}else if(storeValueList[3].equals("4")){
				HValue += "肝脏疾病/";
			}else if(storeValueList[3].equals("5")){
				HValue += "高血压/";
			}else if(storeValueList[3].equals("6")){
				HValue += "贫血/";
			}else if(storeValueList[3].equals("7")){
				HValue += "糖尿病/";
			}else if(storeValueList[3].equals("8")){
				HValue += "其他/";
			}
			
			if(storeValueList[4].equals("2")){
				HValue += "心脏病/";
			}else if(storeValueList[4].equals("3")){
				HValue += "肾脏疾病/";
			}else if(storeValueList[4].equals("4")){
				HValue += "肝脏疾病/";
			}else if(storeValueList[4].equals("5")){
				HValue += "高血压/";
			}else if(storeValueList[4].equals("6")){
				HValue += "贫血/";
			}else if(storeValueList[4].equals("7")){
				HValue += "糖尿病/";
			}else if(storeValueList[4].equals("8")){
				HValue += "其他/";
			}
			
			if(storeValueList[5].equals("2")){
				HValue += "心脏病/";
			}else if(storeValueList[5].equals("3")){
				HValue += "肾脏疾病/";
			}else if(storeValueList[5].equals("4")){
				HValue += "肝脏疾病/";
			}else if(storeValueList[5].equals("5")){
				HValue += "高血压/";
			}else if(storeValueList[5].equals("6")){
				HValue += "贫血/";
			}else if(storeValueList[5].equals("7")){
				HValue += "糖尿病/";
			}else if(storeValueList[5].equals("8")){
				HValue += "其他/";
			}
			
			if(storeValueList[6].equals("2")){
				HValue += "心脏病/";
			}else if(storeValueList[6].equals("3")){
				HValue += "肾脏疾病/";
			}else if(storeValueList[6].equals("4")){
				HValue += "肝脏疾病/";
			}else if(storeValueList[6].equals("5")){
				HValue += "高血压/";
			}else if(storeValueList[6].equals("6")){
				HValue += "贫血/";
			}else if(storeValueList[6].equals("7")){
				HValue += "糖尿病/";
			}else if(storeValueList[6].equals("8")){
				HValue += "其他/";
			}
			
			if(storeValueList[7].equals("2")){
				HValue += "心脏病";
			}else if(storeValueList[7].equals("3")){
				HValue += "肾脏疾病";
			}else if(storeValueList[7].equals("4")){
				HValue += "肝脏疾病";
			}else if(storeValueList[7].equals("5")){
				HValue += "高血压";
			}else if(storeValueList[7].equals("6")){
				HValue += "贫血";
			}else if(storeValueList[7].equals("7")){
				HValue += "糖尿病";
			}else if(storeValueList[7].equals("8")){
				HValue += "其他";
			}
		}
		top();
		return;

	}

	public WCEADiseaseHistoryMeta() {
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
