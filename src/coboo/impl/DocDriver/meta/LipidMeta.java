 package coboo.impl.DocDriver.meta;


/**
	 * 辅助检查--血脂 lipid
	 * HR51_03_112,HR51_03_109,HR51_03_110,HR51_03_111
	 */
public	class LipidMeta extends Meta {
		public String metaname="辅助检查--血脂";
		String[] SIds = new String[]{"zdgc:HR51_03_112","gysz:HR51_03_109","xqdmddbdgc:HR51_03_110","xqgmdzdbdgc:HR51_03_111"};
		String[] SValues = new String[]{"","","",""};
		String HValue;	

		void con_hvalue2svalue(String humanReadValue) {
			
			String[] readValueList = new String[4];	
			readValueList =	humanReadValue.split("/");
			SValues[0] = readValueList[0];
			SValues[1] = readValueList[1];
			SValues[2] = readValueList[2];
			SValues[3] = readValueList[3];
			top();
			return;
		}
		void con_svalue2hvalue(String[] storeValueList) {
			
			HValue = 	storeValueList[0]+"/"+storeValueList[1]+"/"+
								storeValueList[2]+"/"+storeValueList[3];
			top();
			return;
		}
		public LipidMeta(){
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