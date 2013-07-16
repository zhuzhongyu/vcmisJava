package coboo.impl.DocDriver.meta;

/**
 * 残疾情况 对应字段
 * CV5101_05_1,CV5101_05_2,CV5101_05_3,CV5101_05_4,CV5101_05_5,CV5101_05_6,CV5101_05_7
 * 
 * @author 任笑言
 */
public class DisableMeta extends Meta {

	public String metaname = "残疾情况";
	String[] SIds = new String[] { "cjqk_qt:CV5101_05_1", "cjqk1:cjqk1_1:CV5101_05_2", "cjqk2:cjqk1_2:CV5101_05_3",
			"cjqk3:cjqk1_3:CV5101_05_4", "cjqk4:cjqk1_4:CV5101_05_5", "cjqk5:cjqk1_5:CV5101_05_6", "cjqk6:cjqk1_6:CV5101_05_7" };
	String[] SValues = new String[] { "", "", "", "", "", "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {
		String readValueList[] = new String[7];
		readValueList = humanReadValue.split("/");
		if (readValueList[1].equals("无疾病")) {
			SValues[1] = "1";
		} else {

			if (!readValueList[0].equals("")) {
				SValues[0] = readValueList[0];
			} else {
				SValues[0] = "";
			}
			// CV5101_05_2 残疾情况：第一选项
			// CV5101_05_7 残疾情况：第六选项
			if (readValueList[0].equals("视力残疾")) {
				SValues[0] = "2";
			} else if (readValueList[0].equals("听力残疾")) {
				SValues[0] = "3";
			} else if (readValueList[0].equals("言语残疾")) {
				SValues[0] = "4";
			} else if (readValueList[0].equals("肢体残疾")) {
				SValues[0] = "5";
			} else if (readValueList[0].equals("智力残疾")) {
				SValues[0] = "6";
			} else if (readValueList[0].equals("精神残疾")) {
				SValues[0] = "7";
			}
			// =================================================
			if (readValueList[1].equals("视力残疾")) {
				SValues[1] = "2";
			} else if (readValueList[1].equals("听力残疾")) {
				SValues[1] = "3";
			} else if (readValueList[1].equals("言语残疾")) {
				SValues[1] = "4";
			} else if (readValueList[1].equals("肢体残疾")) {
				SValues[1] = "5";
			} else if (readValueList[1].equals("智力残疾")) {
				SValues[1] = "6";
			} else if (readValueList[1].equals("精神残疾")) {
				SValues[1] = "7";
			}
			// CV5101_05_3 残疾情况：第二选项
			if (readValueList[2].equals("视力残疾")) {
				SValues[2] = "2";
			} else if (readValueList[2].equals("听力残疾")) {
				SValues[2] = "3";
			} else if (readValueList[2].equals("言语残疾")) {
				SValues[2] = "4";
			} else if (readValueList[2].equals("肢体残疾")) {
				SValues[2] = "5";
			} else if (readValueList[2].equals("智力残疾")) {
				SValues[2] = "6";
			} else if (readValueList[2].equals("精神残疾")) {
				SValues[2] = "7";
			}

			// CV5101_05_4 残疾情况：第三选项
			if (readValueList[3].equals("视力残疾")) {
				SValues[3] = "2";
			} else if (readValueList[3].equals("听力残疾")) {
				SValues[3] = "3";
			} else if (readValueList[3].equals("言语残疾")) {
				SValues[3] = "4";
			} else if (readValueList[3].equals("肢体残疾")) {
				SValues[3] = "5";
			} else if (readValueList[3].equals("智力残疾")) {
				SValues[3] = "6";
			} else if (readValueList[3].equals("精神残疾")) {
				SValues[3] = "7";
			}

			// CV5101_05_5 残疾情况：第四选项
			if (readValueList[4].equals("视力残疾")) {
				SValues[4] = "2";
			} else if (readValueList[4].equals("听力残疾")) {
				SValues[4] = "3";
			} else if (readValueList[4].equals("言语残疾")) {
				SValues[4] = "4";
			} else if (readValueList[4].equals("肢体残疾")) {
				SValues[4] = "5";
			} else if (readValueList[4].equals("智力残疾")) {
				SValues[4] = "6";
			} else if (readValueList[4].equals("精神残疾")) {
				SValues[4] = "7";
			}

			// CV5101_05_6 残疾情况：第五选项
			if (readValueList[5].equals("视力残疾")) {
				SValues[5] = "2";
			} else if (readValueList[5].equals("听力残疾")) {
				SValues[5] = "3";
			} else if (readValueList[5].equals("言语残疾")) {
				SValues[5] = "4";
			} else if (readValueList[5].equals("肢体残疾")) {
				SValues[5] = "5";
			} else if (readValueList[5].equals("智力残疾")) {
				SValues[5] = "6";
			} else if (readValueList[5].equals("精神残疾")) {
				SValues[5] = "7";
			}

		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		if (SValues[1].equals("1")) {
			HValue = "无疾病";
		} else {
			// 定义6个字符串分别代表6个空格
			String form1 = "";
			String form2 = "";
			String form3 = "";
			String form4 = "";
			String form5 = "";
			String form6 = "";

			// 第一个格
			// 第6个格
			if (SValues[0].equals("2")) {
				form6 = "视力残疾";
			} else if (SValues[0].equals("3")) {
				form6 = "听力残疾";
			} else if (SValues[0].equals("4")) {
				form6 = "言语残疾";
			} else if (SValues[0].equals("5")) {
				form6 = "肢体残疾";
			} else if (SValues[0].equals("6")) {
				form6 = "智力残疾";
			} else if (SValues[0].equals("7")) {
				form6 = "精神残疾";
			} else {
				form6 = "";
			}
			// ====================================
			if (SValues[1].equals("2")) {
				form1 = "视力残疾";
			} else if (SValues[1].equals("3")) {
				form1 = "听力残疾";
			} else if (SValues[1].equals("4")) {
				form1 = "言语残疾";
			} else if (SValues[1].equals("5")) {
				form1 = "肢体残疾";
			} else if (SValues[1].equals("6")) {
				form1 = "智力残疾";
			} else if (SValues[1].equals("7")) {
				form1 = "精神残疾";
			} else {
				form1 = "";
			}

			// 第2个格
			if (SValues[2].equals("2")) {
				form2 = "视力残疾";
			} else if (SValues[2].equals("3")) {
				form2 = "听力残疾";
			} else if (SValues[2].equals("4")) {
				form2 = "言语残疾";
			} else if (SValues[2].equals("5")) {
				form2 = "肢体残疾";
			} else if (SValues[2].equals("6")) {
				form2 = "智力残疾";
			} else if (SValues[2].equals("7")) {
				form2 = "精神残疾";
			} else {
				form2 = "";
			}

			// 第3个格
			if (SValues[3].equals("2")) {
				form3 = "视力残疾";
			} else if (SValues[3].equals("3")) {
				form3 = "听力残疾";
			} else if (SValues[3].equals("4")) {
				form3 = "言语残疾";
			} else if (SValues[3].equals("5")) {
				form3 = "肢体残疾";
			} else if (SValues[3].equals("6")) {
				form3 = "智力残疾";
			} else if (SValues[3].equals("7")) {
				form3 = "精神残疾";
			} else {
				form3 = "";
			}

			// 第4个格
			if (SValues[4].equals("2")) {
				form4 = "视力残疾";
			} else if (SValues[4].equals("3")) {
				form4 = "听力残疾";
			} else if (SValues[4].equals("4")) {
				form4 = "言语残疾";
			} else if (SValues[4].equals("5")) {
				form4 = "肢体残疾";
			} else if (SValues[4].equals("6")) {
				form4 = "智力残疾";
			} else if (SValues[4].equals("7")) {
				form4 = "精神残疾";
			} else {
				form4 = "";
			}

			// 第5个格
			if (SValues[5].equals("2")) {
				form5 = "视力残疾";
			} else if (SValues[5].equals("3")) {
				form5 = "听力残疾";
			} else if (SValues[5].equals("4")) {
				form5 = "言语残疾";
			} else if (SValues[5].equals("5")) {
				form5 = "肢体残疾";
			} else if (SValues[5].equals("6")) {
				form5 = "智力残疾";
			} else if (SValues[5].equals("7")) {
				form5 = "精神残疾";
			} else {
				form5 = "";
			}

			HValue = form1 + "/" + form2 + "/" + form3 + "/" + form4 + "/"
					+ form5 + "/" + form6;
		}
		top();
		return;
	}

	public DisableMeta() {
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