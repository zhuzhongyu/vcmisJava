 package coboo.impl.DocDriver.meta;


/**
	 * 脏器功能--视力 vision
	 */
public	class VisionMeta extends Meta {
		public String metaname="脏器功能--视力";
		String[] SIds = new String[]{"zy1:HR51_02_171","yy1:HR51_02_167","zy2:HR51_02_169","yyy2:HR51_02_166"};
		String[] SValues = new String[]{""};
		String HValue;	

		void con_hvalue2svalue(String humanReadValue) {
			
			String[] readValueList = new String[4];	
			readValueList =	humanReadValue.split("/");
			for(int i =0;i<readValueList.length;i++) {
				SValues[i] = readValueList[i];
			}top();
			return;
		}
		void con_svalue2hvalue(String[] storeValueList) {
			
			HValue="";
			for(int i =0;i<storeValueList.length;i++){
				if(i<(storeValueList.length-1)){
					HValue += storeValueList[i]+"/";
				}else{
					HValue += storeValueList[i];
				}
			}top();
			return;
		}
		public VisionMeta(){
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