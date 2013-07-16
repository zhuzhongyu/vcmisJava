 package coboo.impl.DocDriver.meta;


/**
	 * 一般状况--老年人情感状态
	 * 
	 * HR55_01_051,HR55_01_050
	 */
public	class ElderlyEmotionalStateMeta extends Meta {
		public String metaname="一般状况--老年人情感状态";
		String[] SIds = new String[]{"lnqgzt2:HR55_01_051","lnqgzt1:HR55_01_050" };
		String[] SValues = new String[]{"",""};
		String HValue;	

		void con_hvalue2svalue(String humanReadValue) {
			String[] readValueList = new String[2];	
			readValueList =	humanReadValue.split("/");
			if(readValueList[0].equals("1")) {
				
				SValues[0] = "1";
				SValues[1] = "";
				
			}else {
				SValues[0] = readValueList[0];
				SValues[1] = readValueList[1];
			}
			top();
			return;
		}

		void con_svalue2hvalue(String[] storeValueList) {
			
			HValue = storeValueList[0]+"/"+storeValueList[1];
			top();
			return;
		}
		public ElderlyEmotionalStateMeta(){
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