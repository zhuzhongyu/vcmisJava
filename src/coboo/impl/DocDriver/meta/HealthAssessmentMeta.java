 package coboo.impl.DocDriver.meta;



/**
	 * 健康评价 Health assessment
	 * HR55_02_031_1,HR55_02_031_2,HR55_02_031_3,HR55_02_031_4,HR55_02_031_5
	 */
public	class HealthAssessmentMeta extends Meta {
		public String metaname="健康评价";
		String[] SIds = new String[]{"tjwyc:HR0","yc1","yc2","yc3","yc4"};
		String[] SValues = new String[]{"","","","",""};
		String HValue;	

		void con_hvalue2svalue(String humanReadValue) {
			String[] readValueList = new String[5];	
			readValueList =	humanReadValue.split("/");
			if(readValueList[0].equals("1")){
				SValues[0]="1";
				SValues[1]="";
				SValues[2]="";
				SValues[3]="";
				SValues[4]="";
			}else{
				for(int i =0;i<readValueList.length;i++){
					SValues[i] = readValueList[i];
				}
			}top();
			return;
		}
		void con_svalue2hvalue(String[] storeValueList) {
			
			HValue = "";
			for(int i=0;i<storeValueList.length;i++) {
				
				if(i<(storeValueList.length-1)){
					HValue+=storeValueList[i]+"/";
				}else{
					HValue+=storeValueList[i];
				}
			}top();
			return;
		}
		public HealthAssessmentMeta(){
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