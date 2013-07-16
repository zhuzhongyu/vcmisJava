package coboo.impl.DocDriver.meta;
/**
 * 高血压--第3次症状
 * @author rxy
 *
 */
public class ThirdTimeSymptomsMeta extends Meta{
	public String metaname = " 症状 ";
	String[] SIds = new String[] { "zz3_1:cbtjbzz21", "zz3_2:cbtjbzz22", "zz3_3:cbtjbzz23",
			"zz3_4:cbtjbzz24", "zz3_5:cbtjbzz25", "zz3_6:cbtjbzz26", "zz3_7:cbtjbzz27", "zz3_8:cbtjbzz28",
			"zzqt3:cbtjbzz29" };
	String[] SValues = new String[] { "", "", "", "", "", "", "", "", "" };
	String HValue;

	/*
	 * (non-Javadoc)
	 * 
	 * @see coboo.model.table.metaData#humanReadToStore(java.lang.String)
	 */
	void con_hvalue2svalue(String humanReadValue) {
		String[] valueList = new String[9];
		valueList = humanReadValue.split("/");
		if (valueList[0].equals("无症状")) {
			SValues[0] = "1";
		} else {
			// cbtjbzz01 症状：第一选项
			if (valueList[0].equals("头痛头晕")) {
				SValues[0] = "2";
			} else if (valueList[0].equals("恶心呕吐")) {
				SValues[0] = "3";
			} else if (valueList[0].equals("眼花耳鸣")) {
				SValues[0] = "4";
			} else if (valueList[0].equals("呼吸困难")) {
				SValues[0] = "5";
			} else if (valueList[0].equals("心悸胸闷")) {
				SValues[0] = "6";
			} else if (valueList[0].equals("鼻衄出血不止")) {
				SValues[0] = "7";
			} else if (valueList[0].equals("四肢发麻")) {
				SValues[0] = "8";
			} else if (valueList[0].equals("下肢水肿")) {
				SValues[0] = "9";
			} else {
				SValues[0] = "";
			}
			// cbtjbzz02 症状：第二选项
			if (valueList[1].equals("头痛头晕")) {
				SValues[1] = "2";
			} else if (valueList[1].equals("恶心呕吐")) {
				SValues[1] = "3";
			} else if (valueList[1].equals("眼花耳鸣")) {
				SValues[1] = "4";
			} else if (valueList[1].equals("呼吸困难")) {
				SValues[1] = "5";
			} else if (valueList[1].equals("心悸胸闷")) {
				SValues[1] = "6";
			} else if (valueList[1].equals("鼻衄出血不止")) {
				SValues[1] = "7";
			} else if (valueList[1].equals("四肢发麻")) {
				SValues[1] = "8";
			} else if (valueList[1].equals("下肢水肿")) {
				SValues[1] = "9";
			} else {
				SValues[1] = "";
			}
			// cbtjbzz03 症状：第三选项
			if (valueList[2].equals("头痛头晕")) {
				SValues[2] = "2";
			} else if (valueList[2].equals("恶心呕吐")) {
				SValues[2] = "3";
			} else if (valueList[2].equals("眼花耳鸣")) {
				SValues[2] = "4";
			} else if (valueList[2].equals("呼吸困难")) {
				SValues[2] = "5";
			} else if (valueList[2].equals("心悸胸闷")) {
				SValues[2] = "6";
			} else if (valueList[2].equals("鼻衄出血不止")) {
				SValues[2] = "7";
			} else if (valueList[2].equals("四肢发麻")) {
				SValues[2] = "8";
			} else if (valueList[2].equals("下肢水肿")) {
				SValues[2] = "9";
			} else {
				SValues[2] = "";
			}
			// cbtjbzz04 症状：第四选项
			if (valueList[3].equals("头痛头晕")) {
				SValues[3] = "2";
			} else if (valueList[3].equals("恶心呕吐")) {
				SValues[3] = "3";
			} else if (valueList[3].equals("眼花耳鸣")) {
				SValues[3] = "4";
			} else if (valueList[3].equals("呼吸困难")) {
				SValues[3] = "5";
			} else if (valueList[3].equals("心悸胸闷")) {
				SValues[3] = "6";
			} else if (valueList[3].equals("鼻衄出血不止")) {
				SValues[3] = "7";
			} else if (valueList[3].equals("四肢发麻")) {
				SValues[3] = "8";
			} else if (valueList[3].equals("下肢水肿")) {
				SValues[3] = "9";
			} else {
				SValues[3] = "";
			}
			// cbtjbzz05 症状：第五选项
			if (valueList[4].equals("头痛头晕")) {
				SValues[4] = "2";
			} else if (valueList[4].equals("恶心呕吐")) {
				SValues[4] = "3";
			} else if (valueList[4].equals("眼花耳鸣")) {
				SValues[4] = "4";
			} else if (valueList[4].equals("呼吸困难")) {
				SValues[4] = "5";
			} else if (valueList[4].equals("心悸胸闷")) {
				SValues[4] = "6";
			} else if (valueList[4].equals("鼻衄出血不止")) {
				SValues[4] = "7";
			} else if (valueList[4].equals("四肢发麻")) {
				SValues[4] = "8";
			} else if (valueList[4].equals("下肢水肿")) {
				SValues[4] = "9";
			} else {
				SValues[4] = "";
			}
			// cbtjbzz06 症状：第六选项
			if (valueList[5].equals("头痛头晕")) {
				SValues[5] = "2";
			} else if (valueList[5].equals("恶心呕吐")) {
				SValues[5] = "3";
			} else if (valueList[5].equals("眼花耳鸣")) {
				SValues[5] = "4";
			} else if (valueList[5].equals("呼吸困难")) {
				SValues[5] = "5";
			} else if (valueList[5].equals("心悸胸闷")) {
				SValues[5] = "6";
			} else if (valueList[5].equals("鼻衄出血不止")) {
				SValues[5] = "7";
			} else if (valueList[5].equals("四肢发麻")) {
				SValues[5] = "8";
			} else if (valueList[5].equals("下肢水肿")) {
				SValues[5] = "9";
			} else {
				SValues[5] = "";
			}
			// cbtjbzz07 症状：第七选项
			if (valueList[6].equals("头痛头晕")) {
				SValues[6] = "2";
			} else if (valueList[6].equals("恶心呕吐")) {
				SValues[6] = "3";
			} else if (valueList[6].equals("眼花耳鸣")) {
				SValues[6] = "4";
			} else if (valueList[6].equals("呼吸困难")) {
				SValues[6] = "5";
			} else if (valueList[6].equals("心悸胸闷")) {
				SValues[6] = "6";
			} else if (valueList[6].equals("鼻衄出血不止")) {
				SValues[6] = "7";
			} else if (valueList[6].equals("四肢发麻")) {
				SValues[6] = "8";
			} else if (valueList[6].equals("下肢水肿")) {
				SValues[6] = "9";
			} else {
				SValues[6] = "";
			}
			// cbtjbzz08 症状：第八选项
			if (valueList[7].equals("头痛头晕")) {
				SValues[7] = "2";
			} else if (valueList[7].equals("恶心呕吐")) {
				SValues[7] = "3";
			} else if (valueList[7].equals("眼花耳鸣")) {
				SValues[7] = "4";
			} else if (valueList[7].equals("呼吸困难")) {
				SValues[7] = "5";
			} else if (valueList[7].equals("心悸胸闷")) {
				SValues[7] = "6";
			} else if (valueList[7].equals("鼻衄出血不止")) {
				SValues[7] = "7";
			} else if (valueList[7].equals("四肢发麻")) {
				SValues[7] = "8";
			} else if (valueList[7].equals("下肢水肿")) {
				SValues[7] = "9";
			} else {
				SValues[7] = "";
			}
			// cbtjbzz09 症状其他
			if (!valueList[8].equals("")) {
				SValues[8] = valueList[8];
			} else {
				SValues[8] = "";
			}
		}
		top();
		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see coboo.model.table.metaData#storeToHumanRead(java.lang.String[])
	 */
	void con_svalue2hvalue(String[] storeValueList) {
		if (storeValueList[0].equals("1")) {
			HValue = "无症状";
		} else {
			String str1 = "";
			String str2 = "";
			String str3 = "";
			String str4 = "";
			String str5 = "";
			String str6 = "";
			String str7 = "";
			// 第一个格
			if (storeValueList[0].equals("2")) {
			} else if (storeValueList[0].equals("3")) {
			} else if (storeValueList[0].equals("4")) {
			} else if (storeValueList[0].equals("5")) {
			} else if (storeValueList[0].equals("6")) {
			} else if (storeValueList[0].equals("7")) {
			} else if (storeValueList[0].equals("8")) {
			} else if (storeValueList[0].equals("9")) {
			}
			// 第二个格
			if (storeValueList[1].equals("2")) {
				str1 = "头痛头晕";
			} else if (storeValueList[1].equals("3")) {
				str1 = "恶心呕吐";
			} else if (storeValueList[1].equals("4")) {
				str1 = "眼花耳鸣";
			} else if (storeValueList[1].equals("5")) {
				str1 = "呼吸困难";
			} else if (storeValueList[1].equals("6")) {
				str1 = "心悸胸闷";
			} else if (storeValueList[1].equals("7")) {
				str1 = "鼻衄出血不止";
			} else if (storeValueList[1].equals("8")) {
				str1 = "四肢发麻";
			} else if (storeValueList[1].equals("9")) {
				str1 = "下肢水肿";
			}
			// 第三个格
			if (storeValueList[2].equals("2")) {
				str2 = "头痛头晕";
			} else if (storeValueList[2].equals("3")) {
				str2 = "恶心呕吐";
			} else if (storeValueList[2].equals("4")) {
				str2 = "眼花耳鸣";
			} else if (storeValueList[2].equals("5")) {
				str2 = "呼吸困难";
			} else if (storeValueList[2].equals("6")) {
				str2 = "心悸胸闷";
			} else if (storeValueList[2].equals("7")) {
				str2 = "鼻衄出血不止";
			} else if (storeValueList[2].equals("8")) {
				str2 = "四肢发麻";
			} else if (storeValueList[2].equals("9")) {
				str2 = "下肢水肿";
			}
			// 第四个格
			if (storeValueList[3].equals("2")) {
				str3 = "头痛头晕";
			} else if (storeValueList[3].equals("3")) {
				str3 = "恶心呕吐";
			} else if (storeValueList[3].equals("4")) {
				str3 = "眼花耳鸣";
			} else if (storeValueList[3].equals("5")) {
				str3 = "呼吸困难";
			} else if (storeValueList[3].equals("6")) {
				str3 = "心悸胸闷";
			} else if (storeValueList[3].equals("7")) {
				str3 = "鼻衄出血不止";
			} else if (storeValueList[3].equals("8")) {
				str3 = "四肢发麻";
			} else if (storeValueList[3].equals("9")) {
				str3 = "下肢水肿";
			}
			// 第五个格
			if (storeValueList[4].equals("2")) {
				str4 = "头痛头晕";
			} else if (storeValueList[4].equals("3")) {
				str4 = "恶心呕吐";
			} else if (storeValueList[4].equals("4")) {
				str4 = "眼花耳鸣";
			} else if (storeValueList[4].equals("5")) {
				str4 = "呼吸困难";
			} else if (storeValueList[4].equals("6")) {
				str4 = "心悸胸闷";
			} else if (storeValueList[4].equals("7")) {
				str4 = "鼻衄出血不止";
			} else if (storeValueList[4].equals("8")) {
				str4 = "四肢发麻";
			} else if (storeValueList[4].equals("9")) {
				str4 = "下肢水肿";
			}
			// 第六个格
			if (storeValueList[5].equals("2")) {
				str5 = "头痛头晕";
			} else if (storeValueList[5].equals("3")) {
				str5 = "恶心呕吐";
			} else if (storeValueList[5].equals("4")) {
				str5 = "眼花耳鸣";
			} else if (storeValueList[5].equals("5")) {
				str5 = "呼吸困难";
			} else if (storeValueList[5].equals("6")) {
				str5 = "心悸胸闷";
			} else if (storeValueList[5].equals("7")) {
				str5 = "鼻衄出血不止";
			} else if (storeValueList[5].equals("8")) {
				str5 = "四肢发麻";
			} else if (storeValueList[5].equals("9")) {
				str5 = "下肢水肿";
			}
			// 第七个格
			if (storeValueList[6].equals("2")) {
				str6 = "头痛头晕";
			} else if (storeValueList[6].equals("3")) {
				str6 = "恶心呕吐";
			} else if (storeValueList[6].equals("4")) {
				str6 = "眼花耳鸣";
			} else if (storeValueList[6].equals("5")) {
				str6 = "呼吸困难";
			} else if (storeValueList[6].equals("6")) {
				str6 = "心悸胸闷";
			} else if (storeValueList[6].equals("7")) {
				str6 = "鼻衄出血不止";
			} else if (storeValueList[6].equals("8")) {
				str6 = "四肢发麻";
			} else if (storeValueList[6].equals("9")) {
				str6 = "下肢水肿";
			}
			// 第八个格
			if (storeValueList[7].equals("2")) {
				str7 = "头痛头晕";
			} else if (storeValueList[7].equals("3")) {
				str7 = "恶心呕吐";
			} else if (storeValueList[7].equals("4")) {
				str7 = "眼花耳鸣";
			} else if (storeValueList[7].equals("5")) {
				str7 = "呼吸困难";
			} else if (storeValueList[7].equals("6")) {
				str7 = "心悸胸闷";
			} else if (storeValueList[7].equals("7")) {
				str7 = "鼻衄出血不止";
			} else if (storeValueList[7].equals("8")) {
				str7 = "四肢发麻";
			} else if (storeValueList[7].equals("9")) {
				str7 = "下肢水肿";
			}

			HValue = str1 + "/" + str2 + "/" + str3 + "/" + str4 + "/" + str5
					+ "/" + str6 + "/" + str7 + "/" + storeValueList[8];

		}
		top();
		return;
	}

	public ThirdTimeSymptomsMeta() {
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
