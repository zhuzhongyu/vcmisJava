 package coboo.impl.DocDriver.meta;


/**
	 * 家族史-母亲 对应字段
	 * HR51_01_002_8,HR51_01_002_9,HR51_01_002_10,HR51_01_002_11,HR51_01_002_12,HR51_01_002_13,HR51_01_002_14
	 * 
	 * @author 任笑言
	 */
public	class MotherFmlDiseaseMeta extends Meta{
	public String metaname="家族史-母亲";
	String[] SIds = new String[]{"mq1:mq_1:HR51_01_002_8",
			"mq2:mq_2:HR51_01_002_9", "mq3:mq_3:HR51_01_002_10", "mq4:mq_4:HR51_01_002_11",
			"mq5:mq_5:HR51_01_002_12", "mq6:mq_6:HR51_01_002_13", "HR51_01_002_14:HR51_01_002_14"};
	String[] SValues = new String[]{"","","","","","",""};
	String HValue;	
	

		void con_hvalue2svalue(String humanReadValue) {
			String readValueList[] = new String[7];
			readValueList = humanReadValue.split("/");
			if (readValueList[0].equals("无")) {
				SValues[0] = "1";
			} else {
				// 第一个格
				if (readValueList[0].equals("高血压")) {
					SValues[0] = "2";
				} else if (readValueList[0].equals("糖尿病")) {
					SValues[0] = "3";
				} else if (readValueList[0].equals("冠心病")) {
					SValues[0] = "4";
				} else if (readValueList[0].equals("慢性阻塞性肺嫉病")) {
					SValues[0] = "5";
				} else if (readValueList[0].equals("恶性肿瘤")) {
					SValues[0] = "6";
				} else if (readValueList[0].equals("脑卒中")) {
					SValues[0] = "7";
				} else if (readValueList[0].equals("重性精神疾病")) {
					SValues[0] = "8";
				} else if (readValueList[0].equals("结核病")) {
					SValues[0] = "9";
				} else if (readValueList[0].equals("肝炎")) {
					SValues[0] = "10";
				} else if (readValueList[0].equals("先天畸形")) {
					SValues[0] = "11";
				}
				// 第2个格
				if (readValueList[1].equals("高血压")) {
					SValues[1] = "2";
				} else if (readValueList[1].equals("糖尿病")) {
					SValues[1] = "3";
				} else if (readValueList[1].equals("冠心病")) {
					SValues[1] = "4";
				} else if (readValueList[1].equals("慢性阻塞性肺嫉病")) {
					SValues[1] = "5";
				} else if (readValueList[1].equals("恶性肿瘤")) {
					SValues[1] = "6";
				} else if (readValueList[1].equals("脑卒中")) {
					SValues[1] = "7";
				} else if (readValueList[1].equals("重性精神疾病")) {
					SValues[1] = "8";
				} else if (readValueList[1].equals("结核病")) {
					SValues[1] = "9";
				} else if (readValueList[1].equals("肝炎")) {
					SValues[1] = "10";
				} else if (readValueList[1].equals("先天畸形")) {
					SValues[1] = "11";
				}
				// 第3个格
				if (readValueList[2].equals("高血压")) {
					SValues[2] = "2";
				} else if (readValueList[2].equals("糖尿病")) {
					SValues[2] = "3";
				} else if (readValueList[2].equals("冠心病")) {
					SValues[2] = "4";
				} else if (readValueList[2].equals("慢性阻塞性肺嫉病")) {
					SValues[2] = "5";
				} else if (readValueList[2].equals("恶性肿瘤")) {
					SValues[2] = "6";
				} else if (readValueList[2].equals("脑卒中")) {
					SValues[2] = "7";
				} else if (readValueList[2].equals("重性精神疾病")) {
					SValues[2] = "8";
				} else if (readValueList[2].equals("结核病")) {
					SValues[2] = "9";
				} else if (readValueList[2].equals("肝炎")) {
					SValues[2] = "10";
				} else if (readValueList[2].equals("先天畸形")) {
					SValues[2] = "11";
				}
				// 第4个格
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
				} else if (readValueList[3].equals("先天畸形")) {
					SValues[3] = "11";
				}
				// 第5个格
				if (readValueList[4].equals("高血压")) {
					SValues[4] = "2";
				} else if (readValueList[4].equals("糖尿病")) {
					SValues[4] = "3";
				} else if (readValueList[4].equals("冠心病")) {
					SValues[4] = "4";
				} else if (readValueList[4].equals("慢性阻塞性肺嫉病")) {
					SValues[4] = "5";
				} else if (readValueList[4].equals("恶性肿瘤")) {
					SValues[4] = "6";
				} else if (readValueList[4].equals("脑卒中")) {
					SValues[4] = "7";
				} else if (readValueList[4].equals("重性精神疾病")) {
					SValues[4] = "8";
				} else if (readValueList[4].equals("结核病")) {
					SValues[4] = "9";
				} else if (readValueList[4].equals("肝炎")) {
					SValues[4] = "10";
				} else if (readValueList[4].equals("先天畸形")) {
					SValues[4] = "11";
				}
				// 第6个格
				if (readValueList[5].equals("高血压")) {
					SValues[5] = "2";
				} else if (readValueList[5].equals("糖尿病")) {
					SValues[5] = "3";
				} else if (readValueList[5].equals("冠心病")) {
					SValues[5] = "4";
				} else if (readValueList[5].equals("慢性阻塞性肺嫉病")) {
					SValues[5] = "5";
				} else if (readValueList[5].equals("恶性肿瘤")) {
					SValues[5] = "6";
				} else if (readValueList[5].equals("脑卒中")) {
					SValues[5] = "7";
				} else if (readValueList[5].equals("重性精神疾病")) {
					SValues[5] = "8";
				} else if (readValueList[5].equals("结核病")) {
					SValues[5] = "9";
				} else if (readValueList[5].equals("肝炎")) {
					SValues[5] = "10";
				} else if (readValueList[5].equals("先天畸形")) {
					SValues[5] = "11";
				}
				if (!readValueList[6].equals("")) {
					SValues[6] = readValueList[6];
				} else {
					SValues[6] = "";
				}
			}
			top();
			return;
		}

		void con_svalue2hvalue(String[] storeValueList) {
			if (SValues[0].equals("1")) {
				HValue = "无";
			} else {
				// 定义6个字符串分别代表6个空格
				String form1 = "";
				String form2 = "";
				String form3 = "";
				String form4 = "";
				String form5 = "";
				String form6 = "";
				// 第一个格 form1
				if (SValues[0].equals("2")) {
					form1 = "高血压";
				} else if (SValues[0].equals("3")) {
					form1 = "糖尿病";
				} else if (SValues[0].equals("4")) {
					form1 = "冠心病";
				} else if (SValues[0].equals("5")) {
					form1 = "慢性阻塞性肺嫉病";
				} else if (SValues[0].equals("6")) {
					form1 = "恶性肿瘤";
				} else if (SValues[0].equals("7")) {
					form1 = "脑卒中";
				} else if (SValues[0].equals("8")) {
					form1 = "重性精神疾病";
				} else if (SValues[0].equals("9")) {
					form1 = "结核病";
				} else if (SValues[0].equals("10")) {
					form1 = "肝炎";
				} else if (SValues[0].equals("11")) {
					form1 = "先天畸形";
				} else {
					form1 = "";
				}
				// 第2个格 form2
				if (SValues[1].equals("2")) {
					form2 = "高血压";
				} else if (SValues[1].equals("3")) {
					form2 = "糖尿病";
				} else if (SValues[1].equals("4")) {
					form2 = "冠心病";
				} else if (SValues[1].equals("5")) {
					form2 = "慢性阻塞性肺嫉病";
				} else if (SValues[1].equals("6")) {
					form2 = "恶性肿瘤";
				} else if (SValues[1].equals("7")) {
					form2 = "脑卒中";
				} else if (SValues[1].equals("8")) {
					form2 = "重性精神疾病";
				} else if (SValues[1].equals("9")) {
					form2 = "结核病";
				} else if (SValues[1].equals("10")) {
					form2 = "肝炎";
				} else if (SValues[1].equals("11")) {
					form2 = "先天畸形";
				} else {
					form2 = "";
				}
				// 第3个格 form3
				if (SValues[2].equals("2")) {
					form3 = "高血压";
				} else if (SValues[2].equals("3")) {
					form3 = "糖尿病";
				} else if (SValues[2].equals("4")) {
					form3 = "冠心病";
				} else if (SValues[2].equals("5")) {
					form3 = "慢性阻塞性肺嫉病";
				} else if (SValues[2].equals("6")) {
					form3 = "恶性肿瘤";
				} else if (SValues[2].equals("7")) {
					form3 = "脑卒中";
				} else if (SValues[2].equals("8")) {
					form3 = "重性精神疾病";
				} else if (SValues[2].equals("9")) {
					form3 = "结核病";
				} else if (SValues[2].equals("10")) {
					form3 = "肝炎";
				} else if (SValues[2].equals("11")) {
					form3 = "先天畸形";
				} else {
					form3 = "";
				}
				// 第4个格 form4
				if (SValues[3].equals("2")) {
					form4 = "高血压";
				} else if (SValues[3].equals("3")) {
					form4 = "糖尿病";
				} else if (SValues[3].equals("4")) {
					form4 = "冠心病";
				} else if (SValues[3].equals("5")) {
					form4 = "慢性阻塞性肺嫉病";
				} else if (SValues[3].equals("6")) {
					form4 = "恶性肿瘤";
				} else if (SValues[3].equals("7")) {
					form4 = "脑卒中";
				} else if (SValues[3].equals("8")) {
					form4 = "重性精神疾病";
				} else if (SValues[3].equals("9")) {
					form4 = "结核病";
				} else if (SValues[3].equals("10")) {
					form4 = "肝炎";
				} else if (SValues[3].equals("11")) {
					form4 = "先天畸形";
				} else {
					form4 = "";
				}
				// 第5个格 form5
				if (SValues[4].equals("2")) {
					form5 = "高血压";
				} else if (SValues[4].equals("3")) {
					form5 = "糖尿病";
				} else if (SValues[4].equals("4")) {
					form5 = "冠心病";
				} else if (SValues[4].equals("5")) {
					form5 = "慢性阻塞性肺嫉病";
				} else if (SValues[4].equals("6")) {
					form5 = "恶性肿瘤";
				} else if (SValues[4].equals("7")) {
					form5 = "脑卒中";
				} else if (SValues[4].equals("8")) {
					form5 = "重性精神疾病";
				} else if (SValues[4].equals("9")) {
					form5 = "结核病";
				} else if (SValues[4].equals("10")) {
					form5 = "肝炎";
				} else if (SValues[4].equals("11")) {
					form5 = "先天畸形";
				}
				// 第6个格 form6
				if (SValues[5].equals("2")) {
					form6 = "高血压";
				} else if (SValues[5].equals("3")) {
					form6 = "糖尿病";
				} else if (SValues[5].equals("4")) {
					form6 = "冠心病";
				} else if (SValues[5].equals("5")) {
					form6 = "慢性阻塞性肺嫉病";
				} else if (SValues[5].equals("6")) {
					form6 = "恶性肿瘤";
				} else if (SValues[5].equals("7")) {
					form6 = "脑卒中";
				} else if (SValues[5].equals("8")) {
					form6 = "重性精神疾病";
				} else if (SValues[5].equals("9")) {
					form6 = "结核病";
				} else if (SValues[5].equals("10")) {
					form6 = "肝炎";
				} else if (SValues[5].equals("11")) {
					form6 = "先天畸形";
				} else {
					form6 = "";
				}
				HValue = form1 + "/" + form2 + "/" + form3 + "/"
						+ form4 + "/" + form5 + "/" + form6 + "/"
						+ SValues[6];
			}
			top();
			return;
		}
		public MotherFmlDiseaseMeta(){
			top();
		}
		void top(){
			super.SIds=SIds;
			super.SValues=SValues;
			super.HValue=HValue;
		    super.metaname=metaname;	
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
