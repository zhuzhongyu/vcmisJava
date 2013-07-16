 package coboo.impl.DocDriver.meta;

public class GuidanceXSEMeta extends Meta {
	public String metaname = "新生儿家庭方式记录表随访——————指导";
	String[] SIds = new String[] { "zd01:HR51_01_004_1", "zd02:HR51_01_004_2",
			"zd03:HR51_01_004_3", "zd04:HR51_01_004_4","s4" };
	String[] SValues = new String[] { "", "", "", "" ,""};
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {
		if (SValues[0].equals("喂养指导")) {
			SValues[0] = "1";
		} else if (SValues[0].equals("母乳喂养")) {
			SValues[0] = "2";
		} else if (SValues[0].equals("护理指导")) {
			SValues[0] = "3";
		} else if (SValues[0].equals("疾病预防指导")) {
			SValues[0] = "4";
		}

		if (SValues[1].equals("喂养指导")) {
			SValues[1] = "1";
		} else if (SValues[1].equals("母乳喂养")) {
			SValues[1] = "2";
		} else if (SValues[1].equals("护理指导")) {
			SValues[1] = "3";
		} else if (SValues[1].equals("疾病预防指导")) {
			SValues[1] = "4";
		}

		if (SValues[2].equals("喂养指导")) {
			SValues[2] = "1";
		} else if (SValues[2].equals("母乳喂养")) {
			SValues[2] = "2";
		} else if (SValues[2].equals("护理指导")) {
			SValues[2] = "3";
		} else if (SValues[2].equals("疾病预防指导")) {
			SValues[2] = "4";
		}

		if (SValues[3].equals("喂养指导")) {
			SValues[3] = "1";
		} else if (SValues[3].equals("母乳喂养")) {
			SValues[3] = "2";
		} else if (SValues[3].equals("护理指导")) {
			SValues[3] = "3";
		} else if (SValues[3].equals("疾病预防指导")) {
			SValues[3] = "4";
		}

		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		String form1 = "";
		String form2 = "";
		String form3 = "";
		String form4 = "";

		if (storeValueList[0].equals("1")) {
			form1 = "喂养指导";
		} else if (storeValueList[0].equals("2")) {
			form1 = "母乳喂养";
		} else if (storeValueList[0].equals("3")) {
			form1 = "护理指导";
		} else if (storeValueList[0].equals("4")) {
			form1 = "疾病预防指导";
		}
		
		if (storeValueList[1].equals("1")) {
			form2 = "喂养指导";
		} else if (storeValueList[1].equals("2")) {
			form2 = "母乳喂养";
		} else if (storeValueList[1].equals("3")) {
			form2 = "护理指导";
		} else if (storeValueList[1].equals("4")) {
			form2 = "疾病预防指导";
		}

		if (storeValueList[2].equals("1")) {
			form3 = "喂养指导";
		} else if (storeValueList[2].equals("2")) {
			form3 = "母乳喂养";
		} else if (storeValueList[2].equals("3")) {
			form3 = "护理指导";
		} else if (storeValueList[2].equals("4")) {
			form3 = "疾病预防指导";
		}

		if (storeValueList[3].equals("1")) {
			form4 = "喂养指导";
		} else if (storeValueList[3].equals("2")) {
			form4 = "母乳喂养";
		} else if (storeValueList[3].equals("3")) {
			form4 = "护理指导";
		} else if (storeValueList[3].equals("4")) {
			form4 = "疾病预防指导";
		}
		
		HValue = form1 + "/" + form2 + "/" + form3 + "/" + form4;
		top();
		return;
	}

	public GuidanceXSEMeta() {
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
