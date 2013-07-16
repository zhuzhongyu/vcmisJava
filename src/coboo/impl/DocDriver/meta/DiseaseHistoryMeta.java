package coboo.impl.DocDriver.meta;

/**
 * 既往史-疾病 对应字段 HR51_01_006_1,HR51_01_006_2, HR51_01_006_333,
 * HR51_01_006_3,HR51_01_006_4, HR51_01_006_5, HR51_01_006_6,HR51_01_006_7,
 * HR51_01_006_8, HR51_01_006_9,HR51_01_006_10, HR51_01_006_11,
 * HR51_01_006_12,HR51_01_006_13, HR51_01_006_14, HR51_01_006_15,HR51_01_006_16,
 * HR51_01_006_17, HR51_01_006_18,HR51_01_006_19, HR51_01_006_20
 * 
 * @author 任笑言
 */
public class DiseaseHistoryMeta extends Meta {
	public String	metaname	= "既往史-疾病 ";
	String[]		SIds		= new String[] { "jb:HR51_01_006_1", "jb11:HR51_01_006_2", "s2", "qzsj7:jb12:jbqz1:HR51_01_006_3",
			"qztime1:HR51_01_006_4:jb11:HR51_01_006_4", "HR51_01_006_5:jb12:HR51_01_006_5", "qzsj3:jbqz2:HR51_01_006_6", "qztime2:HR51_01_006_7:jb21",
			"HR51_01_006_8:jb22", "qzsj5:jbqz3:HR51_01_006_9", "qztime3:HR51_01_006_10:jb31", "HR51_01_006_11:jb32", "qzsj8:jbqz4:HR51_01_006_12",
			"qztime4:HR51_01_006_13:jb41", "HR51_01_006_14:jb42", "qzsj4:jbqz5:HR51_01_006_15", "qztime5:HR51_01_006_16:jb51", "HR51_01_006_17:jb52",
			"qzsj6:jbqz6:HR51_01_006_18", "qztime6:HR51_01_006_19:jb61", "s20:HR51_01_006_20:jb62" };
	String[]		SValues		= new String[] { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" };
	String			HValue="";

	void con_svalue2hvalue(String[] storeValueList) {
		int k=0;
		for (int i = 3;  k < storeValueList.length-2; i++) {
			String hValue = null;
			if (SValues[i].equals("1")) {
				hValue = "无";
			} else {
				if (SValues[i].equals("2")) {
					hValue = "高血压/";
				} else if (SValues[i].equals("3")) {
					hValue = "糖尿病/";
				} else if (SValues[i].equals("4")) {
					hValue = "冠心病/";
				} else if (SValues[i].equals("5")) {
					hValue = "慢性阻塞性肺嫉病/";
				} else if (SValues[i].equals("6")) {
					hValue = "恶性肿瘤_" + SValues[0]+"/";
				} else if (SValues[i].equals("7")) {
					hValue = "脑卒中/";
				} else if (SValues[i].equals("8")) {
					hValue = "重性精神疾病/";
				} else if (SValues[i].equals("9")) {
					hValue = "结核病/";
				} else if (SValues[i].equals("10")) {
					hValue = "肝炎/";
				} else if (SValues[i].equals("11")) {
					hValue = "其他法定传染病/";
				} else if (SValues[i].equals("12")) {
					hValue = "职业病_" + SValues[1]+"/";
				} else if (SValues[i].equals("13")) {
					hValue = "其他_" + SValues[2]+"/";
				}
			}
			int j = i++;
			 k = i++;
			HValue +="/"+ hValue + SValues[j] + "/" + SValues[k];
		}

		top();
		return;
	}

	void con_hvalue2svalue(String humanReadValue) {
		String readValueList[] = new String[21];
		readValueList = humanReadValue.split("/");
		SValues[0] = readValueList[0];
		SValues[1] = readValueList[1];

		if (readValueList[2].equals("无")) {
			SValues[2] = "1";
		}
		// 第一组 疾病确诊时间
		if (readValueList[3].equals("高血压")) {
			SValues[3] = "2";
		} else if (readValueList[3].equals("糖尿病")) {
			SValues[3] = "3";
		} else if (readValueList[3].equals("冠心病")) {
			SValues[3] = "4";
		} else if (readValueList[3].equals("慢性阻塞性肺嫉病")) {
			SValues[3] = "5";
		} else if (readValueList[3].equals("恶性肿瘤")) {
			SValues[3] = "6";
		} else if (readValueList[3].equals("脑卒中")) {
			SValues[3] = "7";
		} else if (readValueList[3].equals("重性精神疾病")) {
			SValues[3] = "8";
		} else if (readValueList[3].equals("结核病")) {
			SValues[3] = "9";
		} else if (readValueList[3].equals("肝炎")) {
			SValues[3] = "10";
		} else if (readValueList[3].equals("其他法定传染病")) {
			SValues[3] = "11";
		}
		SValues[4] = readValueList[4];
		SValues[5] = readValueList[5];

		// 第2组 疾病确诊时间
		if (readValueList[6].equals("高血压")) {
			SValues[6] = "2";
		} else if (readValueList[6].equals("糖尿病")) {
			SValues[6] = "3";
		} else if (readValueList[6].equals("冠心病")) {
			SValues[6] = "4";
		} else if (readValueList[6].equals("慢性阻塞性肺嫉病")) {
			SValues[6] = "5";
		} else if (readValueList[6].equals("恶性肿瘤")) {
			SValues[6] = "6";
		} else if (readValueList[6].equals("脑卒中")) {
			SValues[6] = "7";
		} else if (readValueList[6].equals("重性精神疾病")) {
			SValues[6] = "8";
		} else if (readValueList[6].equals("结核病")) {
			SValues[6] = "9";
		} else if (readValueList[6].equals("肝炎")) {
			SValues[6] = "10";
		} else if (readValueList[6].equals("其他法定传染病")) {
			SValues[6] = "11";
		}
		SValues[7] = readValueList[7];
		SValues[8] = readValueList[8];

		// 第3组 疾病确诊时间
		if (readValueList[9].equals("高血压")) {
			SValues[9] = "2";
		} else if (readValueList[9].equals("糖尿病")) {
			SValues[9] = "3";
		} else if (readValueList[9].equals("冠心病")) {
			SValues[9] = "4";
		} else if (readValueList[9].equals("慢性阻塞性肺嫉病")) {
			SValues[9] = "5";
		} else if (readValueList[9].equals("恶性肿瘤")) {
			SValues[9] = "6";
		} else if (readValueList[9].equals("脑卒中")) {
			SValues[9] = "7";
		} else if (readValueList[9].equals("重性精神疾病")) {
			SValues[9] = "8";
		} else if (readValueList[9].equals("结核病")) {
			SValues[9] = "9";
		} else if (readValueList[9].equals("肝炎")) {
			SValues[9] = "10";
		} else if (readValueList[9].equals("其他法定传染病")) {
			SValues[9] = "11";
		}
		SValues[10] = readValueList[10];
		SValues[11] = readValueList[11];

		// 第4组 疾病确诊时间
		if (readValueList[12].equals("高血压")) {
			SValues[12] = "2";
		} else if (readValueList[12].equals("糖尿病")) {
			SValues[12] = "3";
		} else if (readValueList[12].equals("冠心病")) {
			SValues[12] = "4";
		} else if (readValueList[12].equals("慢性阻塞性肺嫉病")) {
			SValues[12] = "5";
		} else if (readValueList[12].equals("恶性肿瘤")) {
			SValues[12] = "6";
		} else if (readValueList[12].equals("脑卒中")) {
			SValues[12] = "7";
		} else if (readValueList[12].equals("重性精神疾病")) {
			SValues[12] = "8";
		} else if (readValueList[12].equals("结核病")) {
			SValues[12] = "9";
		} else if (readValueList[12].equals("肝炎")) {
			SValues[12] = "10";
		} else if (readValueList[12].equals("其他法定传染病")) {
			SValues[12] = "11";
		}
		SValues[13] = readValueList[13];
		SValues[14] = readValueList[14];

		// 第5组 疾病确诊时间
		if (readValueList[15].equals("高血压")) {
			SValues[15] = "2";
		} else if (readValueList[15].equals("糖尿病")) {
			SValues[15] = "3";
		} else if (readValueList[15].equals("冠心病")) {
			SValues[15] = "4";
		} else if (readValueList[15].equals("慢性阻塞性肺嫉病")) {
			SValues[15] = "5";
		} else if (readValueList[15].equals("恶性肿瘤")) {
			SValues[15] = "6";
		} else if (readValueList[15].equals("脑卒中")) {
			SValues[15] = "7";
		} else if (readValueList[15].equals("重性精神疾病")) {
			SValues[15] = "8";
		} else if (readValueList[15].equals("结核病")) {
			SValues[15] = "9";
		} else if (readValueList[15].equals("肝炎")) {
			SValues[15] = "10";
		} else if (readValueList[15].equals("其他法定传染病")) {
			SValues[15] = "11";
		}
		SValues[16] = readValueList[16];
		SValues[17] = readValueList[17];

		// 第6组 疾病确诊时间
		if (readValueList[18].equals("高血压")) {
			SValues[18] = "2";
		} else if (readValueList[18].equals("糖尿病")) {
			SValues[18] = "3";
		} else if (readValueList[18].equals("冠心病")) {
			SValues[18] = "4";
		} else if (readValueList[18].equals("慢性阻塞性肺嫉病")) {
			SValues[18] = "5";
		} else if (readValueList[18].equals("恶性肿瘤")) {
			SValues[18] = "6";
		} else if (readValueList[18].equals("脑卒中")) {
			SValues[18] = "7";
		} else if (readValueList[18].equals("重性精神疾病")) {
			SValues[18] = "8";
		} else if (readValueList[18].equals("结核病")) {
			SValues[18] = "9";
		} else if (readValueList[18].equals("肝炎")) {
			SValues[18] = "10";
		} else if (readValueList[18].equals("其他法定传染病")) {
			SValues[18] = "11";
		}
		SValues[19] = readValueList[19];
		SValues[20] = readValueList[20];
		top();
		return;
	}

	public DiseaseHistoryMeta() {
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