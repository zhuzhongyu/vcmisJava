 package coboo.impl.DocDriver.meta;



/**
	 * 生活方式--职业暴露情况 Occupational exposures 
	 * HR51_01_191_04,HR51_01_192,HR51_01_191_01,
	 * HR51_01_191_02_01,HR51_01_193_1,HR51_01_191_02_11,
	 * HR51_01_191_02_02,HR51_01_193_2,HR51_01_191_02_12,
	 * HR51_01_191_02_03,HR51_01_193_3,HR51_01_191_02_13
	 */
public	class OccupationExposuresMeta extends Meta {
		public String metaname="生活方式--职业暴露情况 ";
		String[] SIds = new String[]{
				"zyblqkjtzy:HR51_01_191_04","cysj1:HR51_01_192","cysj0:HR51_01_191_01","s3","s4",
				"s5","sx:HR51_01_191_02_03","fhcx31:HR51_01_193_3","fhcs32","dp:HR51_01_191_02_02",
				"fhcx21:HR51_01_193_2","fhcs22:HR51_01_191_02_12","hxp:HR51_01_191_02_01" ,"fhcs11:HR51_01_193_1","fhcs12:HR51_01_191_02_11",
				"s15","s16"};
		String[] SValues = new String[]{
				"","","","","",
				"","","","","",
				"","","","","",
				"",""};
		String HValue;	

		void con_hvalue2svalue(String humanReadValue) {
			
			String[] readValueList = new String[12];	
			readValueList =	humanReadValue.split("/");
			if(readValueList[2].equals("1")) {
				
				SValues[2] = "1";
				SValues[0] = SValues[1]  = SValues[3]  = SValues[4] =
					SValues[5] = SValues[6]  = SValues[7]  = SValues[8] = 
						SValues[9] = SValues[10] = SValues[11] = "";
			}else {
				
				for(int i =0 ;i<readValueList.length;i++) {
					SValues[i] = readValueList[i];
				}
				if(readValueList[5].equals("2")){
					SValues[4]="";
				}
				if(readValueList[8].equals("2")){
					SValues[7]="";
				}
				if(readValueList[11].equals("2")){
					SValues[10]="";
				}
			}
			top();
			return;
		}
		void con_svalue2hvalue(String[] storeValueList) {
			HValue = "";
			for(int i =0;i<storeValueList.length;i++) {
				if(i<(storeValueList.length-1)) {
					HValue += storeValueList[i]+"/";
				}else {
					HValue += storeValueList[i];
				}
			}
			top();
			return;
		}
		public OccupationExposuresMeta(){
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