 package coboo.impl.DocDriver.meta;


	/**
	 * 辅助检查--肝功能 Liver function
	 * HR51_03_016,cbxqgczam",HR51_03_102,HR51_03_105,HR51_03_104
	 */
public	class LiverFunctionMeta extends Meta {
		public String metaname="辅助检查--肝功能";
		String[] SIds = new String[]{"xqgbzal:HR51_03_016","xqgczam:cbxqgczam","ggnbdb:HR51_03_102_1","ggnzdhx:HR51_03_105","jtdhs:HR51_03_104"};
		String[] SValues = new String[]{"","","","",""};
		String HValue;	

		
		void con_hvalue2svalue(String humanReadValue) {
			
			String[] readValueList = new String[5];	
			readValueList =	humanReadValue.split("/");
			SValues[0] = readValueList[0];
			SValues[1] = readValueList[1];
			SValues[2] = readValueList[2];
			SValues[3] = readValueList[3];
			SValues[4] = readValueList[4];
			top();
			return;
		}
		
		void con_svalue2hvalue(String[] storeValueList) {
			
			HValue = 	storeValueList[0]+"/"+storeValueList[1]+"/"+
			storeValueList[2]+"/"+storeValueList[3]+"/"+
								storeValueList[4];
			top();
			return;
		}
		public LiverFunctionMeta(){
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