 package coboo.impl.DocDriver.meta;

	/**
	 * 过敏史 对应字段
	 * 
	 * @author 任笑言 HR51_01_003,HR51_01_003_2
	 */
public	class HistoryOfAllergyMeta extends Meta {
		public String metaname="过敏史";
		String[] SIds = new String[]{"gm1",
				"gm12" };
		String[] SValues = new String[]{"",""};
		String HValue;	

		void con_hvalue2svalue(String humanReadValue) {
			String readValueList[] = new String[2];
			readValueList = humanReadValue.split("/");
			if (readValueList[0].equals("") && readValueList[1].equals("无")) {
				SValues[0] = "";
				SValues[1] = "1";
			} else {
				SValues[0] = readValueList[0];
				SValues[1] = "2";
			}
			top();
			return;
		}

		void con_svalue2hvalue(String[] storeValueList) {
			String line = "";
			String form = "";
			if (storeValueList[0].equals("") && storeValueList[1].equals("1")) {
				form = "无";
			} else {
				line = storeValueList[0];
				form = "有";
			}
			HValue = line + "/" + form;
			top();
			return;
		}
		public HistoryOfAllergyMeta(){
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