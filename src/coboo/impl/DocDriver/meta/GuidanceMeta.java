 package coboo.impl.DocDriver.meta;

	/**
	 * 指导 对应字段 cbzd1,cbzd2,cbzd3,cbzd4
	 * 
	 * @author 任笑言
	 */
public	class GuidanceMeta extends Meta {
		public String metaname="指导";
		String[] SIds = new String[]{"cbzd1:zd1:HR54_02_010_01", "cbzd2:zd2:HR54_02_010_02",
				"cbzd3:zd3:HR54_02_010_03", "cbzd4:zd4:HR54_02_010_04","s4:zd5:HR54_02_010_06","s5"};
		String[] SValues = new String[]{"","","","","",""};
		String HValue;	

		void con_hvalue2svalue(String humanReadValue) {
			String readValueList[] = new String[4];
			readValueList = humanReadValue.split("/");
			SValues[0] = readValueList[0];

			if (SValues[1].equals("膳食指导")) {
				SValues[1] = "1";
			} else if (SValues[1].equals("预防意外伤害")) {
				SValues[1] = "2";
			} else if (SValues[1].equals("疾病预防")) {
				SValues[1] = "3";
			}

			if (SValues[2].equals("膳食指导")) {
				SValues[2] = "1";
			} else if (SValues[2].equals("预防意外伤害")) {
				SValues[2] = "2";
			} else if (SValues[2].equals("疾病预防")) {
				SValues[2] = "3";
			}

			if (SValues[3].equals("膳食指导")) {
				SValues[3] = "1";
			} else if (SValues[3].equals("预防意外伤害")) {
				SValues[3] = "2";
			} else if (SValues[3].equals("疾病预防")) {
				SValues[3] = "3";
			}
			top();
			return;
		}

		void con_svalue2hvalue(String[] storeValueList) {
			String line = "";
			String form1 = "";
			String form2 = "";
			String form3 = "";
			line = storeValueList[0];

			if (storeValueList[1].equals("1")) {
				form1 = "膳食指导";
			} else if (storeValueList[1].equals("2")) {
				form1 = "预防意外伤害";
			} else if (storeValueList[1].equals("3")) {
				form1 = "疾病预防";
			}

			if (storeValueList[2].equals("1")) {
				form2 = "膳食指导";
			} else if (storeValueList[2].equals("2")) {
				form2 = "预防意外伤害";
			} else if (storeValueList[2].equals("3")) {
				form2 = "疾病预防";
			}

			if (storeValueList[3].equals("1")) {
				form3 = "膳食指导";
			} else if (storeValueList[3].equals("2")) {
				form3 = "预防意外伤害";
			} else if (storeValueList[3].equals("3")) {
				form3 = "疾病预防";
			}
			HValue = line + "/" + form1 + "/" + form2 + "/" + form3;
			top();
			return;
		}
		public GuidanceMeta(){
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
