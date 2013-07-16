 package coboo.impl.DocDriver.meta;


/**
	 * 新生儿听力筛查
	 * 
	 * @author 任笑言 对应字段 HR51_02_181
	 * 
	 */
public	class NewbornHearingScreeningMeta extends Meta {
		public String metaname="新生儿听力筛查";
		String[] SIds = new String[]{"xm18:HR51_02_181"};
		String[] SValues = new String[]{""};
		String HValue;	
	

		void con_hvalue2svalue(String humanReadValue) {
			if (humanReadValue.equals("通过")) {
				SValues[0] = "1";
			} else if (humanReadValue.equals("未通过")) {
				SValues[0] = "2";
			} else if (humanReadValue.equals("未筛查")) {
				SValues[0] = "3";
			}	
			top();
			return;
		}

		void con_svalue2hvalue(String[] storeValueList) {
			if (storeValueList[0].equals("1")) {
				HValue = "通过";
			} else if (storeValueList[0].equals("2")) {
				HValue = "未通过";
			} else if (storeValueList[0].equals("3")) {
				HValue = "未筛查";
			}	
			top();
			return;
		}
		public NewbornHearingScreeningMeta(){
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