 package coboo.impl.DocDriver.meta;
	/**
	 * 幼儿期患病情况 对应字段
	 * cbyrhbqk1,cbyrhbqk2,cbyrhbqk3,cbyrhbqk4,cbyrhbqk5,cbyrhbqk6,cbyrhbqk7,cbyrhbqk8,cbyrhbqk9,cbyrhbqk10,cbyrhbqk11,cbyrhbqk12
	 * 
	 * @author 任笑言
	 */
public	class HistoryOfSickMeta extends Meta {
		public String metaname="幼儿期患病情况";
		String[] SIds = new String[]{"cbyrhbqk1",
				"cbyrhbqk2", "cbyrhbqk3", "cbyrhbqk4", "cbyrhbqk5",
				"cbyrhbqk6", "cbyrhbqk7", "cbyrhbqk8", "cbyrhbqk9",
				"cbyrhbqk10", "cbyrhbqk11", "cbyrhbqk12" };
		String[] SValues = new String[]{"","","","","","","","","","","",""};
		String HValue;	


		void con_hvalue2svalue(String humanReadValue) {
			String readValueList[] = new String[12];
			readValueList = humanReadValue.split("/");
			if (readValueList[4].equals("无")) {
				SValues[0] = "";
				SValues[1] = "";
				SValues[2] = "";
				SValues[3] = "";
				SValues[4] = "1";
				SValues[5] = "";
				SValues[6] = "";
				SValues[7] = "";
				SValues[8] = "";
				SValues[9] = "";
				SValues[10] = "";
				SValues[11] = "";
			} else {
				SValues[0] = readValueList[0];
				SValues[1] = readValueList[1];
				SValues[2] = readValueList[2];
				SValues[3] = readValueList[3];

				if (readValueList[4].equals("肺炎")) {
					SValues[4] = "2";
				} else if (readValueList[4].equals("麻疹")) {
					SValues[4] = "3";
				} else if (readValueList[4].equals("贫血")) {
					SValues[4] = "4";
				} else if (readValueList[4].equals("营养不良")) {
					SValues[4] = "5";
				} else if (readValueList[4].equals("佝偻病")) {
					SValues[4] = "6";
				} else if (readValueList[4].equals("因腹泻住院")) {
					SValues[4] = "7";
				} else if (readValueList[4].equals("因外伤住院")) {
					SValues[4] = "8";
				} else if (readValueList[4].equals("其他")) {
					SValues[4] = "9";
				}

				if (readValueList[5].equals("肺炎")) {
					SValues[5] = "2";
				} else if (readValueList[5].equals("麻疹")) {
					SValues[5] = "3";
				} else if (readValueList[5].equals("贫血")) {
					SValues[5] = "4";
				} else if (readValueList[5].equals("营养不良")) {
					SValues[5] = "5";
				} else if (readValueList[5].equals("佝偻病")) {
					SValues[5] = "6";
				} else if (readValueList[5].equals("因腹泻住院")) {
					SValues[5] = "7";
				} else if (readValueList[5].equals("因外伤住院")) {
					SValues[5] = "8";
				} else if (readValueList[5].equals("其他")) {
					SValues[5] = "9";
				}

				if (readValueList[6].equals("肺炎")) {
					SValues[6] = "2";
				} else if (readValueList[6].equals("麻疹")) {
					SValues[6] = "3";
				} else if (readValueList[6].equals("贫血")) {
					SValues[6] = "4";
				} else if (readValueList[6].equals("营养不良")) {
					SValues[6] = "5";
				} else if (readValueList[6].equals("佝偻病")) {
					SValues[6] = "6";
				} else if (readValueList[6].equals("因腹泻住院")) {
					SValues[6] = "7";
				} else if (readValueList[6].equals("因外伤住院")) {
					SValues[6] = "8";
				} else if (readValueList[6].equals("其他")) {
					SValues[6] = "9";
				}

				if (readValueList[7].equals("肺炎")) {
					SValues[7] = "2";
				} else if (readValueList[7].equals("麻疹")) {
					SValues[7] = "3";
				} else if (readValueList[7].equals("贫血")) {
					SValues[7] = "4";
				} else if (readValueList[7].equals("营养不良")) {
					SValues[7] = "5";
				} else if (readValueList[7].equals("佝偻病")) {
					SValues[7] = "6";
				} else if (readValueList[7].equals("因腹泻住院")) {
					SValues[7] = "7";
				} else if (readValueList[7].equals("因外伤住院")) {
					SValues[7] = "8";
				} else if (readValueList[7].equals("其他")) {
					SValues[7] = "9";
				}

				if (readValueList[8].equals("肺炎")) {
					SValues[8] = "2";
				} else if (readValueList[8].equals("麻疹")) {
					SValues[8] = "3";
				} else if (readValueList[8].equals("贫血")) {
					SValues[8] = "4";
				} else if (readValueList[8].equals("营养不良")) {
					SValues[8] = "5";
				} else if (readValueList[8].equals("佝偻病")) {
					SValues[8] = "6";
				} else if (readValueList[8].equals("因腹泻住院")) {
					SValues[8] = "7";
				} else if (readValueList[8].equals("因外伤住院")) {
					SValues[8] = "8";
				} else if (readValueList[8].equals("其他")) {
					SValues[8] = "9";
				}

				if (readValueList[9].equals("肺炎")) {
					SValues[9] = "2";
				} else if (readValueList[9].equals("麻疹")) {
					SValues[9] = "3";
				} else if (readValueList[9].equals("贫血")) {
					SValues[9] = "4";
				} else if (readValueList[9].equals("营养不良")) {
					SValues[9] = "5";
				} else if (readValueList[9].equals("佝偻病")) {
					SValues[9] = "6";
				} else if (readValueList[9].equals("因腹泻住院")) {
					SValues[9] = "7";
				} else if (readValueList[9].equals("因外伤住院")) {
					SValues[9] = "8";
				} else if (readValueList[9].equals("其他")) {
					SValues[9] = "9";
				}

				if (readValueList[10].equals("肺炎")) {
					SValues[10] = "2";
				} else if (readValueList[10].equals("麻疹")) {
					SValues[10] = "3";
				} else if (readValueList[10].equals("贫血")) {
					SValues[10] = "4";
				} else if (readValueList[10].equals("营养不良")) {
					SValues[10] = "5";
				} else if (readValueList[10].equals("佝偻病")) {
					SValues[10] = "6";
				} else if (readValueList[10].equals("因腹泻住院")) {
					SValues[10] = "7";
				} else if (readValueList[10].equals("因外伤住院")) {
					SValues[10] = "8";
				} else if (readValueList[10].equals("其他")) {
					SValues[10] = "9";
				}

				if (readValueList[11].equals("肺炎")) {
					SValues[11] = "2";
				} else if (readValueList[11].equals("麻疹")) {
					SValues[11] = "3";
				} else if (readValueList[11].equals("贫血")) {
					SValues[11] = "4";
				} else if (readValueList[11].equals("营养不良")) {
					SValues[11] = "5";
				} else if (readValueList[11].equals("佝偻病")) {
					SValues[11] = "6";
				} else if (readValueList[11].equals("因腹泻住院")) {
					SValues[11] = "7";
				} else if (readValueList[11].equals("因外伤住院")) {
					SValues[11] = "8";
				} else if (readValueList[11].equals("其他")) {
					SValues[11] = "9";
				}
			}
			top();
			return;
		}

		void con_svalue2hvalue(String[] storeValueList) {
			String line1 = "";
			String line2 = "";
			String line3 = "";
			String line4 = "";
			String form1 = "";
			String form2 = "";
			String form3 = "";
			String form4 = "";
			String form5 = "";
			String form6 = "";
			String form7 = "";
			String form8 = "";

			if (storeValueList[4].equals("1")) {
				form1 = "无";
			} else {
				line1 = storeValueList[0];
				line2 = storeValueList[1];
				line3 = storeValueList[2];
				line4 = storeValueList[3];

				if (storeValueList[4].equals("2")) {
					form1 = "肺炎";
				} else if (storeValueList[4].equals("3")) {
					form1 = "麻疹";
				} else if (storeValueList[4].equals("4")) {
					form1 = "贫血";
				} else if (storeValueList[4].equals("5")) {
					form1 = "营养不良";
				} else if (storeValueList[4].equals("6")) {
					form1 = "佝偻病";
				} else if (storeValueList[4].equals("7")) {
					form1 = "因腹泻住院";
				} else if (storeValueList[4].equals("8")) {
					form1 = "因外伤住院";
				} else if (storeValueList[4].equals("9")) {
					form1 = "其他";
				}

				if (storeValueList[5].equals("2")) {
					form2 = "肺炎";
				} else if (storeValueList[5].equals("3")) {
					form2 = "麻疹";
				} else if (storeValueList[5].equals("4")) {
					form2 = "贫血";
				} else if (storeValueList[5].equals("5")) {
					form2 = "营养不良";
				} else if (storeValueList[5].equals("6")) {
					form2 = "佝偻病";
				} else if (storeValueList[5].equals("7")) {
					form2 = "因腹泻住院";
				} else if (storeValueList[5].equals("8")) {
					form2 = "因外伤住院";
				} else if (storeValueList[5].equals("9")) {
					form2 = "其他";
				}

				if (storeValueList[6].equals("2")) {
					form3 = "肺炎";
				} else if (storeValueList[6].equals("3")) {
					form3 = "麻疹";
				} else if (storeValueList[6].equals("4")) {
					form3 = "贫血";
				} else if (storeValueList[6].equals("5")) {
					form3 = "营养不良";
				} else if (storeValueList[6].equals("6")) {
					form3 = "佝偻病";
				} else if (storeValueList[6].equals("7")) {
					form3 = "因腹泻住院";
				} else if (storeValueList[6].equals("8")) {
					form3 = "因外伤住院";
				} else if (storeValueList[6].equals("9")) {
					form3 = "其他";
				}

				if (storeValueList[7].equals("2")) {
					form4 = "肺炎";
				} else if (storeValueList[7].equals("3")) {
					form4 = "麻疹";
				} else if (storeValueList[7].equals("4")) {
					form4 = "贫血";
				} else if (storeValueList[7].equals("5")) {
					form4 = "营养不良";
				} else if (storeValueList[7].equals("6")) {
					form4 = "佝偻病";
				} else if (storeValueList[7].equals("7")) {
					form4 = "因腹泻住院";
				} else if (storeValueList[7].equals("8")) {
					form4 = "因外伤住院";
				} else if (storeValueList[7].equals("9")) {
					form4 = "其他";
				}

				if (storeValueList[8].equals("2")) {
					form5 = "肺炎";
				} else if (storeValueList[8].equals("3")) {
					form5 = "麻疹";
				} else if (storeValueList[8].equals("4")) {
					form5 = "贫血";
				} else if (storeValueList[8].equals("5")) {
					form5 = "营养不良";
				} else if (storeValueList[8].equals("6")) {
					form5 = "佝偻病";
				} else if (storeValueList[8].equals("7")) {
					form5 = "因腹泻住院";
				} else if (storeValueList[8].equals("8")) {
					form5 = "因外伤住院";
				} else if (storeValueList[8].equals("9")) {
					form5 = "其他";
				}

				if (storeValueList[9].equals("2")) {
					form6 = "肺炎";
				} else if (storeValueList[9].equals("3")) {
					form6 = "麻疹";
				} else if (storeValueList[9].equals("4")) {
					form6 = "贫血";
				} else if (storeValueList[9].equals("5")) {
					form6 = "营养不良";
				} else if (storeValueList[9].equals("6")) {
					form6 = "佝偻病";
				} else if (storeValueList[9].equals("7")) {
					form6 = "因腹泻住院";
				} else if (storeValueList[9].equals("8")) {
					form6 = "因外伤住院";
				} else if (storeValueList[9].equals("9")) {
					form6 = "其他";
				}

				if (storeValueList[10].equals("2")) {
					form7 = "肺炎";
				} else if (storeValueList[10].equals("3")) {
					form7 = "麻疹";
				} else if (storeValueList[10].equals("4")) {
					form7 = "贫血";
				} else if (storeValueList[10].equals("5")) {
					form7 = "营养不良";
				} else if (storeValueList[10].equals("6")) {
					form7 = "佝偻病";
				} else if (storeValueList[10].equals("7")) {
					form7 = "因腹泻住院";
				} else if (storeValueList[10].equals("8")) {
					form7 = "因外伤住院";
				} else if (storeValueList[10].equals("9")) {
					form7 = "其他";
				}

				if (storeValueList[11].equals("2")) {
					form8 = "肺炎";
				} else if (storeValueList[11].equals("3")) {
					form8 = "麻疹";
				} else if (storeValueList[11].equals("4")) {
					form8 = "贫血";
				} else if (storeValueList[11].equals("5")) {
					form8 = "营养不良";
				} else if (storeValueList[11].equals("6")) {
					form8 = "佝偻病";
				} else if (storeValueList[11].equals("7")) {
					form8 = "因腹泻住院";
				} else if (storeValueList[11].equals("8")) {
					form8 = "因外伤住院";
				} else if (storeValueList[11].equals("9")) {
					form8 = "其他";
				}

			}
			HValue = line1 + "/" + line2 + "/" + line3 + "/" + line4
					+ form1 + "/" + form2 + "/" + form3 + "/" + form4 + "/"
					+ form5 + "/" + form6 + "/" + form7 + "/" + form8;
			top();
			return;
		}
		public HistoryOfSickMeta(){
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
